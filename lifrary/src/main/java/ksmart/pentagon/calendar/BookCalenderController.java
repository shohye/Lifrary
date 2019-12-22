package ksmart.pentagon.calendar;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.Calender;
import ksmart.pentagon.vo.Point;


/***
 * @file BookCalenderController.java
 * @name BookCalenderController
 * @brief 북다이어리 관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class BookCalenderController {
	@Autowired private BookCalenderService bookCalenderService;
	/***
	 * @brief 마이페이지 북다이어리 이동
	 * @return /librarypage/calender/myCalender
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myCalender")
	public String myCalender() {
		
		
		return "/librarypage/calender/myCalender";
		
	}
	/**
	 * @param session
	 * @brief 회원 캘린더 리스트
	 * @return 캘린더 리스트 
	 * @author 최지혜
	 */
	@RequestMapping(value="/lifrary/getMyCalenderList", produces = "application/json")
	public @ResponseBody List<Calender> getMyCalenderList(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String uId = (String) session.getAttribute("SID");
		
		return bookCalenderService.getMyCalenderList(libNum, uId);
		}
	
	/**
	 * @brief 마이페이지 북다이어리(캘린더) 등록 화면
	 * @return /librarypage/calender/myCalenderInser
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myCalenderInsert")
	public String myCalenderInsert() {
		
		return "/librarypage/calender/myCalenderInsert";
	}
	
}
