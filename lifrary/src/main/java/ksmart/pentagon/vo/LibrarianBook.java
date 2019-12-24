package ksmart.pentagon.vo;

public class LibrarianBook {

	private String lbCode;		//추천도서코드
	private String lCode;		//도서관코드
	private String uId;			//등록아이디
	private String bsCode;		//소장도서코드
	private String lbTitle;		//사서추천제목
	private String lbContent;	//사서추천내용
	private String lbId;		//추천인 아이디
	private String lbOpen;		//공개여부
	private String lbDate;		//등록일
	private BookInformation bookInformation; //도서정보 테이블 vo
	
	
	public String getLbCode() {
		return lbCode;
	}
	public void setLbCode(String lbCode) {
		this.lbCode = lbCode;
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
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getLbTitle() {
		return lbTitle;
	}
	public void setLbTitle(String lbTitle) {
		this.lbTitle = lbTitle;
	}
	public String getLbContent() {
		return lbContent;
	}
	public void setLbContent(String lbContent) {
		this.lbContent = lbContent;
	}
	public String getLbId() {
		return lbId;
	}
	public void setLbId(String lbId) {
		this.lbId = lbId;
	}
	public String getLbOpen() {
		return lbOpen;
	}
	public void setLbOpen(String lbOpen) {
		this.lbOpen = lbOpen;
	}
	public String getLbDate() {
		return lbDate;
	}
	public void setLbDate(String lbDate) {
		this.lbDate = lbDate;
	}
	public BookInformation getBookInformation() {
		return bookInformation;
	}
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}
	@Override
	public String toString() {
		return "LibrarianBook [lbCode=" + lbCode + ", lCode=" + lCode + ", uId=" + uId + ", bsCode=" + bsCode
				+ ", lbTitle=" + lbTitle + ", lbContent=" + lbContent + ", lbId=" + lbId + ", lbOpen=" + lbOpen
				+ ", lbDate=" + lbDate + ", bookInformation=" + bookInformation + "]";
	}
	
	
	
}
