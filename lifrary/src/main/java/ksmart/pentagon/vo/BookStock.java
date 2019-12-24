package ksmart.pentagon.vo;

public class BookStock {

	private String bsCode;
	private String lCode;
	private String uId;
	private String bclCode;
	private String bcmCode;
	private String biIsbn;
	private String bsCallNum;	    // 청구기호
	private String bsAliasMark;     // 분류기호
	private String bsAuthorMark;    // 저자기호
	private String bsWriterMark;    // 저작기호
	private String bsSecondaryMark; // 부차적기호
	private String bsTotalPage;
	private String bsStockState;
	private String bsBookState;
	private String bsLendState;
	private String bsCarryRoute;
	private String bsDate;
	
	private String bsDelete;
	private String bsDeleteId;
	private String bsDeleteReason;
	private String bsDeleteDate;
	
	private String bsBookStateText;  // 책상태 정상 아닐경우 상태 담는 변수
	private String orderBy;          // 정렬할 기준 선택
	private String sort; 
	
	
	private BookInformation bookInformation;
	private BookCate bookCate;
	private BookLend bookLend;
	
	
	
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
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
	public String getBclCode() {
		return bclCode;
	}
	public void setBclCode(String bclCode) {
		this.bclCode = bclCode;
	}
	public String getBcmCode() {
		return bcmCode;
	}
	public void setBcmCode(String bcmCode) {
		this.bcmCode = bcmCode;
	}
	public String getBiIsbn() {
		return biIsbn;
	}
	public void setBiIsbn(String biIsbn) {
		this.biIsbn = biIsbn;
	}
	public String getBsCallNum() {
		return bsCallNum;
	}
	public void setBsCallNum(String bsCallNum) {
		this.bsCallNum = bsCallNum;
	}
	public String getBsAliasMark() {
		return bsAliasMark;
	}
	public void setBsAliasMark(String bsAliasMark) {
		this.bsAliasMark = bsAliasMark;
	}
	public String getBsAuthorMark() {
		return bsAuthorMark;
	}
	public void setBsAuthorMark(String bsAuthorMark) {
		this.bsAuthorMark = bsAuthorMark;
	}
	public String getBsWriterMark() {
		return bsWriterMark;
	}
	public void setBsWriterMark(String bsWriterMark) {
		this.bsWriterMark = bsWriterMark;
	}
	public String getBsSecondaryMark() {
		return bsSecondaryMark;
	}
	public void setBsSecondaryMark(String bsSecondaryMark) {
		this.bsSecondaryMark = bsSecondaryMark;
	}
	public String getBsTotalPage() {
		return bsTotalPage;
	}
	public void setBsTotalPage(String bsTotalPage) {
		this.bsTotalPage = bsTotalPage;
	}
	public String getBsStockState() {
		return bsStockState;
	}
	public void setBsStockState(String bsStockState) {
		this.bsStockState = bsStockState;
	}
	public String getBsBookState() {
		return bsBookState;
	}
	public void setBsBookState(String bsBookState) {
		this.bsBookState = bsBookState;
	}
	public String getBsLendState() {
		return bsLendState;
	}
	public void setBsLendState(String bsLendState) {
		this.bsLendState = bsLendState;
	}
	public String getBsCarryRoute() {
		return bsCarryRoute;
	}
	public void setBsCarryRoute(String bsCarryRoute) {
		this.bsCarryRoute = bsCarryRoute;
	}
	public String getBsDate() {
		return bsDate;
	}
	public void setBsDate(String bsDate) {
		this.bsDate = bsDate;
	}
	public String getBsDelete() {
		return bsDelete;
	}
	public void setBsDelete(String bsDelete) {
		this.bsDelete = bsDelete;
	}
	public String getBsDeleteId() {
		return bsDeleteId;
	}
	public void setBsDeleteId(String bsDeleteId) {
		this.bsDeleteId = bsDeleteId;
	}
	public String getBsDeleteReason() {
		return bsDeleteReason;
	}
	public void setBsDeleteReason(String bsDeleteReason) {
		this.bsDeleteReason = bsDeleteReason;
	}
	public String getBsDeleteDate() {
		return bsDeleteDate;
	}
	public void setBsDeleteDate(String bsDeleteDate) {
		this.bsDeleteDate = bsDeleteDate;
	}
	public String getBsBookStateText() {
		return bsBookStateText;
	}
	public void setBsBookStateText(String bsBookStateText) {
		this.bsBookStateText = bsBookStateText;
	}
	public BookInformation getBookInformation() {
		return bookInformation;
	}
	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}
	public BookCate getBookCate() {
		return bookCate;
	}
	public void setBookCate(BookCate bookCate) {
		this.bookCate = bookCate;
	}
	public BookLend getBookLend() {
		return bookLend;
	}
	public void setBookLend(BookLend bookLend) {
		this.bookLend = bookLend;
	}
	
	
	@Override
	public String toString() {
		return "BookStock [bsCode=" + bsCode + ", lCode=" + lCode + ", uId=" + uId + ", bclCode=" + bclCode
				+ ", bcmCode=" + bcmCode + ", biIsbn=" + biIsbn + ", bsCallNum=" + bsCallNum + ", bsAliasMark="
				+ bsAliasMark + ", bsAuthorMark=" + bsAuthorMark + ", bsWriterMark=" + bsWriterMark
				+ ", bsSecondaryMark=" + bsSecondaryMark + ", bsTotalPage=" + bsTotalPage + ", bsStockState="
				+ bsStockState + ", bsBookState=" + bsBookState + ", bsLendState=" + bsLendState + ", bsCarryRoute="
				+ bsCarryRoute + ", bsDate=" + bsDate + ", bsDelete=" + bsDelete + ", bsDeleteId=" + bsDeleteId
				+ ", bsDeleteReason=" + bsDeleteReason + ", bsDeleteDate=" + bsDeleteDate + ", bsBookStateText="
				+ bsBookStateText + ", bookInformation=" + bookInformation + ", bookCate=" + bookCate + ", bookLend="
				+ bookLend + "]";
	}
	
	
	
	
	
	
}
