package ksmart.pentagon.facility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @file   FacilityController.java 
 * @name   facility controller 
 * @brief  공공시설  관련 기능들 
 * @author 김상협
 */

@Controller
public class FacilityController {

	@Autowired private FacilityService facilityService;


	//열람실 관련 메서드
	
	@GetMapping("/lifrary/readingRoom")
	public String readingRoom(Model model) {
		model.addAttribute("room", "reading");
		
		return "librarypage/facility/readingRoomReservation";
	}
	
	
	//스터디룸 관련 메서드
	
	@GetMapping("/lifrary/studyRoom")
	public String studyRoom(Model model) {
		model.addAttribute("room", "study");
		return "librarypage/facility/studyRoomReservation";
	}
	
	
	//강연실 관련 메서드
	
	@GetMapping("/lifrary/lectureRoom")
	public String lectureRoom(Model model) {
		model.addAttribute("room", "lecture");
		return "librarypage/facility/lectureRoomReservation";
	}
	
	
	//사물함 관련 메서드
	
	@GetMapping("/lifrary/locker")
	public String locker(Model model) {
		model.addAttribute("room", "locker");
		return "librarypage/facility/lockerReservation";
	}
	
	/* ======================================================== */
	/* ======================================================== */
	/* ======================================================== */
	/*  ==========================사서채널============================ */

	/**
	 * 시설종류, 도서관코드를 받아 리스트 출력.
	 * @param fKinds
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityList")
	public String facilityList(@RequestParam(value = "fKinds", required = false ,defaultValue = "전체") String fKinds, HttpSession session, Model model) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("facilityList", facilityService.getFacilityList(fKinds, libNum));
		model.addAttribute("nowKinds", fKinds);
		return "adminpage/facility/facilityList";
	}
	
	/**
	 * fCode에 맞는 시설의 상세보기.
	 * @param fCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityDetail")
	public String facilityDetail(@RequestParam(value = "fCode")String fCode, HttpSession session, Model model) {
		String libNum = (String)session.getAttribute("LIBNUM");
		
		model.addAttribute("facility", facilityService.getFacility(fCode, libNum));
		
		return "adminpage/facility/facilityDetail";
	}
	
	@GetMapping("/admin/facilityReservationSearchList")
	public String facilityReservationSearchList() {
		
		return "adminpage/facility/facilityReservationSearchList";
	}
	
	@GetMapping("/admin/facilityUpdate")
	public String facilityUpdate() {
		
		return "adminpage/facility/facilityUpdate";
	}
	
	
	@GetMapping("/admin/facilityInsert")
	public String facilityInsert() {
		return "adminpage/facility/facilityInsert";
	}
	
	
	
	@PostMapping("/libSeat")
	public String libSeat(@RequestParam(value = "garo") int garo, @RequestParam(value = "sero") int sero, Model model) {

		List<Integer> sList = new ArrayList<Integer>();
		List<Integer> gList = new ArrayList<Integer>();

		for (int i = 0; i < garo; i++) {
			gList.add(i);
		}
		for (int i = 0; i < sero; i++) {
			sList.add(i);
		}

		model.addAttribute("sList", sList);
		model.addAttribute("gList", gList);
		model.addAttribute("garo", garo);

		/*
		 * for(int i = 0; i < 5; i++) { for(int j = 0; j < 5; i++) {
		 * System.out.print(i*5+j+" "); } System.out.println(); }
		 */

		return "adminpage/facility/facilityInsert";
	}
	
	
}
