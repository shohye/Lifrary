package ksmart.pentagon.vo;

public class BookLend {
	private String blCode; //대출도서코드
	private String uId; //사서아이디
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
	private int ulLendDay; //대출일
	private String uNumber;//회원번호
	private String uName;//회원이름

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
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
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
	public int getUlLendDay() {
		return ulLendDay;
	}
	public void setUlLendDay(int ulLendDay) {
		this.ulLendDay = ulLendDay;
	}
	public String getuNumber() {
		return uNumber;
	}
	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "BookLend [blCode=" + blCode + ", uId=" + uId + ", lCode=" + lCode + ", blId=" + blId + ", bsCode="
				+ bsCode + ", biIsbn=" + biIsbn + ", biName=" + biName + ", biImg=" + biImg + ", blLendDate="
				+ blLendDate + ", blExtensionDate=" + blExtensionDate + ", blScheduleDate=" + blScheduleDate
				+ ", blReturnDate=" + blReturnDate + ", blHoldDate=" + blHoldDate + ", blOverdueDays=" + blOverdueDays
				+ ", ulLendDay=" + ulLendDay + ", uNumber=" + uNumber + ", uName=" + uName + ", getBlCode()="
				+ getBlCode() + ", getlCode()=" + getlCode() + ", getuId()=" + getuId() + ", getBlId()=" + getBlId()
				+ ", getBsCode()=" + getBsCode() + ", getBiIsbn()=" + getBiIsbn() + ", getBiName()=" + getBiName()
				+ ", getBiImg()=" + getBiImg() + ", getBlLendDate()=" + getBlLendDate() + ", getBlExtensionDate()="
				+ getBlExtensionDate() + ", getBlScheduleDate()=" + getBlScheduleDate() + ", getBlReturnDate()="
				+ getBlReturnDate() + ", getBlHoldDate()=" + getBlHoldDate() + ", getBlOverdueDays()="
				+ getBlOverdueDays() + ", getUlLendDay()=" + getUlLendDay() + ", getuNumber()=" + getuNumber()
				+ ", getuName()=" + getuName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
