package ksmart.pentagon.vo;

public class ProgramApply {
	private String paCode;
	private String lCode;
	private String pmCode;
	private String uId; // 신청 아이디
	private String paParticipants; // 참여자명
	private String paGender;
	private String paBirth;
	private String paAddr;
	private String paTel;
	private String paDate;
	
	
	public String getPaCode() {
		return paCode;
	}
	public void setPaCode(String paCode) {
		this.paCode = paCode;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getPmCode() {
		return pmCode;
	}
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getPaParticipants() {
		return paParticipants;
	}
	public void setPaParticipants(String paParticipants) {
		this.paParticipants = paParticipants;
	}
	public String getPaGender() {
		return paGender;
	}
	public void setPaGender(String paGender) {
		this.paGender = paGender;
	}
	public String getPaBirth() {
		return paBirth;
	}
	public void setPaBirth(String paBirth) {
		this.paBirth = paBirth;
	}
	public String getPaAddr() {
		return paAddr;
	}
	public void setPaAddr(String paAddr) {
		this.paAddr = paAddr;
	}
	public String getPaTel() {
		return paTel;
	}
	public void setPaTel(String paTel) {
		this.paTel = paTel;
	}
	public String getPaDate() {
		return paDate;
	}
	public void setPaDate(String paDate) {
		this.paDate = paDate;
	}
	
	
	@Override
	public String toString() {
		return "ProgramApply [paCode=" + paCode + ", lCode=" + lCode + ", pmCode=" + pmCode + ", uId=" + uId
				+ ", paParticipants=" + paParticipants + ", paGender=" + paGender + ", paBirth=" + paBirth + ", paAddr="
				+ paAddr + ", paTel=" + paTel + ", paDate=" + paDate + "]";
	}
		
}
