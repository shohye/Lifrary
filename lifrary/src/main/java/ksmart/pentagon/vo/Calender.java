package ksmart.pentagon.vo;

public class Calender {
	
	private String cCode;
	private String lCode;
	private String uId;
	private String bsCode;
	private int cCurrentPage;
	private String cBookFinish;
	private String cTitle;
	private String cContent;
	private String cStartDate;
	private String cEndDate;
	private String cDate;
	private String biImg;
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
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
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public int getcCurrentPage() {
		return cCurrentPage;
	}
	public void setcCurrentPage(int cCurrentPage) {
		this.cCurrentPage = cCurrentPage;
	}
	public String getcBookFinish() {
		return cBookFinish;
	}
	public void setcBookFinish(String cBookFinish) {
		this.cBookFinish = cBookFinish;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcStartDate() {
		return cStartDate;
	}
	public void setcStartDate(String cStartDate) {
		this.cStartDate = cStartDate;
	}
	public String getcEndDate() {
		return cEndDate;
	}
	public void setcEndDate(String cEndDate) {
		this.cEndDate = cEndDate;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getBiImg() {
		return biImg;
	}
	public void setBiImg(String biImg) {
		this.biImg = biImg;
	}
	@Override
	public String toString() {
		return "Calender [cCode=" + cCode + ", lCode=" + lCode + ", uId=" + uId + ", bsCode=" + bsCode
				+ ", cCurrentPage=" + cCurrentPage + ", cBookFinish=" + cBookFinish + ", cTitle=" + cTitle
				+ ", cContent=" + cContent + ", cStartDate=" + cStartDate + ", cEndDate=" + cEndDate + ", cDate="
				+ cDate + ", biImg=" + biImg + ", getcCode()=" + getcCode() + ", getlCode()=" + getlCode()
				+ ", getuId()=" + getuId() + ", getBsCode()=" + getBsCode() + ", getcCurrentPage()=" + getcCurrentPage()
				+ ", getcBookFinish()=" + getcBookFinish() + ", getcTitle()=" + getcTitle() + ", getcContent()="
				+ getcContent() + ", getcStartDate()=" + getcStartDate() + ", getcEndDate()=" + getcEndDate()
				+ ", getcDate()=" + getcDate() + ", getBiImg()=" + getBiImg() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
