package ksmart.pentagon.vo;

public class BookCarry {
	
	private String uid;
	private String lCode;
	private String biIsbn;
	
	private String boCode;
	private String boCompany;
	private int boBookNum;
	private String boPrice;
	private String bosState;
	private String boDate;    // 주문
	
	private String bpCode;
	private String bpPrice;
	private int bpBookNum;
	private String bpAdditional;
	private String bpDate;    // 구매	
		
	private BookInformation bookInformation;
	
	private String bdnCode;         //bdn_code
	private String bdnName;         //bdn_name
	private String bdnAddr;         //bdn_addr
	private String bdnTel;          //bdn_tel
	private String bdnNum;          //bdn_num
	private String bdnPersonal;     //bdn_personal
	private String bdnSticker;      //bdn_sticker
	private String bdnHonorAgree;   //bdn_honor_agree
	private String bdnDate;         //bdn_date    => 기증자	
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
	public String getBoPrice() {
		return boPrice;
	}
	public void setBoPrice(String boPrice) {
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
	public String getBpPrice() {
		return bpPrice;
	}
	public void setBpPrice(String bpPrice) {
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
	public String getBdnCode() {
		return bdnCode;
	}
	public void setBdnCode(String bdnCode) {
		this.bdnCode = bdnCode;
	}
	public String getBdnName() {
		return bdnName;
	}
	public void setBdnName(String bdnName) {
		this.bdnName = bdnName;
	}
	public String getBdnAddr() {
		return bdnAddr;
	}
	public void setBdnAddr(String bdnAddr) {
		this.bdnAddr = bdnAddr;
	}
	public String getBdnTel() {
		return bdnTel;
	}
	public void setBdnTel(String bdnTel) {
		this.bdnTel = bdnTel;
	}
	public String getBdnNum() {
		return bdnNum;
	}
	public void setBdnNum(String bdnNum) {
		this.bdnNum = bdnNum;
	}
	public String getBdnPersonal() {
		return bdnPersonal;
	}
	public void setBdnPersonal(String bdnPersonal) {
		this.bdnPersonal = bdnPersonal;
	}
	public String getBdnSticker() {
		return bdnSticker;
	}
	public void setBdnSticker(String bdnSticker) {
		this.bdnSticker = bdnSticker;
	}
	public String getBdnHonorAgree() {
		return bdnHonorAgree;
	}
	public void setBdnHonorAgree(String bdnHonorAgree) {
		this.bdnHonorAgree = bdnHonorAgree;
	}
	public String getBdnDate() {
		return bdnDate;
	}
	public void setBdnDate(String bdnDate) {
		this.bdnDate = bdnDate;
	}
	
	@Override
	public String toString() {
		return "BookCarry [uid=" + uid + ", lCode=" + lCode + ", biIsbn=" + biIsbn + ", boCode=" + boCode
				+ ", boCompany=" + boCompany + ", boBookNum=" + boBookNum + ", boPrice=" + boPrice + ", bosState="
				+ bosState + ", boDate=" + boDate + ", bpCode=" + bpCode + ", bpPrice=" + bpPrice + ", bpBookNum="
				+ bpBookNum + ", bpAdditional=" + bpAdditional + ", bpDate=" + bpDate + ", bookInformation="
				+ bookInformation + ", bdnCode=" + bdnCode + ", bdnName=" + bdnName + ", bdnAddr=" + bdnAddr
				+ ", bdnTel=" + bdnTel + ", bdnNum=" + bdnNum + ", bdnPersonal=" + bdnPersonal + ", bdnSticker="
				+ bdnSticker + ", bdnHonorAgree=" + bdnHonorAgree + ", bdnDate=" + bdnDate + "]";
	}
	

	
	
	
	
}
