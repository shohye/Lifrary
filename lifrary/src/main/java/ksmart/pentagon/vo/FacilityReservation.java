package ksmart.pentagon.vo;

public class FacilityReservation {
	private String frCode;
	private String lCode;
	private String uId;
	private String fCode;
	private String frSelectNum;
	private String frTel;
	private String frExtension;
	private String frReserveDate;
	private String frEndDate;

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
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

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getFrSelectNum() {
		return frSelectNum;
	}

	public void setFrSelectNum(String frSelectNum) {
		this.frSelectNum = frSelectNum;
	}

	public String getFrTel() {
		return frTel;
	}

	public void setFrTel(String frTel) {
		this.frTel = frTel;
	}

	public String getFrExtension() {
		return frExtension;
	}

	public void setFrExtension(String frExtension) {
		this.frExtension = frExtension;
	}

	public String getFrReserveDate() {
		return frReserveDate;
	}

	public void setFrReserveDate(String frReserveDate) {
		this.frReserveDate = frReserveDate;
	}

	public String getFrEndDate() {
		return frEndDate;
	}

	public void setFrEndDate(String frEndDate) {
		this.frEndDate = frEndDate;
	}

	@Override
	public String toString() {
		return "FacilityReservation [frCode=" + frCode + ", lCode=" + lCode + ", uId=" + uId + ", fCode=" + fCode
				+ ", frSelectNum=" + frSelectNum + ", frTel=" + frTel + ", frExtension=" + frExtension
				+ ", frReserveDate=" + frReserveDate + ", frEndDate=" + frEndDate + "]";
	}

}
