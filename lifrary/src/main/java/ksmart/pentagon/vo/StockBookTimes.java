package ksmart.pentagon.vo;

public class StockBookTimes {

	private String sbtCode;
	private String lCode;
	private String uId;
	private String sbtName;
	private String sbtExplain;
	private int sbtCheckNum;
	private String sbtDate;
	private String llBookStock;	//장서점검 컬럼
	
	
	public String getSbtCode() {
		return sbtCode;
	}
	public void setSbtCode(String sbtCode) {
		this.sbtCode = sbtCode;
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
	public String getSbtName() {
		return sbtName;
	}
	public void setSbtName(String sbtName) {
		this.sbtName = sbtName;
	}
	public String getSbtExplain() {
		return sbtExplain;
	}
	public void setSbtExplain(String sbtExplain) {
		this.sbtExplain = sbtExplain;
	}
	public int getSbtCheckNum() {
		return sbtCheckNum;
	}
	public void setSbtCheckNum(int sbtCheckNum) {
		this.sbtCheckNum = sbtCheckNum;
	}
	public String getSbtDate() {
		return sbtDate;
	}
	public void setSbtDate(String sbtDate) {
		this.sbtDate = sbtDate;
	}
	public String getLlBookStock() {
		return llBookStock;
	}
	public void setLlBookStock(String llBookStock) {
		this.llBookStock = llBookStock;
	}
	@Override
	public String toString() {
		return "StockBookTimes [sbtCode=" + sbtCode + ", lCode=" + lCode + ", uId=" + uId + ", sbtName=" + sbtName
				+ ", sbtExplain=" + sbtExplain + ", sbtCheckNum=" + sbtCheckNum + ", sbtDate=" + sbtDate
				+ ", llBookStock=" + llBookStock + "]";
	}
	
	
	
	
	
}
