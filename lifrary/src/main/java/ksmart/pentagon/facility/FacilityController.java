package ksmart.pentagon.facility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.Facility;
import ksmart.pentagon.vo.FacilityReservation;

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

	/**
	 * 열람실 신청 페이지로 이동
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/readingRoom")
	public String readingRoom(Model model, HttpSession session) {
		String fKinds = "열람실";
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("room", "reading");
		model.addAttribute("facility", facilityService.getFacilityList(fKinds, libNum));
		return "librarypage/facility/readingRoomReservation";
	}

	/**
	 * 스터디룸 신청 페이지로 이동
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/studyRoom")
	public String studyRoom(Model model, HttpSession session) {
		String fKinds = "스터디룸";
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("room", "study");
		model.addAttribute("facility", facilityService.getFacilityList(fKinds, libNum));
		return "librarypage/facility/studyRoomReservation";
	}

	/**
	 * 강연실 신청 페이지로 이동
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/lectureRoom")
	public String lectureRoom(Model model, HttpSession session) {
		String fKinds = "강연실";
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("room", "lecture");
		model.addAttribute("facility", facilityService.getFacilityList(fKinds, libNum));
		return "librarypage/facility/lectureRoomReservation";
	}

	/**
	 * 사물함 신청 페이지로 이동
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/locker")
	public String locker(Model model, HttpSession session) {
		String fKinds = "사물함";
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("room", "locker");
		model.addAttribute("facility", facilityService.getFacilityList(fKinds, libNum));
		return "librarypage/facility/lockerReservation";
	}

	/**
	 * 마이페이지 - 열람실 신청 내역
	 * 
	 * @param model
	 * @param session
	 * @return
	 */

	@GetMapping("/lifrary/myReadingRoomReserveList")
	public String myReadingRoomReserveList(Model model, HttpSession session) {
		String uId = (String) session.getAttribute("SID");
		String libNum = (String) session.getAttribute("LIBNUM");
		String fKinds = "열람실";
		model.addAttribute("frList", facilityService.getFacilityReservationList(uId, libNum, fKinds));
		model.addAttribute("fKinds", fKinds);
		return "librarypage/facility/myReadingRoomReserveList";
	}

	/**
	 * 연장 버튼 클릭시, 연장이 가능한지 확인 후 연장처리.
	 * 
	 * @param frCode
	 * @return
	 */
	@PostMapping("/lifrary/extension")
	public @ResponseBody String extensionUpdate(@RequestParam(value = "frCode") String frCode) {
		String result = facilityService.getReservation(frCode);
		return result;
	}

	/**
	 * 퇴실 버튼 클릭시, 종료시간을 현재시간으로 업데이트
	 * 
	 * @param frCode
	 * @return
	 */
	@PostMapping("/lifrary/leaving")
	public @ResponseBody String leavingUpdate(@RequestParam(value = "frCode") String frCode) {
		facilityService.frEndDateChange(frCode);
		String result = "사용 종료 처리가 완료되었습니다.";
		return result;
	}

	/**
	 * 마이페이지 - 스터디룸 신청 내역
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/myStudyRoomReserveList")
	public String myStudyRoomReserveList(Model model, HttpSession session) {
		String uId = (String) session.getAttribute("SID");
		String libNum = (String) session.getAttribute("LIBNUM");
		String fKinds = "스터디룸";
		model.addAttribute("frList", facilityService.getFacilityReservationList(uId, libNum, fKinds));
		model.addAttribute("fKinds", fKinds);
		return "librarypage/facility/myStudyRoomReserveList";
	}

	/**
	 * 마이페이지 - 강연실 신청 내역
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/myLectureRoomReserveList")
	public String myLectureRoomReserveList(Model model, HttpSession session) {
		String uId = (String) session.getAttribute("SID");
		String libNum = (String) session.getAttribute("LIBNUM");
		String fKinds = "강연실";
		model.addAttribute("frList", facilityService.getFacilityReservationList(uId, libNum, fKinds));
		model.addAttribute("fKinds", fKinds);
		return "librarypage/facility/myLectureRoomReserveList";
	}

	/**
	 * 마이페이지 - 사물함 신청 내역
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/myLockerReserveList")
	public String myLockerReserveList(Model model, HttpSession session) {
		String uId = (String) session.getAttribute("SID");
		String libNum = (String) session.getAttribute("LIBNUM");
		String fKinds = "사물함";
		model.addAttribute("frList", facilityService.getFacilityReservationList(uId, libNum, fKinds));
		model.addAttribute("fKinds", fKinds);
		return "librarypage/facility/myLockerReserveList";
	}

	/**
	 * fCode를 이용하여 자리 테이블에대한 값을 가져옴.
	 * 
	 * @param fCode
	 * @return
	 */
	@PostMapping("/lifrary/reservationAjax")
	public @ResponseBody Map<String, List<String>> getSeat(@RequestParam(value = "fCode") String fCode) {
		Map<String, List<String>> data = new HashMap<String, List<String>>(); // ajax의 결과물을 보내기 위해 Map을 만들어준다.
		data.put("seatNum", facilityService.getReservationSeat(fCode)); // integer타입을 담는 리스트를 seatNum이라는 키값과 함께 put한다.
		return data;
	}

	/**
	 * 공공시설 예약 처리 메서드 당일 예약한 기록이 있으면 등록 안되게 막기. return 해서 경로 이동을 해도 되지만 에러. 에러가 나도
	 * 이동은 가능. HttpServletResponse객체때문에 에러남.
	 * 
	 * @param fr
	 * @param fKinds
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/lifrary/reservation")
	public void reservation(FacilityReservation fr, HttpServletResponse response) throws IOException {
		System.out.println(fr + " <== reservation");
		String result = facilityService.reserveFacility(fr);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('" + result + "'); history.go(-1);</script>");
		out.flush();

		// return "/lifrary/readingRoom";
	}

	/* ======================================================== */
	/* ======================================================== */
	/* ======================================================== */
	/* ==========================사서채널======================== */

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

	/**
	 * 공공시설 등록 페이지로 이동
	 * 
	 * @return
	 */
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
		System.out.println(facility);
		facilityService.insertFacility(facility);

		return "redirect:/admin/facilityList";
	}

	/**
	 * 공공시설 상세보기 페이지에서 수정페이지로 이동.
	 * 
	 * @param fCode
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/facilityUpdate")
	public String facilityUpdate(@RequestParam(value = "fCode") String fCode, HttpSession session, Model model) {
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("facility", facilityService.getFacility(fCode, libNum));
		return "adminpage/facility/facilityUpdate";
	}

	/**
	 * 공공시설 수정후 디테일로 이동하기
	 * 
	 * @param facility
	 * @return
	 */
	@PostMapping("/admin/facilityUpdate")
	public String facilityUpdate(Facility facility) {
		System.out.println(facility);
		facilityService.updateFacility(facility);
		return "redirect:/admin/facilityDetail?fCode=" + facility.getfCode();
	}

	/**
	 * 공공시설 삭제후 리스트로 이동
	 * 
	 * @param fCode
	 * @return
	 */
	@GetMapping("/admin/facilityDelete")
	public String facilityDelete(@RequestParam(value = "fCode") String fCode) {
		facilityService.deleteFacility(fCode);
		return "redirect:/admin/facilityList";
	}

	@GetMapping("/admin/facilityReservationSearchList")
	public String facilityReservationSearchList(
			@RequestParam(value = "fKinds", required = false, defaultValue = "전체") String fKinds, HttpSession session,
			Model model) {
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("facilityReserveList", facilityService.getFacilityReservation(fKinds, libNum));
		model.addAttribute("nowKinds", fKinds);
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
