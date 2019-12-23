package ksmart.pentagon.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.StudyCate;

/***
 * @file StudyController.java
 * @name StudyController
 * @brief 서재 관련 주소요청 처리
 * @author 최지혜
 *
 */
@Controller
public class StudyController {

	@Autowired private StudyService studyService;
	
	/**
	 * @brief 서재 리스트
	 * @return /librarypage/book/myStudyCateList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myStudyList")
	public String myStudyList() {
		
		return "/librarypage/book/myStudyList";
	
	}
	
	/**
	 * 
	 * @param session
	 * @brief 서재 카테고리 리스트
	 * @return
	 * @author 최지혜
	 */
	@RequestMapping(value="/lifrary/studyCateList", produces = "application/json")
	public @ResponseBody List<StudyCate> studyCateList(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String sId = (String) session.getAttribute("SID");
				
		return studyService.studyCateList(libNum, sId);
		
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
