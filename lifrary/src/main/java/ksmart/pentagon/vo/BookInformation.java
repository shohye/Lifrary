package ksmart.pentagon.vo;

public class BookInformation {
	private String biIsbn;
	private String biName;
	private String biYear;
	private String biAuthor;
	private String biPublisher;
	private String biKdc;
	private String biImg;
	private String biDate;
	private String biDtail;
	
	
	public String getBiDtail() {
		if(biDtail != null && "".equals(biDtail.trim())) this.biDtail = null;
		return biDtail;
	}
	public void setBiDtail(String biDtail) {
		this.biDtail = biDtail;
	}
	public String getBiIsbn() {
		return biIsbn;
	}
	public void setBiIsbn(String biIsbn) {
		this.biIsbn = biIsbn;
	}
	
	public String getBiName() {
		if(biName != null && "".equals(biName.trim())) this.biName = null;
		return biName;
	}
	public void setBiName(String biName) {
		this.biName = biName;
	}
	public String getBiYear() {
		if(biYear != null && "".equals(biYear.trim())) this.biYear = null;
		return biYear;
	}
	public void setBiYear(String biYear) {
		this.biYear = biYear;
	}
	public String getBiAuthor() {
		if(biAuthor != null && "".equals(biAuthor.trim())) this.biAuthor = null;
		return biAuthor;
	}
	public void setBiAuthor(String biAuthor) {
		this.biAuthor = biAuthor;
	}
	public String getBiPublisher() {
		if(biPublisher != null && "".equals(biPublisher.trim())) this.biPublisher = null;
		return biPublisher;
	}
	public void setBiPublisher(String biPublisher) {
		this.biPublisher = biPublisher;
	}
	public String getBiKdc() {
		if(biKdc != null && "".equals(biKdc.trim())) this.biKdc = null;
		return biKdc;
	}
	public void setBiKdc(String biKdc) {
		this.biKdc = biKdc;
	}
	public String getBiImg() {
		if(biImg != null && "".equals(biImg.trim())) this.biImg = null;
		return biImg;
	}
	public void setBiImg(String biImg) {
		this.biImg = biImg;
	}
	public String getBiDate() {
		if(biDate != null && "".equals(biDate.trim())) this.biDate = null;
		return biDate;
	}
	public void setBiDate(String biDate) {
		this.biDate = biDate;
	}
}
