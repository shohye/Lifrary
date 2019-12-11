package ksmart.pentagon.booklend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.User;

@Service
public class BookLendService {
	
	@Autowired private BookLendMapper bookLendMapper;
	
	//대출도서리스트 
	public List<BookLend> bookSearchList(){
		
		List<BookLend> bookLend = bookLendMapper.bookSearchList();
		
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
	//도서정보
	public Map<String, Object> bookInfo(String svBook) {
		
		Map<String, Object> bookInfoMap = new HashMap<String, Object>();
		
		//앞뒤공백제거
		String svBookTrim =svBook.trim();
		BookStock bookStock = bookLendMapper.bookInfo(svBookTrim);
		
		
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
			
			String lendDate = bookStock.getBooklLend().getBlLendDate();//대출일
			String returnDate = bookStock.getBooklLend().getBlReturnDate();//반납일
			//예약 도서인지 확인하는 조건문
			if(lendDate == null && returnDate == null) {
				bookStock.setBsLendState("예약");
				bookInfoMap.put("holdId", bookStock.getBooklLend().getBlId());//예약자아이디
			}
			//반납안된 도서인지 확인하는 조건문

			else if(lendDate != null && returnDate == null) {	
				User user = bookLendMapper.userInfo(bookStock.getuId());
				
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
					
					//대출제한일이 null이거나 사용권한이 0단계인 경우 공백셋팅
					if(user.getuAuthorityDate() == null || user.getUasCode().equals("uas001")) {
						user.setuAuthorityDate(" ");
					}	
				}
				bookInfoMap.put("resultUser", user);
				bookInfoMap.put("searchBook", 2);//반납안된 도서인 경우 2 대입
			}
		}else {
			
			bookInfoMap.put("searchBook", 0);//도서정보 없는 경우 0 대입
		}
		bookInfoMap.put("resultBook", bookStock);
		
		return bookInfoMap;
		
	}
	//회원정보
	public Map<String, Object> userInfo(String svUser) {
		
		Map<String, Object> userInfoMap = new HashMap<String, Object>();
		
		String svUserTrim =svUser.trim(); //앞뒤공백제거
		User user = bookLendMapper.userInfo(svUserTrim);
		
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
			
			//대출제한일이 null이거나 사용권한이 0단계인 경우 공백셋팅
			if(user.getuAuthorityDate() == null || user.getUasCode().equals("uas001")) {
				user.setuAuthorityDate(" ");
			}
			userInfoMap.put("searchUser", 1);//회원정보있는 경우 1 대입
		}else {
			userInfoMap.put("searchUser", 0);//회원정보없는 경우 0 대입	
		}
		
		userInfoMap.put("resultUser", user);	
		
		return userInfoMap;
		
	}
	

}