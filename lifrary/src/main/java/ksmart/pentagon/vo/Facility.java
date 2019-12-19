package ksmart.pentagon.vo;

public class Facility {

	private String fCode;
	private String lCode;
	private String uId;
	private String fName; // 시설명
	private String fKinds; // 시설종류
	private String fLocation; //시설위치
	private String fAccommodate; // 수용인원
	private String fGender;
	private String fTerm;
	private String fImg; // 추후 이미지가 아닌 문자열받는것으로 수정
	private String fDate;

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfKinds() {
		return fKinds;
	}

	public void setfKinds(String fKinds) {
		this.fKinds = fKinds;
	}

	public String getfLocation() {
		return fLocation;
	}

	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}

	public String getfAccommodate() {
		return fAccommodate;
	}

	public void setfAccommodate(String fAccommodate) {
		this.fAccommodate = fAccommodate;
	}

	public String getfGender() {
		return fGender;
	}

	public void setfGender(String fGender) {
		this.fGender = fGender;
	}

	public String getfTerm() {
		return fTerm;
	}

	public void setfTerm(String fTerm) {
		this.fTerm = fTerm;
	}

	public String getfImg() {
		return fImg;
	}

	public void setfImg(String fImg) {
		this.fImg = fImg;
	}

	public String getfDate() {
		return fDate;
	}

	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	@Override
	public String toString() {
		return "Facility [fCode=" + fCode + ", lCode=" + lCode + ", uId=" + uId + ", fName=" + fName + ", fKinds="
				+ fKinds + ", fLocation=" + fLocation + ", fAccommodate=" + fAccommodate + ", fGender=" + fGender
				+ ", fTerm=" + fTerm + ", fImg=" + fImg + ", fDate=" + fDate + "]";
	}

}
