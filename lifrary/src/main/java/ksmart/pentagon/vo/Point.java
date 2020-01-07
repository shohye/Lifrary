package ksmart.pentagon.vo;

public class Point {
	private String pCode;
	private String lCode;
	private String uId;
	private String uName;
	private String uNumber;
	private String pName;
	private String pStandard;
	private int pPoint;
	private String pDate;
	private String phCode;
	private int sumPoint;//누적포인트
	private String phDate;

	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
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
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuNumber() {
		return uNumber;
	}
	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpStandard() {
		return pStandard;
	}
	public void setpStandard(String pStandard) {
		this.pStandard = pStandard;
	}
	public int getpPoint() {
		return pPoint;
	}
	public void setpPoint(int pPoint) {
		this.pPoint = pPoint;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getPhCode() {
		return phCode;
	}
	public void setPhCode(String phCode) {
		this.phCode = phCode;
	}
	public int getSumPoint() {
		return sumPoint;
	}
	public void setSumPoint(int sumPoint) {
		this.sumPoint = sumPoint;
	}
	public String getPhDate() {
		return phDate;
	}
	public void setPhDate(String phDate) {
		this.phDate = phDate;
	}
	@Override
	public String toString() {
		return "Point [pCode=" + pCode + ", lCode=" + lCode + ", uId=" + uId + ", uName=" + uName + ", uNumber="
				+ uNumber + ", pName=" + pName + ", pStandard=" + pStandard + ", pPoint=" + pPoint + ", pDate=" + pDate
				+ ", phCode=" + phCode + ", sumPoint=" + sumPoint + ", phDate=" + phDate + "]";
	}
}
