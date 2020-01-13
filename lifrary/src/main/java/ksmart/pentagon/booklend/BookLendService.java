package ksmart.pentagon.booklend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.point.PointMapper;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.Paging;
import ksmart.pentagon.vo.Point;
import ksmart.pentagon.vo.User;

@Service
public class BookLendService {
	
	@Autowired private BookLendMapper bookLendMapper;
	@Autowired private PointMapper pointMapper;
	
	//대출도서 리스트 
	public List<BookLend> bookSearchList(String libNum){
		
		List<BookLend> bookLend = bookLendMapper.bookSearchList(libNum);
		
		//연체일이 0보다 작은 경우 0으로 셋팅
		for(int i = 0; i < bookLend.size(); i++) {
			BookLend bl = bookLend.get(i);
			int overdueDays= bl.getBlOverdueDays();
			if(overdueDays < 0) {
				bl.setBlOverdueDays(0);
			}
		}
		return bookLend;
		
	}
	//도서정보검색
	public Map<String, Object> bookInfo(String libNum, String svBook) {
		
		BookStock bookStock = null;
		Map<String, Object> bookInfoMap = new HashMap<String, Object>();
				
		//앞뒤공백제거
		String svBookTrim =svBook.trim();
		//새로 등록된 도서인지 확인
		int bookLendCheck = bookLendMapper.bookLendCheck(libNum, svBookTrim);
		if(bookLendCheck == 0) bookStock = bookLendMapper.bookInfoStock(libNum, svBookTrim);
		else bookStock = bookLendMapper.bookInfo(libNum,svBookTrim);
			
		if(bookStock != null) {
			String bsCallNum = "";
			
			//청구기호를 생성을 위한 조건문 처리
			String aliasMark = bookStock.getBsAliasMark();//별치기호
			String kdc = bookStock.getBookInformation().getBiKdc();//분류기호
			String writerMark = bookStock.getBsWriterMark();//저자기호
			String bsSecondaryMark = bookStock.getBsSecondaryMark();//부차적기호
			
			if(aliasMark != null) {
				bsCallNum += aliasMark;
			}
			
			bsCallNum += kdc;
			bsCallNum += writerMark;
			
			if(bsSecondaryMark != null) {
				
				bsCallNum += bsSecondaryMark;
			}
			bookStock.setBsCallNum(bsCallNum);

			bookInfoMap.put("searchBook", 1);//도서정보있는 경우 1 대입
			
			//새로 등록된 도서가 아닌경우
			if(bookStock.getBookLend() != null && bookLendCheck != 0) {
				String lendDate = bookStock.getBookLend().getBlLendDate();//대출일
				String returnDate = bookStock.getBookLend().getBlReturnDate();//반납일
				
				if(lendDate == null && returnDate == null) {//예약 도서인지 확인하는 조건문
					bookStock.setBsLendState("예약");
					bookInfoMap.put("searchBook", 3);//예약도서인  경우 3 대입
				}else if(lendDate != null && returnDate == null) {//대출된 도서인지 확인하는 조건문	
					//대출도서 회원정보 가져오기
					User user = bookLendMapper.userInfo(libNum, bookStock.getuId());
					if(user != null) {
						//대출가능권수 구하기
						int bookLendNum = 0;
						int lendNum = user.getUserLevel().getUlLendNum();
						int lendCnt = user.getuLendCnt();
							
						if(lendNum > lendCnt) {
							
							bookLendNum = lendNum-lendCnt;
						}else {
							bookLendNum = 0;	
						}
						user.getUserLevel().setUlLendNum(bookLendNum);
						//대출제한일이 null이거나 사용제한일이 지난 경우 
						if(user.getuAuthorityDate() == null || user.getuAuthorityDays() <= 0) {
							user.setuAuthorityDate(" ");
						}	
					}
					bookInfoMap.put("resultUser", user);
					bookInfoMap.put("searchBook", 2);//대출된 도서인 경우2 대입
				}
			}	
		}else {
			
			bookInfoMap.put("searchBook", 0);//도서정보 없는 경우 0 대입
		}
		bookInfoMap.put("resultBook", bookStock);
		
		return bookInfoMap;	
	}
	//회원정보
	public Map<String, Object> userInfo(String libNum, String svUser) {
		
		Map<String, Object> userInfoMap = new HashMap<String, Object>();
		
		String svUserTrim =svUser.trim(); //앞뒤공백제거
		User user = bookLendMapper.userInfo(libNum, svUserTrim);
		
		if(user != null) {
			//대출가능권수 구하기
			int bookLendNum = 0;
			int lendNum = user.getUserLevel().getUlLendNum();
			int lendCnt = user.getuLendCnt();
				
			if(lendNum > lendCnt) {
				
				bookLendNum = lendNum-lendCnt;
			}else {
				bookLendNum = 0;	
			}
			user.getUserLevel().setUlLendNum(bookLendNum);
			
			//대출제한일이 null이거나 사용제한일이 지난 경우 
			if(user.getuAuthorityDate() == null || user.getuAuthorityDays() <= 0) {
				user.setuAuthorityDate(" ");
			}
			userInfoMap.put("searchUser", 1);//회원정보있는 경우 1 대입
		}else {
			userInfoMap.put("searchUser", 0);//회원정보없는 경우 0 대입	
		}
		
		userInfoMap.put("resultUser", user);	
		
		return userInfoMap;
		
	}
	
	//대출도서 등록
	public int lendInsert(BookLend booklend) {
		int result = 0;
		
		int lendinsert = bookLendMapper.lendInsert(booklend);
		
		if(lendinsert == 1) {
			
			String lendState = "X";
			String bsCode = booklend.getBsCode();
			
			int stockUpdate = bookLendMapper.stockUpdate(bsCode, lendState);
			
			if(stockUpdate == 1) result = 1; //대출등록,대출상태 수정 성공
			else result = 2; //대출상태 수정 실패
			
		}else {
			
			result = 0; //대출등록 실패
		}
		
		return result;
		
	}
	//반납일 등록
	public int returnUpdate(String blCode, String bsCode, Point point) {
		
		int result = 0;
		
		int returnUpdate = bookLendMapper.returnUpdate(blCode);
		
		if(returnUpdate == 1) {
			String lendState = "O";
			
			int stockUpdate = bookLendMapper.stockUpdate(bsCode, lendState);
			if(stockUpdate == 1) {
				
				//포인트 등록
				pointMapper.myPointInsert(point);
				
				result = 1;//반납등록,대출상태 수정 성공
			}
				
			else result = 2;//대출상태 수정 실패
						
			
		}else {
			result = 0; //반납등록 실패
		}
		return result;
		
	}
	public int holdUpdate(String saId, String blCode, String ulLendDay) {
		return bookLendMapper.holdUpdate(saId, blCode, ulLendDay);
	}
	//연장일 등록
	public int extensionUpdate(String blCode) {
		
		return bookLendMapper.extensionUpdate(blCode);
	}
	
	//예약도서 리스트
	public List<BookLend> holdSearchList(String libNum){
		
		return bookLendMapper.holdSearchList(libNum);
		
	}
	
	//예약 취소
	public int holdDelete(String blCode, String bsCode) {
		int result = 0;
		
		int holdDelete = bookLendMapper.holdDelete(blCode);
		
		if(holdDelete == 1) {
			String lendState = "O";
			
			int stockUpdate = bookLendMapper.stockUpdate(bsCode, lendState);
			if(stockUpdate == 1)result = 1;//예약 취소,대출상태 수정 성공
			else result = 2;//대출상태 수정 실패
			
		}else {
			result = 0; //예약 취소 실패
		}
		return result;
		
	}
	
	//회원 대출 리스트
	public Map<String, Object> myLendList(Map<String,Object> params, String currentPageStr) {
		
	    Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("current: " + df.format(cal.getTime()));

        String svDate = (String) params.get("svDate");
        if(("week").equals(svDate)) {
        	cal.add(Calendar.DATE, -7);
        }else if(("month").equals(svDate)) {
        	cal.add(Calendar.MONTH, -1);
        }else if(("6month").equals(svDate)) {
        	cal.add(Calendar.MONTH, -6);
        }else if(("year").equals(svDate)) {
        	cal.add(Calendar.YEAR, -1);
        }
        params.put("svDate", df.format(cal.getTime()));

        int myLendCnt = bookLendMapper.myLendListCnt(params);
        
        Paging paging =  new Paging(myLendCnt, currentPageStr);
        int currentPage = paging.getCurrentPage();
        int lastPage = paging.getLastPage();
        int startPageNum = paging.getStartPageNum();
        int lastPageNum = paging.getLastPageNum();
        
        int startRow = paging.getStartRow();
        int ROW_PER_PAGE = Paging.getRowPerPage();
        
        params.put("startRow", startRow);
        params.put("rowPerPage", ROW_PER_PAGE);
        
		List<BookLend> bookLend = bookLendMapper.myLendList(params);
		
		//연체일이 0보다 작은 경우 0으로 셋팅
		for(int i = 0; i < bookLend.size(); i++) {
			BookLend bl = bookLend.get(i);
			int overdueDays= bl.getBlOverdueDays();
			if(overdueDays < 0) {
				bl.setBlOverdueDays(0);
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("myLendList", bookLend);
        resultMap.put("currentPage", currentPage);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}
	
	//회원 예약 리스트
	public Map<String, Object> myHoldList(Map<String,Object> params, String currentPageStr){
		
	    Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("current: " + df.format(cal.getTime()));

        String svDate = (String) params.get("svDate");
        if(("week").equals(svDate)) {
        	cal.add(Calendar.DATE, -7);
        }else if(("month").equals(svDate)) {
        	cal.add(Calendar.MONTH, -1);
        }else if(("6month").equals(svDate)) {
        	cal.add(Calendar.MONTH, -6);
        }else if(("year").equals(svDate)) {
        	cal.add(Calendar.YEAR, -1);
        }
        params.put("svDate", df.format(cal.getTime()));
        
        int myLendCnt = bookLendMapper.myHoldListCnt(params);
        
        Paging paging =  new Paging(myLendCnt, currentPageStr);
        int currentPage = paging.getCurrentPage();
        int lastPage = paging.getLastPage();
        int startPageNum = paging.getStartPageNum();
        int lastPageNum = paging.getLastPageNum();
        
        int startRow = paging.getStartRow();
        int ROW_PER_PAGE = Paging.getRowPerPage();
        
        params.put("startRow", startRow);
        params.put("rowPerPage", ROW_PER_PAGE);
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("myHoldList", bookLendMapper.myHoldList(params));
        resultMap.put("currentPage", currentPage);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	
	}
	
}
