package ksmart.pentagon.bookcarry;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ksmart.pentagon.vo.DonationFile;

public class FileController {
	
	@RequestMapping("/uploadFile")
    private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{
        
        
        String sourceFileName = files.getOriginalFilename(); 
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
        File destinationFile; 
        String destinationFileName;
        String fileUrl = "uploadFiles 폴더 위치";
 
        
        do { 
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
            destinationFile = new File(fileUrl + destinationFileName); 
        } while (destinationFile.exists()); 
        
        destinationFile.getParentFile().mkdirs(); 
        files.transferTo(destinationFile); 
        
        
        return null;
    }

}
