package ksmart.pentagon.vo;

public class UserLevelHistory {

	private String ulhCode;
	private String lCode;
	private String uId;
	private String uName;
	private String ulLevel;
	private String ulName;
	private String ulhReason;
	private String ulhDate;
	
	public String getUlhCode() {
		return ulhCode;
	}
	public void setUlhCode(String ulhCode) {
		this.ulhCode = ulhCode;
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
	public String getUlLevel() {
		return ulLevel;
	}
	public void setUlLevel(String ulLevel) {
		this.ulLevel = ulLevel;
	}
	public String getUlName() {
		return ulName;
	}
	public void setUlName(String ulName) {
		this.ulName = ulName;
	}
	public String getUlhReason() {
		return ulhReason;
	}
	public void setUlhReason(String ulhReason) {
		this.ulhReason = ulhReason;
	}
	public String getUlhDate() {
		return ulhDate;
	}
	public void setUlhDate(String ulhDate) {
		this.ulhDate = ulhDate;
	}
	@Override
	public String toString() {
		return "UserLevelHistory [ulhCode=" + ulhCode + ", lCode=" + lCode + ", uId=" + uId + ", uName=" + uName
				+ ", ulLevel=" + ulLevel + ", ulName=" + ulName + ", ulhReason=" + ulhReason + ", ulhDate=" + ulhDate
				+ "]";
	}

	
}
