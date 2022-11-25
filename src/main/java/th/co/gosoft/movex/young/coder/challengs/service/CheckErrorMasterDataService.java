package th.co.gosoft.movex.young.coder.challengs.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

import th.co.gosoft.movex.young.coder.challengs.repository.OrderSumRepository;


@Service
public class CheckErrorMasterDataService {
	@Autowired
	OrderSumRepository orderSumRepository;
	
	@Value("${line.notify.url}")
	private String LINE_NOTIFY_URL;

	@Value("${line.notify.token}")
	private String TOKEN;
	
	@Value("${aws.access}")
	private String AWS_ACCESS;

	@Value("${aws.secret}")
	private String AWS_SECRET;
	
	@Value("${aws.s3.bucket}")
	private String S3_BUCKET;

	@Value("${aws.s3.file.path}")
	private String S3_FILEPATH;
	
	private static final String[] FILE_HEADER = {"D_PICK","S_EXTERN_ORDERNO","S_TH_INVOICE","I_BOXID"};
	
	public void checkErrorMasterDataService() throws Exception {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		List<String[]> errorData = orderSumRepository.findErrorData();
		if(errorData !=null) {
			String url = uploadFileToS3(writeExcel(errorData));
			map.add("message", "Found Master Data Error : "+url);
			callLineNotify(map);
		}
	}
	private byte[] writeExcel(List<String[]> errorDataList) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();		
		ByteArrayOutputStream bos =null;
		Row row =null;
		Cell cell=null;
		int rownum=0;
		try {
			CellStyle headerStyle = bodyStyle(workbook,boldfontSize12(workbook));
			CellStyle bodyStyle = bodyStyle(workbook,fontSize12(workbook));
			CellStyle bodyRedStyle = bodyStyle(workbook,fontRedSize12(workbook));
			XSSFSheet sheet = workbook.createSheet();
			row = sheet.createRow(rownum);
			for(int i=0;i< FILE_HEADER.length;i++) {
				sheet.autoSizeColumn(i);
				cell = row.createCell(i);
				cell.setCellValue(FILE_HEADER[i]);
				cell.setCellStyle(headerStyle);
			}
			rownum++;
			for(String[] errorData: errorDataList) {
				row = sheet.createRow(rownum);
				for(int i=0;i<errorData.length;i++) {
					sheet.autoSizeColumn(i);
					cell = row.createCell(i);
					if(errorData[i] == null || errorData[i].equals("null")) {
						cell.setCellValue("null");
						cell.setCellStyle(bodyRedStyle);
					}
					else {
						cell.setCellValue(errorData[i]);
						cell.setCellStyle(bodyStyle);
					}
				}
				rownum++;
			}
			bos = new ByteArrayOutputStream();
			workbook.write(bos);
			return bos.toByteArray();
		}finally {
			if(bos != null)
		 		bos.close();
			if(workbook != null)
		 		workbook.close();
		 	System.out.println("complete.");
		}
	}
	
	private String uploadFileToS3(byte[] byteData) {
		String pattern = "dd.MM.yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		S3Service s3client = new S3Service(AWS_ACCESS, AWS_SECRET);
		InputStream input = new ByteArrayInputStream(byteData);
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(byteData.length);
		String s3FileName = "Meta_Data_error_"+date+".xlsx";
		s3client.putObject(S3_BUCKET+"/"+S3_FILEPATH, s3FileName, input, metadata);
//		URL s3Url = s3client.getUrl(S3_BUCKET+"/"+S3_FILEPATH, s3FileName);
//		return decodeValue(s3Url.toExternalForm());
		return generateURL(S3_FILEPATH+"/"+s3FileName);
	}
	
	private String generateURL(String key_file) {
		 AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                 .withRegion(Regions.AP_SOUTHEAST_1)
                 .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(AWS_ACCESS,AWS_SECRET)))
                 .build();
		URL url = null; 
		// Set the presigned URL to expire after 24 hours.
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60 * 24;
        expiration.setTime(expTimeMillis);
		GeneratePresignedUrlRequest generatePresignedUrlRequest = 
                new GeneratePresignedUrlRequest(S3_BUCKET, key_file)
                .withMethod(HttpMethod.GET)
                .withExpiration(expiration);
		url = s3client.generatePresignedUrl(generatePresignedUrlRequest);
		return url.toString();
		
	}
	
	private String decodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
	
	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, Object> callLineNotify(MultiValueMap<String, Object> map) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		if (map.get("imageFile") != null) {
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		} else {
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		}
		headers.add("Authorization", "Bearer " + TOKEN);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
		return restTemplate.postForObject(LINE_NOTIFY_URL, request, LinkedHashMap.class);
	}
	
	private Font fontSize12(XSSFWorkbook workbook) {
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
	    return font; 
	}
	
	private Font boldfontSize12(XSSFWorkbook workbook) {
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 12);
	    return font; 
	}
	
	private Font fontRedSize12(XSSFWorkbook workbook) {
		Font font = workbook.createFont();
		font.setColor(IndexedColors.RED.index);
		font.setFontHeightInPoints((short) 12);
	    return font; 
	}
	
	private CellStyle bodyStyle(XSSFWorkbook workbook,Font font) {
		CellStyle body = workbook.createCellStyle();
	    body.setFont(font);
	    body.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    body.setFillForegroundColor(IndexedColors.WHITE.index);
	    body.setBorderBottom(BorderStyle.THIN);
	    body.setBorderTop(BorderStyle.THIN);
	    body.setBorderRight(BorderStyle.THIN);
	    body.setBorderLeft(BorderStyle.THIN);
	    return body;
	}
}
