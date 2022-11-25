package th.co.gosoft.movex.young.coder.challengs.service;

import java.io.InputStream;
import java.net.URL;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

public class S3Service {
	  private final AmazonS3 s3Client;
	    private String accessKey;
	    private String secretKey;
	    
	    public S3Service(String accessKey, String secretKey) {
	        this.accessKey = accessKey;
	        this.secretKey = secretKey;
	        s3Client = createS3Client();
	    }
	    //uploading object
	    /**
	     * @param bucketName    - The name of the bucket to write to.
	     * @param key           - The key for the file to write.
	     * @param input         - The stream of data to upload to Amazon S3.
	     * @param meta
	     * @return
	     */
	    public PutObjectResult putObject(String bucketName, String key, InputStream input,ObjectMetadata meta) {
	    	meta.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        // ByteArrayInputStream input = new ByteArrayInputStream(stream.toByteArray());
	    	PutObjectRequest putObject = new PutObjectRequest(bucketName, key, input, meta);
	    	// putObject.setMetadata(meta);
	        return s3Client.putObject(putObject);
	    }

	    public String getResourceUrl(String bucketName, String key){
	        return ((AmazonS3Client) s3Client).getResourceUrl(bucketName, key);
	    }
	    // Initial S3Clint with Default Credential #INTEG
	    private AmazonS3 createS3Client() {    	
	    //set-up the client
	        return AmazonS3ClientBuilder.standard()
								          .withRegion(Regions.AP_SOUTHEAST_1)
								          .withCredentials(
	                                        new AWSStaticCredentialsProvider(
	                                            new BasicAWSCredentials(this.accessKey,this.secretKey)))
								          .build();
	    }
	    
	    public S3Object getObject(String bucketName, String url) {
	        return s3Client.getObject(bucketName,url);
	    }
	    public URL getUrl(String s3Bucket, String string) {
	        return s3Client.getUrl(s3Bucket, string);
	    }
}
