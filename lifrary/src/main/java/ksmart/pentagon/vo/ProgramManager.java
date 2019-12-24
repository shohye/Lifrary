package ksmart.pentagon.vo;

public class ProgramManager {
	private String pmCode;
	private String lCode;
	private String uId;
	private String pmName;
	private String pmTarget;
	private String pmPlace;
	private String pmStartReceipt;
	private String pmEndReceipt;
	private String pmStartTerm;
	private String pmEndTerm;
	private String pmStartTime;
	private String pmEndTime;
	private String pmProgress;
	private String pmTeacherName;
	private int pmApplicant; // 현재 신청 인원
	private int pmMnop; // maximum number of people ( 최대 신청 인원 )
	private int pmTuition;
	private String pmTel;
	private String pmDetail;
	private String pmFile;
	private String pmDate;
	private ProgramApply programApply;
	
	public String getPmCode() {
		return pmCode;
	}
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
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
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	public String getPmTarget() {
		return pmTarget;
	}
	public void setPmTarget(String pmTarget) {
		this.pmTarget = pmTarget;
	}
	public String getPmPlace() {
		return pmPlace;
	}
	public void setPmPlace(String pmPlace) {
		this.pmPlace = pmPlace;
	}
	public String getPmStartTerm() {
		return pmStartTerm;
	}
	public void setPmStartTerm(String pmStartTerm) {
		this.pmStartTerm = pmStartTerm;
	}
	public String getPmEndTerm() {
		return pmEndTerm;
	}
	public void setPmEndTerm(String pmEndTerm) {
		this.pmEndTerm = pmEndTerm;
	}
	public String getPmStartTime() {
		return pmStartTime;
	}
	public void setPmStartTime(String pmStartTime) {
		this.pmStartTime = pmStartTime;
	}
	public String getPmEndTime() {
		return pmEndTime;
	}
	public void setPmEndTime(String pmEndTime) {
		this.pmEndTime = pmEndTime;
	}
	public String getPmStartReceipt() {
		return pmStartReceipt;
	}
	public void setPmStartReceipt(String pmStartReceipt) {
		this.pmStartReceipt = pmStartReceipt;
	}
	public String getPmEndReceipt() {
		return pmEndReceipt;
	}
	public void setPmEndReceipt(String pmEndReceipt) {
		this.pmEndReceipt = pmEndReceipt;
	}
	public String getPmProgress() {
		return pmProgress;
	}
	public void setPmProgress(String pmProgress) {
		this.pmProgress = pmProgress;
	}
	public String getPmTeacherName() {
		return pmTeacherName;
	}
	public void setPmTeacherName(String pmTeacherName) {
		this.pmTeacherName = pmTeacherName;
	}
	public int getPmTuition() {
		return pmTuition;
	}
	public void setPmTuition(int pmTuition) {
		this.pmTuition = pmTuition;
	}
	public String getPmTel() {
		return pmTel;
	}
	public void setPmTel(String pmTel) {
		this.pmTel = pmTel;
	}
	public String getPmDetail() {
		return pmDetail;
	}
	public void setPmDetail(String pmDetail) {
		this.pmDetail = pmDetail;
	}
	public String getPmFile() {
		return pmFile;
	}
	public void setPmFile(String pmFile) {
		this.pmFile = pmFile;
	}
	public String getPmDate() {
		return pmDate;
	}
	public void setPmDate(String pmDate) {
		this.pmDate = pmDate;
	}
	
	public int getPmMnop() {
		return pmMnop;
	}
	public void setPmMnop(int pmMnop) {
		this.pmMnop = pmMnop;
	}
		
	public int getPmApplicant() {
		return pmApplicant;
	}
	public void setPmApplicant(int pmApplicant) {
		this.pmApplicant = pmApplicant;
	}
	public ProgramApply getProgramApply() {
		return programApply;
	}
	public void setProgramApply(ProgramApply programApply) {
		this.programApply = programApply;
	}
	@Override
	public String toString() {
		return "ProgramManager [pmCode=" + pmCode + ", lCode=" + lCode + ", uId=" + uId + ", pmName=" + pmName
				+ ", pmTarget=" + pmTarget + ", pmPlace=" + pmPlace + ", pmStartTerm=" + pmStartTerm + ", pmEndTerm="
				+ pmEndTerm + ", pmStartTime=" + pmStartTime + ", pmEndTime=" + pmEndTime + ", pmStartReceipt="
				+ pmStartReceipt + ", pmEndReceipt=" + pmEndReceipt + ", pmProgress=" + pmProgress + ", pmTeacherName="
				+ pmTeacherName + ", pmApplicant=" + pmApplicant + ", pmMnop=" + pmMnop + ", pmTuition=" + pmTuition
				+ ", pmTel=" + pmTel + ", pmDetail=" + pmDetail + ", pmFile=" + pmFile + ", pmDate=" + pmDate
				+ ", programApply=" + programApply + "]";
	}
		


	
}
