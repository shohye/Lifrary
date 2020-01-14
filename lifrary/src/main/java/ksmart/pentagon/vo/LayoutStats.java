package ksmart.pentagon.vo;

public class LayoutStats {

	private String libnum;
	private String bsStockState;
	private String blLendDate;
	private String librarian;
	private String member;
	
	
	public String getLibnum() {
		return libnum;
	}
	public void setLibnum(String libnum) {
		this.libnum = libnum;
	}
	public String getBsStockState() {
		return bsStockState;
	}
	public void setBsStockState(String bsStockState) {
		this.bsStockState = bsStockState;
	}
	public String getBlLendDate() {
		return blLendDate;
	}
	public void setBlLendDate(String blLendDate) {
		this.blLendDate = blLendDate;
	}
	public String getLibrarian() {
		return librarian;
	}
	public void setLibrarian(String librarian) {
		this.librarian = librarian;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "LayoutStats [libnum=" + libnum + ", bsStockState=" + bsStockState + ", blLendDate=" + blLendDate
				+ ", librarian=" + librarian + ", member=" + member + "]";
	}
	
	
	
}
