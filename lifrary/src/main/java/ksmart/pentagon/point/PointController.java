package ksmart.pentagon.point;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.pentagon.vo.Point;


/***
 * @file PointController.java
 * @name PointController
 * @brief 포인트 관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class PointController {
	@Autowired private PointService pointService;
	
	/***
	 * @param 
	 * @brief 포인트리스트 
	 * @return adminpage/point/pointList
	 * @author 최지혜
	 */
	@GetMapping("/admin/pointList")
	public String pointList() {
		
		return "/adminpage/point/pointList";
		
	}
	
	/**
	 * @param session
	 * @brief 포인트리스트
	 * @return List<Point>
	 * @author 최지혜
	 */
	
	@RequestMapping(value="/admin/pointAjax", produces = "application/json")
	public @ResponseBody List<Point> pointAjax(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return pointService.pointList(libNum);
		}
	
	/***
	 * @param 
	 * @brief 포인트사용이력화면
	 * @return adminpage/point/pointHistorySearchList
	 * @author 최지혜
	 */
	@GetMapping("/admin/pointHistoryList")
	public String pointHistorySearchList() {
		
		return "/adminpage/point/pointHistorySearchList";
		
		}
	
	/**
	 * @param session
	 * @brief 포인트사용이력리스트
	 * @return List<Point>
	 * @author 최지혜
	 */
	
	@RequestMapping(value="/admin/pointHistoryAjax", produces = "application/json")
	public @ResponseBody List<Point> pointHistoryAjax(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return pointService.pointHistorySearchList(libNum);
		}
	
	@GetMapping("/admin/pointHistoryDelete")
	public String pointHistoryDelete(@RequestParam(value="phCode" ) String phCode
									 , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("resultDelete", pointService.pointHistoryDelete(phCode));
		
		return "redirect:/admin/pointHistoryList";
	}
	
	/**
	 * @brief 마이페이지 포인트사용이력리스트 
	 * @return /librarypage/point/myPointList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myPointList")
	public String myPointList() {
		
		
		return "/librarypage/point/myPointList";
		
		}
	
	/**
	 * @brief 회원 포인트신청
	 * @return /librarypage/point/myPoint
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myPoint")
	public String myPoint() {
		
		
		return "/librarypage/point/myPoint";
		
		}
}
