package ksmart.pentagon.vo;

public class BoardComment {

		private String boardCCode;		//댓글코드
		private String lCode;			//도서관코드
		private String uId;				//아이디
		private String boardCode;		//게시글내용 코드
		private String bReportCode;		//독후감코드
		private String boardCContent;	//내용
		private String boardCOpen;		//공개여부
		private String boardCDate;		//등록일
		
		public String getBoardCCode() {
			return boardCCode;
		}
		public void setBoardCCode(String boardCCode) {
			this.boardCCode = boardCCode;
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
		public String getBoardCode() {
			return boardCode;
		}
		public void setBoardCode(String boardCode) {
			this.boardCode = boardCode;
		}
		public String getbReportCode() {
			return bReportCode;
		}
		public void setbReportCode(String bReportCode) {
			this.bReportCode = bReportCode;
		}
		public String getBoardCContent() {
			return boardCContent;
		}
		public void setBoardCContent(String boardCContent) {
			this.boardCContent = boardCContent;
		}
		public String getBoardCOpen() {
			return boardCOpen;
		}
		public void setBoardCOpen(String boardCOpen) {
			this.boardCOpen = boardCOpen;
		}
		public String getBoardCDate() {
			return boardCDate;
		}
		public void setBoardCDate(String boardCDate) {
			this.boardCDate = boardCDate;
		}
		@Override
		public String toString() {
			return "BoardComment [boardCCode=" + boardCCode + ", lCode=" + lCode + ", uId=" + uId + ", boardCode="
					+ boardCode + ", bReportCode=" + bReportCode + ", boardCContent=" + boardCContent + ", boardCOpen="
					+ boardCOpen + ", boardCDate=" + boardCDate + "]";
		}
		
		
		
		
		
		
}
