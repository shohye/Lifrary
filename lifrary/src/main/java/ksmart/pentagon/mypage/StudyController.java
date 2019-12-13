package ksmart.pentagon.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * @file StudyController.java
 * @name StudyController
 * @brief 서재 관련 주소요청 처리
 * @author 최지혜
 *
 */
@Controller
public class StudyController {

	/**
	 * @brief 서재 카테고리 리스트
	 * @return /librarypage/book/myStudyCateList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myStudyCateList")
	public String myStudyCateList() {
		
		return "/librarypage/book/myStudyCateList";
	
	}
	
	/**
	 * @brief 카테고리 도서 리스트
	 * @return /librarypage/book/myStudyBookList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myStudyBookList")
	public String myStudyBookList() {
		
		return "/librarypage/book/myStudyBookList";
	
	}
	
}
