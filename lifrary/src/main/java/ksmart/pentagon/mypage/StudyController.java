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
	 * @brief 서재 리스트
	 * @return /librarypage/book/myStudyCateList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myStudyList")
	public String myStudyCateList() {
		
		return "/librarypage/book/myStudyList";
	
	}
	
	
	/**
	 * @brief 카테고리 등록
	 * @return /librarypage/book/myStudyCateInsert
	 * @author 최지혜
	 */
	
	@GetMapping("/lifrary/myStudyCateInsert")
	public String myStudyCateInsert() {
		
		return "/librarypage/book/myStudyCateInsert";
	
	}
	/**
	 * @brief 카테고리 수정
	 * @return /librarypage/book/myStudyCateUpdate
	 * @author 최지혜
	 */
	 
	@GetMapping("/lifrary/myStudyCateUpdate")
	public String myStudyCateUpdate() {
		
		return "/librarypage/book/myStudyCateUpdate";
	
	}
}
