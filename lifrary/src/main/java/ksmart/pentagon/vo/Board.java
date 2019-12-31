package ksmart.pentagon.vo;

public class Board {
	private String boardCode;		//게시글내용코드
	private String lCode;			//도서관코드
	private String uId;				//아이디
	private String boardLCode;		//게시판대분류코드
	private String boardMCode;		//게시판중분류코드
	private String boardTitle;		//게시글제목
	private String boardPw;			//게시글비번
	private String boardContent;	//게시글내용
	private String boardOpen;		//공개여부
	private String boardPageView;	//조회수
	private String boardDate;		//게시글등록일
	private String boardLName;		//대분류명
	private String boardMName;		//중분류명
	private BoardComment boardComment; //댓글 테이블
	
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
	public String getBoardLCode() {
		return boardLCode;
	}
	public void setBoardLCode(String boardLCode) {
		this.boardLCode = boardLCode;
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
	public String getBoardOpen() {
		return boardOpen;
	}
	public void setBoardOpen(String boardOpen) {
		this.boardOpen = boardOpen;
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
	public String getBoardLName() {
		return boardLName;
	}
	public void setBoardLName(String boardLName) {
		this.boardLName = boardLName;
	}
	public String getBoardMName() {
		return boardMName;
	}
	public void setBoardMName(String boardMName) {
		this.boardMName = boardMName;
	}
	public BoardComment getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(BoardComment boardComment) {
		this.boardComment = boardComment;
	}
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", lCode=" + lCode + ", uId=" + uId + ", boardLCode=" + boardLCode
				+ ", boardMCode=" + boardMCode + ", boardTitle=" + boardTitle + ", boardPw=" + boardPw
				+ ", boardContent=" + boardContent + ", boardOpen=" + boardOpen + ", boardPageView=" + boardPageView
				+ ", boardDate=" + boardDate + ", boardLName=" + boardLName + ", boardMName=" + boardMName
				+ ", boardComment=" + boardComment + "]";
	}
	
	
}
