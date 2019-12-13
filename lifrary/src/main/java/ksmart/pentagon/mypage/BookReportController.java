package ksmart.pentagon.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @file BookReportController.java
 * @name BookReportController
 * @brief 독후감 관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class BookReportController {
	
	/**
	 * @brief 독후감 공유 리스트
	 * @return /librarypage/book/bookReportSearchList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/bookReportSearchList")
	public String bookReportSearchList() {
		
		return "/librarypage/book/bookReportSearchList";
		
	}
	
	/**
	 * @brief 마이페이지 내 독후감 리스트
	 * @return /librarypage/book/myBookReportSearchList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myBookReportSearchList")
	public String myBookReportSearchList() {
		
		return "/librarypage/book/myBookReportSearchList";
		
	}
	
	/**
	 * @brief 독후감 등록 화면
	 * @return /librarypage/book/bookReportInsert
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/bookReportInsert")
	public String bookReportInsert() {
		
		return "/librarypage/book/bookReportInsert";
	
	}
	
	/**
	 * @brief 독후감 상세 
	 * @return /librarypage/book/bookReportDetail
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/bookReportDetail")
	public String bookReportDetail() {
		
		return "/librarypage/book/bookReportDetail";
	
	}
	
}
