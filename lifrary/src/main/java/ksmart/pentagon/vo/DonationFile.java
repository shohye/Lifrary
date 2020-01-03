package ksmart.pentagon.vo;

public class DonationFile {
	
	private String fileCode;  
	private String uId;          // 파일 올린 사서 id
	private String lCode; 		 // 도서관 코드
    private String fileName;     // 저장할 파일
    private String fileOriName;  // 실제 파일
    private String fileUrl;      // 파일 위치
    
    
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
 
    
 
 
    


}
