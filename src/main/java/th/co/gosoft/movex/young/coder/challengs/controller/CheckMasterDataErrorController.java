package th.co.gosoft.movex.young.coder.challengs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import th.co.gosoft.movex.young.coder.challengs.service.CheckErrorMasterDataService;

@Log4j2
@Component
public class CheckMasterDataErrorController implements CommandLineRunner {
	@Autowired 
	CheckErrorMasterDataService checkErrorMasterDataService;
	
	@Override
    public void run(String... args) throws Exception {
    	log.info("___ CHECK MASTER DATA ERROR ___");
    	checkErrorMasterDataService.checkErrorMasterDataService();
    	log.info("___ END CHECK MASTER DATA ERROR ___");

    }
}
