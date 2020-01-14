package ksmart.pentagon.vo;
public class Paging {
   
	// 현재 페이지
	private int currentPage;
	// DB 행의 총 개수
	private int boardCount;
	// 페이지에 보여줄 행의 개수
	private static int ROW_PER_PAGE = 10; 
	public static int getRowPerPage() {
		return ROW_PER_PAGE;
	}
	
	private int startPageNum = 1;    
	
    // 처음 보여줄 마지막 페이지 번호는 10
	private int lastPageNum = ROW_PER_PAGE;
	
	private int startRow;
	private int lastPage;
	
	
	public Paging(int boardCount, String currentPageStr) {
		
        int currentPage= 0;
		
		// 파라미터로 넘어온 currentPage 값을 int형으로 캐스팅
		if(currentPageStr != null && !"".equals(currentPageStr.trim())) {
			currentPage = Integer.parseInt(currentPageStr);
			System.out.println( "페이징 자바 currentPage =====>"+currentPage);
		}
		//currentPage가 0이면 1로 변경
		if(currentPage == 0) currentPage = 1;
		
		this.boardCount = boardCount; // 받아온 전체 데이터로우수를 페이징 클래스의 listCount변수에 저장
		this.currentPage = currentPage;
		 // 현재 페이지가 ROW_PER_PAGE/2 보다 클 경우
		
		if ( boardCount % ROW_PER_PAGE == 0) {
	    	lastPage = (int) boardCount/ROW_PER_PAGE;
	    }else {
	    	lastPage = (int) boardCount/ROW_PER_PAGE +1;
	    }
		
		startRow = (currentPage - 1)*ROW_PER_PAGE; 
		
	    if(currentPage > (ROW_PER_PAGE/2)) {
	        // 보여지는 페이지 첫번째 페이지 번호는 현재페이지 - ((마지막 페이지 번호/2) -1 )
	        // ex 현재 페이지가 6이라면 첫번째 페이지번호는 2
	        startPageNum = currentPage - ((lastPageNum/2)-1);
	        // 보여지는 마지막 페이지 번호는 현재 페이지 번호 + 현재 페이지 번호 - 1 
	        lastPageNum += (startPageNum-1);
	    }
	    
	    
	           
	    // 현재 페이지가 (마지막 페이지-4) 보다 같거나 클 경우
	    if(currentPage >= (lastPage-4)) {
	        // 마지막 페이지 번호는 lastPage
	        lastPageNum = lastPage;
	    }else if(currentPage < (lastPage-4)) {
	    	
	    }
    
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
  
}