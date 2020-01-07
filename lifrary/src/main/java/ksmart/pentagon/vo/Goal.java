package ksmart.pentagon.vo;

public class Goal {
	private String gCode;
	private String lCode;
	private String uId;
	private String gDivision;
	private int gNum;
	private int lendCount;
	private String gSuccess;
	private String gStartDate;
	private String gEndDate;
	private int percent;
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
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
	public String getgDivision() {
		return gDivision;
	}
	public void setgDivision(String gDivision) {
		this.gDivision = gDivision;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public int getLendCount() {
		return lendCount;
	}
	public void setLendCount(int lendCount) {
		this.lendCount = lendCount;
	}
	public String getgSuccess() {
		return gSuccess;
	}
	public void setgSuccess(String gSuccess) {
		this.gSuccess = gSuccess;
	}
	public String getgStartDate() {
		return gStartDate;
	}
	public void setgStartDate(String gStartDate) {
		this.gStartDate = gStartDate;
	}
	public String getgEndDate() {
		return gEndDate;
	}
	public void setgEndDate(String gEndDate) {
		this.gEndDate = gEndDate;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "Goal [gCode=" + gCode + ", lCode=" + lCode + ", uId=" + uId + ", gDivision=" + gDivision + ", gNum="
				+ gNum + ", lendCount=" + lendCount + ", gSuccess=" + gSuccess + ", gStartDate=" + gStartDate
				+ ", gEndDate=" + gEndDate + "]";
	}
}
