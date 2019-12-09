package ksmart.pentagon.vo;

public class User {
	private String uId;
	private String lCode;
	private String ulLevel;
	private String uDivision;
	private String uasCode;
	private String uNumber;
	private String uPw;
	private String uName;
	private String uBirth;
	private String uAddr;
	private String uTel;
	private String uEmail;
	private String uEmailAgree;
	private String uAppointment;
	private int uOverdueDay;
	private String uDate;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getUlLevel() {
		return ulLevel;
	}
	public void setUlLevel(String ulLevel) {
		this.ulLevel = ulLevel;
	}
	public String getuDivision() {
		return uDivision;
	}
	public void setuDivision(String uDivision) {
		this.uDivision = uDivision;
	}
	public String getUasCode() {
		return uasCode;
	}
	public void setUasCode(String uasCode) {
		this.uasCode = uasCode;
	}
	public String getuNumber() {
		return uNumber;
	}
	public void setuNumber(String uNumber) {
		this.uNumber = uNumber;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuEmailAgree() {
		return uEmailAgree;
	}
	public void setuEmailAgree(String uEmailAgree) {
		this.uEmailAgree = uEmailAgree;
	}
	public String getuAppointment() {
		return uAppointment;
	}
	public void setuAppointment(String uAppointment) {
		this.uAppointment = uAppointment;
	}
	public int getuOverdueDay() {
		return uOverdueDay;
	}
	public void setuOverdueDay(int uOverdueDay) {
		this.uOverdueDay = uOverdueDay;
	}
	public String getuDate() {
		return uDate;
	}
	public void setuDate(String uDate) {
		this.uDate = uDate;
	}
	
	@Override
	public String toString() {
		return "User [uId=" + uId + ", lCode=" + lCode + ", ulLevel=" + ulLevel + ", uDivision=" + uDivision
				+ ", uasCode=" + uasCode + ", uNumber=" + uNumber + ", uPw=" + uPw + ", uName=" + uName + ", uBirth="
				+ uBirth + ", uAddr=" + uAddr + ", uTel=" + uTel + ", uEmail=" + uEmail + ", uEmailAgree=" + uEmailAgree
				+ ", uAppointment=" + uAppointment + ", uOverdueDay=" + uOverdueDay + ", uDate=" + uDate + "]";
	}
	
	
}
