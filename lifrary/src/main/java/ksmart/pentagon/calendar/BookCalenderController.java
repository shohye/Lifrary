package ksmart.pentagon.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/***
 * @file BookCalenderController.java
 * @name BookCalenderController
 * @brief 북다이어리 관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class BookCalenderController {
	
	/***
	 * @brief 마이페이지 북다이어리(캘린더)출력
	 * @return /librarypage/calender/myCalender
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/bookCalenderList")
	public String bookCalenderList() {
		
		
		return "/librarypage/calender/myCalender";
		
	}

}
