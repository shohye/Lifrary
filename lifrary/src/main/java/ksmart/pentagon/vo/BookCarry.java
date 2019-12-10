package ksmart.pentagon.vo;

public class BookCarry {
	
	private String uid;
	private String lCode;
	private String biIsbn;
	
	private String boCode;
	private String boCompany;
	private int boBookNum;
	private int boPrice;
	private String bosState;
	private String boDate;    // 주문
	
	private String bpCode;
	private int bpPrice;
	private int bpBookNum;
	private String bpAdditional;
	private String bpDate;    // 구매	
		
	private BookInformation bookInformation;
	
	private String bdn_code;
	private String bdn_name;
	private String bdn_addr;
	private String bdn_tel;
	private String bdn_num;
	private String bdn_personal;
	private String bdn_sticker;
	private String bdn_honor_agree;
	private String bdn_date;    // 기증자	

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getBiIsbn() {
		return biIsbn;
	}
	public void setBiIsbn(String biIsbn) {
		this.biIsbn = biIsbn;
	}
	public String getBoCode() {
		return boCode;
	}
	public void setBoCode(String boCode) {
		this.boCode = boCode;
	}
	public String getBoCompany() {
		return boCompany;
	}
	public void setBoCompany(String boCompany) {
		this.boCompany = boCompany;
	}
	public int getBoBookNum() {
		return boBookNum;
	}
	public void setBoBookNum(int boBookNum) {
		this.boBookNum = boBookNum;
	}
	public int getBoPrice() {
		return boPrice;
	}
	public void setBoPrice(int boPrice) {
		this.boPrice = boPrice;
	}
	public String getBosState() {
		return bosState;
	}
	public void setBosState(String bosState) {
		this.bosState = bosState;
	}
	public String getBoDate() {
		return boDate;
	}
	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}
	public String getBpCode() {
		return bpCode;
	}
	public void setBpCode(String bpCode) {
		this.bpCode = bpCode;
	}
	public int getBpPrice() {
		return bpPrice;
	}
	public void setBpPrice(int bpPrice) {
		this.bpPrice = bpPrice;
	}
	public int getBpBookNum() {
		return bpBookNum;
	}
	public void setBpBookNum(int bpBookNum) {
		this.bpBookNum = bpBookNum;
	}
	public String getBpAdditional() {
		return bpAdditional;
	}
	public void setBpAdditional(String bpAdditional) {
		this.bpAdditional = bpAdditional;
	}
	public String getBpDate() {
		return bpDate;
	}
	public void setBpDate(String bpDate) {
		this.bpDate = bpDate;
	}
	
	public BookInformation getBookInformation() {
		return bookInformation;
	}
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}
	
	
	
	
	
	
}
