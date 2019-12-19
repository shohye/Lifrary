package ksmart.pentagon.vo;

public class StudyCate {

	private String scCode;
	private String lCode;
	private String uId;
	private String scName;
	private String scDivision;
	private String scDate;
	public String getScCode() {
		return scCode;
	}
	public void setScCode(String scCode) {
		this.scCode = scCode;
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
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getScDivision() {
		return scDivision;
	}
	public void setScDivision(String scDivision) {
		this.scDivision = scDivision;
	}
	public String getScDate() {
		return scDate;
	}
	public void setScDate(String scDate) {
		this.scDate = scDate;
	}
	@Override
	public String toString() {
		return "StudyCate [scCode=" + scCode + ", lCode=" + lCode + ", uId=" + uId + ", scName=" + scName
				+ ", scDivision=" + scDivision + ", scDate=" + scDate + "]";
	}
}
