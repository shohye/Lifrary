package ksmart.pentagon.vo;

public class BookLend {
	private String blCode; //대출도서코드
	private String lCode; //도서관코드
	private String blId; //대출자아이디
	private String bsCode; //소장도서코드
	private String biIsbn; //isbn
	private String biName; //도서명	
	private String biImg; //이미지
	private String blLendDate; //대출일
	private String blExtensionDate; //연장일
	private String blScheduleDate; //반납예정일
	private String blReturnDate; //반납일
	private String blHoldDate; //예약일
	private int blOverdueDays; //연체일
	public String getBlCode() {
		return blCode;
	}
	public void setBlCode(String blCode) {
		this.blCode = blCode;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getBlId() {
		return blId;
	}
	public void setBlId(String blId) {
		this.blId = blId;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getBiIsbn() {
		return biIsbn;
	}
	public void setBiIsbn(String biIsbn) {
		this.biIsbn = biIsbn;
	}
	public String getBiName() {
		return biName;
	}
	public void setBiName(String biName) {
		this.biName = biName;
	}
	public String getBiImg() {
		return biImg;
	}
	public void setBiImg(String biImg) {
		this.biImg = biImg;
	}
	public String getBlLendDate() {
		return blLendDate;
	}
	public void setBlLendDate(String blLendDate) {
		this.blLendDate = blLendDate;
	}
	public String getBlExtensionDate() {
		return blExtensionDate;
	}
	public void setBlExtensionDate(String blExtensionDate) {
		this.blExtensionDate = blExtensionDate;
	}
	public String getBlScheduleDate() {
		return blScheduleDate;
	}
	public void setBlScheduleDate(String blScheduleDate) {
		this.blScheduleDate = blScheduleDate;
	}
	public String getBlReturnDate() {
		return blReturnDate;
	}
	public void setBlReturnDate(String blReturnDate) {
		this.blReturnDate = blReturnDate;
	}
	public String getBlHoldDate() {
		return blHoldDate;
	}
	public void setBlHoldDate(String blHoldDate) {
		this.blHoldDate = blHoldDate;
	}
	public int getBlOverdueDays() {
		return blOverdueDays;
	}
	public void setBlOverdueDays(int blOverdueDays) {
		this.blOverdueDays = blOverdueDays;
	}
	
	
}
