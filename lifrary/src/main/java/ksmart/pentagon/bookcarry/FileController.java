package ksmart.pentagon.bookcarry;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ksmart.pentagon.vo.DonationFile;

public class FileController {
	
	@Autowired private FileService fileService;
	
	@RequestMapping("/uploadFile")
    private String boardInsertProc(HttpServletRequest request
    		, HttpSession session   		
    		, @RequestPart MultipartFile files) throws Exception{
        
		String said = (String) session.getAttribute("SAID");
		String lCode = (String) session.getAttribute("LIBNUM");
		
		DonationFile  file  = new DonationFile();
        
        
        if(files.isEmpty() == false){ //업로드할 파일이 있을때

            String fileName = StringUtils.cleanPath(files.getOriginalFilename()); 
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
            File destinationFile; 
            String destinationFileName; 
            String fileUrl = "/Users/Administrator/git/Lifrary/lifrary/src/main/resources/static/file";
            
            do { 
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
                destinationFile = new File(fileUrl+ destinationFileName); 
            } while (destinationFile.exists()); 
            
            destinationFile.getParentFile().mkdirs(); 
            files.transferTo(destinationFile); 

            file.setFileCode("df001");
            file.setuId(said);
            file.setlCode(lCode);
            file.setFileName(destinationFileName);
            file.setFileOriName(fileName);
            file.setFileUrl(fileUrl);
            
            fileService.fileInsert(file); //file insert
        }
        
        
        return null;
    }

}
