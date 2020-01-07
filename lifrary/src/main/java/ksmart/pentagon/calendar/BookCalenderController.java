package ksmart.pentagon.calendar;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.Calender;


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
	 * @brief 마이페이지 북다이어리(캘린더) 등록
	 * @return /librarypage/calender/myCalenderInser
	 * @author 최지혜
	 */
	@PostMapping("/lifrary/myCalenderInsert")
	public String myCalenderInsert(Calender calender
								  , HttpSession session
								  , RedirectAttributes redirectAttributes) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String uId = (String) session.getAttribute("SID");
		
		calender.setlCode(libNum);
		calender.setuId(uId);
		System.out.println(calender.toString());
		
		redirectAttributes.addFlashAttribute("resultInsert", bookCalenderService.myCalenderInsert(calender));
		
		return "redirect:/lifrary/myCalender";
	}
	
	/** 
	 * @param session
	 * @param biName 도서이름
	 * @brief 검색도서정보
	 * @return List<BookInformation>
	 * @author 최지혜
	 */
	@RequestMapping(value="/lifrary/getBooKInfo", produces = "application/json")
	public @ResponseBody List<BookInformation> getBooKInfo(HttpSession session
													 ,@RequestParam(value="biName" ) String biName) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return bookCalenderService.getBooKInfo(libNum, biName);
	}
	
	/**
	 * @param cCode 캘린더 코드
	 * @brief 캘린더 정보 가져오기
	 * @return 캘린더 정보
	 * @author 최지혜
	 */
	@RequestMapping(value="/lifrary/getMyCalender", produces = "application/json")
	public @ResponseBody Calender getMyCalender(@RequestParam(value="cCode") String cCode) {
		
		System.out.println("cCode: "+cCode);
		
		return bookCalenderService.getMyCalender(cCode);
	}
	
	@PostMapping("/lifrary/myCalenderUpdate")
	public String myCalenderUpdate(Calender calender
								  , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("resultUpdate", bookCalenderService.myCalenderUpdate(calender));
		
		return "redirect:/lifrary/myCalender";
	}
	@PostMapping("/lifrary/myCalenderDelete")
	public String myCalenderDelete(@RequestParam(value="cCode") String cCode
								  , RedirectAttributes redirectAttributes) {
			
		redirectAttributes.addFlashAttribute("resultDelete", bookCalenderService.myCalenderDelete(cCode));
		
		return "redirect:/lifrary/myCalender";
	}
	
}
