package ksmart.pentagon.point;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@RequestMapping(value="/admin/getPointList", produces = "application/json")
	public @ResponseBody List<Point> getPointList(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return pointService.getPointList(libNum);
		}
	
	/**
	 * @param session
	 * @param point 화면에서 입력받은 포인트 정보
	 * @param redirectAttributes
	 * @brief 포인트등록
	 * @return /admin/pointList
	 * @author 최지혜
	 */
	@PostMapping("/admin/pointInsert")
	public String pointInsert(HttpSession session
							   , Point point
							   , RedirectAttributes redirectAttributes) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String saId = (String) session.getAttribute("SAID");
		
		point.setlCode(libNum);
		point.setuId(saId);
		
		redirectAttributes.addFlashAttribute("resultInsert", pointService.pointInsert(point));
		
		return "redirect:/admin/pointList";
		}
	/**
	 * @param pCode 포인트코드
	 * @brief 포인트정보 가져오기
	 * @return 포인트정보
	 * @author 최지혜
	 */
	@RequestMapping(value="/admin/getPoint", produces = "application/json")
	public @ResponseBody Point getPoint(@RequestParam(value="pCode" ) String pCode) {
		
		return pointService.getPoint(pCode);
		}	
	/**
	 * @param session
	 * @param point 포인트수정 정보
	 * @param redirectAttributes
	 * @brief 포인트수정
	 * @return /admin/pointList
	 * @author 최지혜
	 */
	@PostMapping("/admin/updatePoint")
	public String updatePoint(HttpSession session
							   , Point point
							   , RedirectAttributes redirectAttributes) {
		
		String saId = (String) session.getAttribute("SAID");
		point.setuId(saId);
		
		redirectAttributes.addFlashAttribute("resultUpdate", pointService.updatePoint(point));
		
		return "redirect:/admin/pointList";
	}
	/**
	 * @param phCode 포인트사용이력 코드
	 * @param redirectAttributes
	 * @brief 포인트사용이력삭제
	 * @return /admin/pointHistoryList
	 * @author 최지혜
	 */
	@GetMapping("/admin/pointDelete")
	public String pointDelete(@RequestParam(value="pCode" ) String pCode
									 , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("resultDelete", pointService.pointDelete(pCode));
		
		return "redirect:/admin/pointList";
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
	@RequestMapping(value="/admin/getPointHistory", produces = "application/json")
	public @ResponseBody List<Point> pointHistorySearchList(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return pointService.pointHistorySearchList(libNum);
		}
	
	/**
	 * @param phCode 포인트사용이력 코드
	 * @param redirectAttributes
	 * @brief 포인트사용이력삭제
	 * @return /admin/pointHistoryList
	 * @author 최지혜
	 */
	@GetMapping("/admin/pointHistoryDelete")
	public String pointHistoryDelete(@RequestParam(value="phCode" ) String phCode
									 , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("resultDelete", pointService.pointHistoryDelete(phCode));
		
		return "redirect:/admin/pointHistoryList";
	}
	
	/**
	 * @param session
	 * @param model
	 * @brief 마이페이지 포인트사용이력리스트 
	 * @return /librarypage/point/myPointList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myPointList")
	public String myPointList(@RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPageStr
							 ,HttpSession session
							 , Model model) {
		
		String uId = (String) session.getAttribute("SID");
		
		Map<String, Object> map = pointService.myPointList(uId, currentPageStr);
	
		model.addAttribute("myPointList", map.get("myPointList"));
		
		model.addAttribute("currentPage", map.get("currentPage"));
    	model.addAttribute("lastPage", map.get("lastPage"));
    	model.addAttribute("startPageNum", map.get("startPageNum"));
    	model.addAttribute("lastPageNum", map.get("lastPageNum"));
    	model.addAttribute("pageViewBlock", map.get("pageViewBlock"));
    	model.addAttribute("pageViewArray", map.get("pageViewArray"));
		
    	model.addAttribute("myTotalPoint", pointService.myTotalPoint(uId));
		
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
	/**
	 * 
	 * @param session
	 * @brief 사용 포인트 리스트
	 * @return 사용 포인트 리스트
	 * @author 최지혜
	 */
	@RequestMapping(value="/lifrary/getUsePointList", produces = "application/json")
	public @ResponseBody List<Point> getUsePointList(HttpSession session) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		return pointService.getUsePointList(libNum);
		}
	
	@PostMapping("/lifrary/myPointInsert")
	public String myPointInsert(@RequestParam(value="pCode" ) String pCode
								, HttpSession session
								, RedirectAttributes redirectAttributes) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String uId = (String) session.getAttribute("SID");
		
		Point point = new Point();
		point.setlCode(libNum);
		point.setuId(uId);
		point.setpCode(pCode);
		
		redirectAttributes.addFlashAttribute("resultInsert", pointService.myPointInsert(point));
		
		return "redirect:/lifrary/myPointList";
	}
}
