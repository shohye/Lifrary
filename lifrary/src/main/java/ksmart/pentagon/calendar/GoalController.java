package ksmart.pentagon.calendar;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.Goal;

@Controller
public class GoalController {
	@Autowired private GoalService goalService;
	
	@RequestMapping(value="/lifrary/getGoalList", produces = "application/json")
	public @ResponseBody List<Goal> getGoalList(HttpSession session
												, @RequestParam(value="gEndDate") String gEndDate) {
		
		String uId = (String) session.getAttribute("SID");
		
		return goalService.getGoalList(uId, gEndDate);
		}
	/**
	 * 
	 * @param session
	 * @param goal 
	 * @brief 목표량 등록
	 * @author 최지혜
	 * @return /lifrary/myCalender 캘린더 페이지
	 */
	@PostMapping("/lifrary/goalInsert")
	public String goalInsert(HttpSession session
							 ,Goal goal) {
		String libNum = (String) session.getAttribute("LIBNUM");
		String uId = (String) session.getAttribute("SID");
		goal.setlCode(libNum);
		goal.setuId(uId);
		
		System.out.println(goal.toString());
		
		int resutl = goalService.goalInsert(goal);
		System.out.println(resutl);
		
		return "redirect:/lifrary/myCalender";	
	}
	
	

}
