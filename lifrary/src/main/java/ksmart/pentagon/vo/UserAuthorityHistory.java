package ksmart.pentagon.vo;

public class UserAuthorityHistory {

	private String uahCode;
	private String lCode;
	private String uId;
	private String uName;
	private String uasCode;
	private String uasName;
	private String uahReason;
	private String uahDate;
	public String getUahCode() {
		return uahCode;
	}
	public void setUahCode(String uahCode) {
		this.uahCode = uahCode;
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
	public String getUasCode() {
		return uasCode;
	}
	public void setUasCode(String uasCode) {
		this.uasCode = uasCode;
	}
	public String getUasName() {
		return uasName;
	}
	public void setUasName(String uasName) {
		this.uasName = uasName;
	}
	public String getUahReason() {
		return uahReason;
	}
	public void setUahReason(String uahReason) {
		this.uahReason = uahReason;
	}
	public String getUahDate() {
		return uahDate;
	}
	public void setUahDate(String uahDate) {
		this.uahDate = uahDate;
	}
	
	@Override
	public String toString() {
		return "UserAuthorityHistory [uahCode=" + uahCode + ", lCode=" + lCode + ", uId=" + uId + ", uName=" + uName
				+ ", uasCode=" + uasCode + ", uasName=" + uasName + ", uahReason=" + uahReason + ", uahDate=" + uahDate
				+ "]";
	}
	
	
}
