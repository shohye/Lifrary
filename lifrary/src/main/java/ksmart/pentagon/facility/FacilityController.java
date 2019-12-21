package ksmart.pentagon.facility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.Facility;

/*
 * @file   FacilityController.java 
 * @name   facility controller 
 * @brief  공공시설  관련 기능들 
 * @author 김상협
 */

@Controller
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	// 열람실 관련 메서드

	@GetMapping("/lifrary/readingRoom")
	public String readingRoom(Model model) {
		model.addAttribute("room", "reading");

		return "librarypage/facility/readingRoomReservation";
	}

	// 스터디룸 관련 메서드

	@GetMapping("/lifrary/studyRoom")
	public String studyRoom(Model model) {
		model.addAttribute("room", "study");
		return "librarypage/facility/studyRoomReservation";
	}

	// 강연실 관련 메서드

	@GetMapping("/lifrary/lectureRoom")
	public String lectureRoom(Model model) {
		model.addAttribute("room", "lecture");
		return "librarypage/facility/lectureRoomReservation";
	}

	// 사물함 관련 메서드

	@GetMapping("/lifrary/locker")
	public String locker(Model model) {
		model.addAttribute("room", "locker");
		return "librarypage/facility/lockerReservation";
	}

	/* ======================================================== */
	/* ======================================================== */
	/* ======================================================== */
	/* ==========================사서채널============================ */

	/**
	 * 시설종류, 도서관코드를 받아 리스트 출력.
	 * 
	 * @param fKinds
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityList")
	public String facilityList(@RequestParam(value = "fKinds", required = false, defaultValue = "전체") String fKinds,
			HttpSession session, Model model) {
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("facilityList", facilityService.getFacilityList(fKinds, libNum));
		model.addAttribute("nowKinds", fKinds);
		return "adminpage/facility/facilityList";
	}

	/**
	 * fCode에 맞는 시설의 상세보기.
	 * 
	 * @param fCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityDetail")
	public String facilityDetail(@RequestParam(value = "fCode") String fCode, HttpSession session, Model model) {
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("facility", facilityService.getFacility(fCode, libNum));

		return "adminpage/facility/facilityDetail";
	}

	@GetMapping("/admin/facilityInsert")
	public String facilityInsert() {
		return "adminpage/facility/facilityInsert";
	}

	/**
	 * 공공시설 등록하기. 등록후 리스트로 이동한다.
	 * 
	 * @param facility
	 * @return
	 */
	@PostMapping("/admin/facilityInsert")
	public String facilityInsert(Facility facility) {
		facility.setfCode("f-19122100001");
		System.out.println(facility);
		facilityService.insertFacility(facility);

		return "redirect:/admin/facilityList";
	}
	
	/**
	 * 공공시설 상세보기 페이지에서 수정페이지로 이동. 
	 * @param fCode
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityUpdate")
	public String facilityUpdate(@RequestParam(value = "fCode")String fCode, HttpSession session ,Model model) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("facility", facilityService.getFacility(fCode, libNum));
		return "adminpage/facility/facilityUpdate";
	}
	
	@GetMapping("/admin/facilityReservationSearchList")
	public String facilityReservationSearchList() {

		return "adminpage/facility/facilityReservationSearchList";
	}


	/**
	 * ajax활용. 테이블을 동적으로 만들어준다.
	 * 
	 * @param garo
	 * @param sero
	 * @return
	 */

	@PostMapping("/libSeat")
	public @ResponseBody Map<String, Integer> libSeat(@RequestParam(value = "garo") int garo,
			@RequestParam(value = "sero") int sero) {

		Map<String, Integer> data = new HashMap<String, Integer>();

		data.put("getGaro", garo);
		data.put("getSero", sero);

		return data;
	}

	/**
	 * ajax활용. form에 입력될 배열을 문자열로 뿌려줌.
	 * 
	 * @param seatArray
	 * @return
	 */
	@PostMapping("/getArray")
	public @ResponseBody String getArray(@RequestParam(value = "seatArray") List<String> seatArray) {
		System.out.println(seatArray + " <== seatArray");
		String array = "";
		for (int i = 0; i < seatArray.size(); i++) {
			if ((i + 1) != seatArray.size()) {
				array += seatArray.get(i) + ",";
			} else if ((i + 1) == seatArray.size()) {
				array += seatArray.get(i);
			}
		}
		System.out.println(array);

		return array;
	}

}
