package ksmart.pentagon.vo;

public class BookCate {
	
	private String bclCode;  //bcl_code
	private String lCode;    //l_code
	private String bclName;  //bcl_name
	
	private String bcmCode;  //bcm_code
	private String bcmName;  //bcm_name
	
	
	public String getBclCode() {
		return bclCode;
	}
	public void setBclCode(String bclCode) {
		this.bclCode = bclCode;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getBclName() {
		return bclName;
	}
	public void setBclName(String bclName) {
		this.bclName = bclName;
	}
	public String getBcmCode() {
		return bcmCode;
	}
	public void setBcmCode(String bcmCode) {
		this.bcmCode = bcmCode;
	}
	public String getBcmName() {
		return bcmName;
	}
	public void setBcmName(String bcmName) {
		this.bcmName = bcmName;
	}
	
	
	@Override
	public String toString() {
		return "BookCate [bclCode=" + bclCode + ", lCode=" + lCode + ", bclName=" + bclName + ", bcmCode=" + bcmCode
				+ ", bcmName=" + bcmName + "]";
	}
	
	
	
	
}
