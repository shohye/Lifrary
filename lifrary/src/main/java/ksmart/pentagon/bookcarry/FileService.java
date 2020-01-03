package ksmart.pentagon.bookcarry;

import org.springframework.beans.factory.annotation.Autowired;

import ksmart.pentagon.vo.DonationFile;

public class FileService {
	
	@Autowired private FileMapper fileMapper;
	
	public int fileInsert(DonationFile donationFile) throws Exception{
		 return fileMapper.fileInsert(donationFile);
	}

}
