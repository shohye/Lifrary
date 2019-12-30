package ksmart.pentagon.vo;
public class Paging {
	
	
	// 아래에 1,2,3,4 나오는거.. 현재페이지
	private int currentPage;
	// 데이터베이스 전체 row수
	private int listCount;
	
	//한페이지에 보여지는 게시물 수 
	private static final int LIST_VIEW_LENGTH = 4;
	public static int getListViewLength() {
		return LIST_VIEW_LENGTH;
	}	
	// 아래에 보여지는 페이지 수의 길이 (한계) 예)[1,2,3,...,10][11,12,...,20]=>10개씩
	private static final int PAGE_VIEW_LENGTH = 10;		
	// 처음시작하는 데이터 로우의 숫자 
	private int limitStart;
	// 전체 페이지 수  예) 1,2,3,...,12 => 12
	private int totalViewPage;
	// 현재 페이지 블록 몇번째인지 예) [1,2,...,10]=>1 / [11,12,...,20]=>2
	private int pageViewBlock;
	// 아래보이는 페이지 블록 배열 예)[1,2,3,...,10][11,12,...,20]
	private int[] pageViewArray;	
	//이전페이지
	private int prePage;
	//다음페이지
	private int nextPage;
	
	// 전체 데이터 로우수와 현재 페이지의를 받아옴.
	public Paging(int listCount, String currentPageStr) {
		
		int currentPage = 1;
		
		// 파라미터로 넘어온 currentPage 값을 int형으로 캐스팅
		if(currentPageStr != null && !"".equals(currentPageStr.trim())) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		//currentPage가 0이면 1로 변경
		if(currentPage == 0) currentPage = 1;
		
		this.listCount = listCount; // 받아온 전체 데이터로우수를 페이징 클래스의 listCount변수에 저장
		this.currentPage = currentPage;
		
		System.out.println("Paging.java listCount : " + listCount);
		System.out.println("Paging.java currentPage : " + currentPage);
			
		// 시작 데이터 로우 숫자 = (현재페이지-1)*한페이지에 보여지는 게시물 수 
		//예1) 한페이지에 10개씩 보일때 [0,1,2,..,9][10,11,...,19][20,21,...,29]....
		//예2) 한페이지에 4개씩 보일때 [0,1,2,3][4,5,6,7][8,9,10,11]...
		this.limitStart = (currentPage - 1) * LIST_VIEW_LENGTH;
		/*
		 * mysql의 limit 시작수(0부터시작), 총 출력수 임으로
		 * currentPage 값이1일경우  -1 연산하여 0으로 설정하고
		 * LIST_VIEW_LENGTH을 곱하기 연산하면됨
		 */
		System.out.println("Paging.java limitStart : " + limitStart);
		
		// 리스트카운트와 출력목록수를 나누기 연산하여 하단 총 출력될 페이지 수를 구한다.
		// 리스트 카운트와 출력목록수의 나머지가 있을 경우 + 1 
		//예)전체 로우수가 125개이고 한페이지에 출력하는 로우수가 10개일때  12.5가 되므로 페이지는12+1=13
		this.totalViewPage = listCount / LIST_VIEW_LENGTH;
		if(listCount % LIST_VIEW_LENGTH != 0) this.totalViewPage += 1;
		
		System.out.println("Paging.java totalViewPage : " + totalViewPage);
		
		// 현재페이지를 기준으로 보여질 페이지의 범위를 산정
		// 예) 현재 3페이지를 선택한 경우 아래에 보여야할 페이지의 범위는 [1,2,...,10]
		this.pageViewBlock = currentPage / PAGE_VIEW_LENGTH;
		if(currentPage % PAGE_VIEW_LENGTH != 0) this.pageViewBlock += 1;
		
		System.out.println("Paging.java pageViewBlock : " + pageViewBlock);
		
		//하단에 출력시킬 페이지 숫자 배열로 정의 >> [1,2,...,10]
		this.pageViewArray = new int[PAGE_VIEW_LENGTH];
		
		for(int i=1; i <= pageViewArray.length; i ++) {
			// 현재 보여질 페이지 블럭 수와 보여질 페이지수로 연산
			// 첫번째 블럭의 경우 ((1-1)*10)+i 가 되므로 [1,2,3,...,10]가 pageViewArray 배열에 들어감..
			int onPage = ((pageViewBlock - 1) * PAGE_VIEW_LENGTH) + i;
			if(totalViewPage >= onPage) { 
				// 전체페이지보다 onPage의 값이 작으면 배열에 넣어줌..
				pageViewArray[i-1] = onPage;
			}else { 
				// 전체페이지가 13페이지이고 블럭이 2개 존재할때  2번째 블럭에서는 
				// pageViewArray배열에 13값이 들어간 이후 남은 자리에 -1을 넣어준다. 
				// [11,12,13,-1,-1,-1,-1,-1,-1,-1]
				pageViewArray[i-1] = -1;
			}
		}
		
		prePage = 1;
	
		// pageViewArray[pageViewArray.length-1] => pageViewArray[10-1] 
        // 결국 배열의 맨마지막 값 = 한 블럭에 표시될 맨 마지막 값.
		// 예) 첫번째블록 [1,2,3,...,10] >> 10  || 두번째블록 [11,12,13,-1,-1,-1,-1,-1,-1,-1] >>-1
		System.out.println(pageViewArray[pageViewArray.length-1]+"<=pageViewArray[pageViewArray.length-1] Paging.java");
		   
	    if(pageViewArray[0] != -1 && pageViewArray[0] != 1 ) {
	    	
		   prePage = pageViewArray[0]-1 ;
		   
	    }
		    if(pageViewArray[pageViewArray.length-1] != -1 ){ // pageViewArray 배열에 담긴값이 -1이 아닌경우
		    	
		    	if(totalViewPage % PAGE_VIEW_LENGTH !=0 ) {
		    		// 전체페이지/ 아래에 표시되는 페이지의 갯수 한 값이 0이아니고 나머지가 생기는경우 
		    		// 예) 13/10 => 나머지 3 
		    		nextPage = pageViewArray[pageViewArray.length-1] +1;
		    		System.out.println("####### 실행확인 1 ########");
		    		System.out.println(nextPage+"<==nextPage1");
		    		
		    	}else {
		    		// 전체페이지/ 아래에 표시되는 페이지의 갯수 한 값이 0인경우
		    		// 예) 10/10 => 나머지 0
		    		nextPage = getTotalViewPage(); 
		    		 System.out.println("####### 실행확인 2 #######");
		    		 System.out.println(nextPage+"<==nextPage2");
		    	}
	    	
	    }else if(pageViewArray[pageViewArray.length-1] == -1) {
	    	// pageViewArray 배열에 담긴값이 -1인경우 = 마지막 페이지 이상을 선택하게 되는경우
	    	// 마지막 페이지에서 다음을 누르는 경우 계속 마지막 페이지에 머물게함 
            // getTotalViewPage()값 = 전체페이지수 = 마지막페이지의 넘버
	    	nextPage = getTotalViewPage();
	    	System.out.println("###### 실행확인 3 ######");
   		    System.out.println(nextPage+"<==nextPage3");
	    }
				
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getTotalViewPage() {
		return totalViewPage;
	}
	public void setTotalViewPage(int totalViewPage) {
		this.totalViewPage = totalViewPage;
	}
	public int getPageViewBlock() {
		return pageViewBlock;
	}
	public void setPageViewBlock(int pageViewBlock) {
		this.pageViewBlock = pageViewBlock;
	}
	public int[] getPageViewArray() {
		return pageViewArray;
	}
	public void setPageViewArray(int[] pageViewArray) {
		this.pageViewArray = pageViewArray;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
