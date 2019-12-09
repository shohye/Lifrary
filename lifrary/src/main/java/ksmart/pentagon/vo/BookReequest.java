package ksmart.pentagon.vo;

public class BookReequest {
	
	private String brCode;
	private String brTitle;
	private String brIsbn;
	private String brYear;
	private int brPrice;
	private String brAuthor;
	private String brPublisher;
	private String brProgress;
	private String brCancleReason;
	private String brDate;
	
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	public String getBrTitle() {
		return brTitle;
	}
	public void setBrTitle(String brTitle) {
		this.brTitle = brTitle;
	}
	public String getBrIsbn() {
		return brIsbn;
	}
	public void setBrIsbn(String brIsbn) {
		this.brIsbn = brIsbn;
	}
	public String getBrYear() {
		return brYear;
	}
	public void setBrYear(String brYear) {
		this.brYear = brYear;
	}
	public int getBrPrice() {
		return brPrice;
	}
	public void setBrPrice(int brPrice) {
		this.brPrice = brPrice;
	}
	public String getBrAuthor() {
		return brAuthor;
	}
	public void setBrAuthor(String brAuthor) {
		this.brAuthor = brAuthor;
	}
	public String getBrPublisher() {
		return brPublisher;
	}
	public void setBrPublisher(String brPublisher) {
		this.brPublisher = brPublisher;
	}
	public String getBrProgress() {
		return brProgress;
	}
	public void setBrProgress(String brProgress) {
		this.brProgress = brProgress;
	}
	public String getBrCancleReason() {
		return brCancleReason;
	}
	public void setBrCancleReason(String brCancleReason) {
		this.brCancleReason = brCancleReason;
	}
	public String getBrDate() {
		return brDate;
	}
	public void setBrDate(String brDate) {
		this.brDate = brDate;
	}
	
	@Override
	public String toString() {
		return "BookReequest [brCode=" + brCode + ", brTitle=" + brTitle + ", brIsbn=" + brIsbn + ", brYear=" + brYear
				+ ", brPrice=" + brPrice + ", brAuthor=" + brAuthor + ", brPublisher=" + brPublisher + ", brProgress="
				+ brProgress + ", brCancleReason=" + brCancleReason + ", brDate=" + brDate + "]";
	}
	
	
	
	
	
	

}
