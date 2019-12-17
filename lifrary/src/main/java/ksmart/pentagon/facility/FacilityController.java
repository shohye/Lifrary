package ksmart.pentagon.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @file   FacilityController.java 
 * @name   facility controller 
 * @brief  공공시설  관련 기능들 
 * @author 김상협
 */

@Controller
public class FacilityController {

	@Autowired private FacilityService facilityService;
	
	
	@GetMapping("/lifrary/readingRoom")
	public String readingRoom(Model model) {
		model.addAttribute("room", "reading");
		
		return "librarypage/facility/readingRoomReservation";
	}
	
	@GetMapping("/lifrary/studyRoom")
	public String studyRoom(Model model) {
		model.addAttribute("room", "study");
		return "librarypage/facility/studyRoomReservation";
	}
	
	@GetMapping("/lifrary/lectureRoom")
	public String lectureRoom(Model model) {
		model.addAttribute("room", "lecture");
		return "librarypage/facility/lectureRoomReservation";
	}
		
	@GetMapping("/lifrary/locker")
	public String locker(Model model) {
		model.addAttribute("room", "locker");
		return "librarypage/facility/lockerReservation";
	}
	
}
