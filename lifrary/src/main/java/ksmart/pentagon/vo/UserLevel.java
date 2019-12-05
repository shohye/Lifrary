package ksmart.pentagon.vo;

public class UserLevel {
	private String ulLevel;
	private String lCode;
	private String uId;
	private int ulMin;
	private int ulMax;
	private int ulLendNum;
	private int ulLendDay;
	private String ulDate;
	
	
	public String getUlLevel() {
		return ulLevel;
	}
	public void setUlLevel(String ulLevel) {
		this.ulLevel = ulLevel;
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
	public int getUlMin() {
		return ulMin;
	}
	public void setUlMin(int ulMin) {
		this.ulMin = ulMin;
	}
	public int getUlMax() {
		return ulMax;
	}
	public void setUlMax(int ulMax) {
		this.ulMax = ulMax;
	}
	public int getUlLendNum() {
		return ulLendNum;
	}
	public void setUlLendNum(int ulLendNum) {
		this.ulLendNum = ulLendNum;
	}
	public int getUlLendDay() {
		return ulLendDay;
	}
	public void setUlLendDay(int ulLendDay) {
		this.ulLendDay = ulLendDay;
	}
	public String getUlDate() {
		return ulDate;
	}
	public void setUlDate(String ulDate) {
		this.ulDate = ulDate;
	}
	@Override
	public String toString() {
		return "UserLevel [ulLevel=" + ulLevel + ", lCode=" + lCode + ", uId=" + uId + ", ulMin=" + ulMin + ", ulMax="
				+ ulMax + ", ulLendNum=" + ulLendNum + ", ulLendDay=" + ulLendDay + ", ulDate=" + ulDate + "]";
	}
	
	

	
	
}
