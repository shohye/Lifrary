package ksmart.pentagon.vo;

public class LibrarianLevel {
	private String uId;
	private String lCode;
	private String llInsert;
	private String llCarry;
	private String llBookAdmin;
	private String llStats;
	private String llBookStock;
	private String llUpdate;
	
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
	public String getLlInsert() {
		return llInsert;
	}
	public void setLlInsert(String llInsert) {
		this.llInsert = llInsert;
	}
	public String getLlCarry() {
		return llCarry;
	}
	public void setLlCarry(String llCarry) {
		this.llCarry = llCarry;
	}
	public String getLlBookAdmin() {
		return llBookAdmin;
	}
	public void setLlBookAdmin(String llBookAdmin) {
		this.llBookAdmin = llBookAdmin;
	}
	public String getLlStats() {
		return llStats;
	}
	public void setLlStats(String llStats) {
		this.llStats = llStats;
	}
	public String getLlBookStock() {
		return llBookStock;
	}
	public void setLlBookStock(String llBookStock) {
		this.llBookStock = llBookStock;
	}
	public String getLlUpdate() {
		return llUpdate;
	}
	public void setLlUpdate(String llUpdate) {
		this.llUpdate = llUpdate;
	}
	@Override
	public String toString() {
		return "LibrarianLevel [uId=" + uId + ", lCode=" + lCode + ", llInsert=" + llInsert + ", llCarry=" + llCarry
				+ ", llBookAdmin=" + llBookAdmin + ", llStats=" + llStats + ", llBookStock=" + llBookStock
				+ ", llUpdate=" + llUpdate + "]";
	}
	
	
	
}
