package ksmart.pentagon.vo;

public class Board {
	private String boardCode;		//게시글내용코드
	private String lCode;			//도서관코드
	private String uId;				//아이디
	private String boardICode;		//게시판대분류코드
	private String boardMCode;		//게시판중분류코드
	private String boardTitle;		//게시글제목
	private String boardPw;			//게시글비번
	private String boardContent;	//게시글내용
	private String boardOpen;		//공개여부
	private String boardPageView;	//조회수
	private String boardDate;		//게시글등록일
	
	public String getBoardCode() {	
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
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
	public String getBoardICode() {
		return boardICode;
	}
	public void setBoardICode(String boardICode) {
		this.boardICode = boardICode;
	}
	public String getBoardMCode() {
		return boardMCode;
	}
	public void setBoardMCode(String boardMCode) {
		this.boardMCode = boardMCode;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardPageView() {
		return boardPageView;
	}
	public void setBoardPageView(String boardPageView) {
		this.boardPageView = boardPageView;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "board [boardCode=" + boardCode + ", lCode=" + lCode + ", uId=" + uId + ", boardICode=" + boardICode
				+ ", boardMCode=" + boardMCode + ", boardTitle=" + boardTitle + ", boardPw=" + boardPw
				+ ", boardContent=" + boardContent + ", boardPageView=" + boardPageView + ", boardDate=" + boardDate
				+ "]";
	}
	
	
}
