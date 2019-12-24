package ksmart.pentagon.vo;

public class BookRequest {
	
	private String brCode;
	private String uId;
	private String lCode;
	private String brTitle;
	private String brIsbn;
	private String brYear;
	private String brPrice;
	private String brAuthor;
	private String brPublisher;
	private String brOpinion;
	private String brProgress;
	private String brCancelReason;
	private String brDate;
	
	private User user;

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getlCode() {
		return lCode;
	}

	public void setlCode(String lCode) {
		this.lCode = lCode;
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

	public String getBrPrice() {
		return brPrice;
	}

	public void setBrPrice(String brPrice) {
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

	public String getBrOpinion() {
		return brOpinion;
	}

	public void setBrOpinion(String brOpinion) {
		this.brOpinion = brOpinion;
	}

	public String getBrProgress() {
		return brProgress;
	}

	public void setBrProgress(String brProgress) {
		this.brProgress = brProgress;
	}

	public String getBrCancelReason() {
		return brCancelReason;
	}

	public void setBrCancelReason(String brCancelReason) {
		this.brCancelReason = brCancelReason;
	}

	public String getBrDate() {
		return brDate;
	}

	public void setBrDate(String brDate) {
		this.brDate = brDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookRequest [brCode=" + brCode + ", uId=" + uId + ", lCode=" + lCode + ", brTitle=" + brTitle
				+ ", brIsbn=" + brIsbn + ", brYear=" + brYear + ", brPrice=" + brPrice + ", brAuthor=" + brAuthor
				+ ", brPublisher=" + brPublisher + ", brOpinion=" + brOpinion + ", brProgress=" + brProgress
				+ ", brCancelReason=" + brCancelReason + ", brDate=" + brDate + ", user=" + user + "]";
	}
	
	
}
