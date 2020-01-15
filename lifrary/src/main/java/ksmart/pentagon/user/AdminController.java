package ksmart.pentagon.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import groovyjarjarpicocli.CommandLine.Parameters;
import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;
import ksmart.pentagon.vo.UserLevelHistory;

/*
 * @file   AdminController.java //파일
 * @name   admin controller //이름
 * @brief  관리자페이지 회원관리, 사서관리 //기능
 * @author 한우리 //작성자
 */

/*
 * @file   AdminController.java //파일
 * @name   admin controller //이름
 * @brief  어드민 관련 기능들 //기능
 * @author 김상협 //작성자
 */

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * 어드민 로그인 페이지로 진입
	 * 
	 * @param model
	 * @return adminLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */
	@GetMapping("/admin/login")
	public String adminLoginCheck(HttpSession session) {
		// library => admin 로그인 페이지로 이동시, session에 값이 있는경우 remove해준다.
		if (session.getAttribute("SID") != null) {
			session.removeAttribute("SID");
			session.removeAttribute("SDIV");
			session.removeAttribute("SNAME");
		}
		return "/adminpage/librarian/adminLogin";
	}

	/**
	 * 어드민 로그인 체크후 세션처리까지 하는 메서드
	 * 
	 * @param uId
	 * @param uPw
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/login")
	public String adminLogin(@RequestParam(value = "uId") String uId, @RequestParam(value = "uPw") String uPw,
			HttpSession session, Model model) {
		Map<String, Object> map = adminService.adminLoginCheck(uId, uPw);
		String result = (String) map.get("result");

		User user = (User) map.get("user");

		if (!result.equals("로그인 성공")) {
			// 경고창 출력을 위해 result보내주기
			model.addAttribute("result", result);
			return "/adminpage/librarian/adminLogin";
		}

		session.setAttribute("SAID", user.getuId()); // 아이디
		session.setAttribute("LIBNUM", user.getlCode());
		session.setAttribute("SADIV", user.getuDivision()); // 사서 / 관리자 구분
		session.setAttribute("SANAME", user.getuName()); // 이름
		session.setAttribute("SALI", user.getLibrarianLevel().getLlInsert()); // library insert - 사서 등록
		session.setAttribute("SALC", user.getLibrarianLevel().getLlCarry()); // library carry - 수서
		session.setAttribute("SALBA", user.getLibrarianLevel().getLlBookAdmin()); // library book admin - 대출, 반납, 예약
		session.setAttribute("SALS", user.getLibrarianLevel().getLlStats()); // library stats - 통계
		session.setAttribute("SALBS", user.getLibrarianLevel().getLlBookStock()); // library book stock - 장서 점검
		return "redirect:/admin/index";
	}

	/**
	 * 사서채널 로그아웃 / 세션 제거. 도서관 코드가 없어지면 안되므로 , 설정된 세션만 remove해준다.
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("SAID");
		session.removeAttribute("SADIV");
		session.removeAttribute("SANAME");
		session.removeAttribute("SALI");
		session.removeAttribute("SALC");
		session.removeAttribute("SALBA");
		session.removeAttribute("SALS");
		session.removeAttribute("SALBS");

		return "redirect:/admin/login";
	}

	// 전체회원리스트
	@GetMapping("/admin/userSearchList")
	public String userSearchList(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("uList", adminService.getUserList(libNum));

		return "/adminpage/userManagement/userSearchList";
	}

	/**
	 * 관리자페이지에서 전체회원리스트조회
	 * 
	 * @param model
	 * @return userSearchList페이지
	 * @author 한우리
	 */
	// 전체회원리스트
	@PostMapping("/admin/getUserSearch")
	public String getUserSearch(Model model) {
		model.addAttribute("uList", adminService.getUserSearch());

		return "/adminpage/userManagement/userSearchList";
	}

	/**
	 * 관리자페이지에서 회원수정처리
	 * 
	 * @param model
	 * @param uId
	 * @return adminUserUpdate페이지
	 * @author 한우리
	 */
	// 회원수정처리
	@GetMapping("/admin/adminUserUpdate")
	public String getAdminUserUpdate(@RequestParam(value = "uId") String uId, Model model) {
		model.addAttribute("uUpdate", adminService.getAdminUserUpdate(uId));

		return "/adminpage/userManagement/adminUserUpdate";
	}

	/**
	 * 관리자페이지에서 회원수정처리
	 * 
	 * @param model
	 * @param user
	 * @return userSearchList페이지
	 * @author 한우리
	 */
	// 회원수정화면
	@PostMapping("/admin/adminUserUpdate")
	public String adminUserUpdate(User user) {
		adminService.adminUserUpdate(user);

		return "redirect:/admin/userSearchList";
	}

	/**
	 * 관리자페이지에서 회원상세보기 페이지
	 * 
	 * @return adminUserDetail페이지
	 * @param model
	 * @param uId
	 * @author 한우리
	 */
	// 회원상세보기 페이지
	@GetMapping("/admin/adminUserDetail")
	public String adminUserDetail(Model model, @RequestParam(value = "uId", required = false) String uId) {
		model.addAttribute("userDetail", adminService.adminUserDetail(uId));

		return "/adminpage/userManagement/adminUserDetail";
	}

	/************************************************************************************************/

	/**
	 * 관리자페이지에서 회원등급 등록
	 * 
	 * @return userLevelInsert페이지
	 * @author 한우리
	 */
	// 회원등급등록화면
	@GetMapping("/admin/adUserLevelInsert")
	public String adUserLevelInsert() {

		return "/adminpage/userManagement/adUserLevelInsert";
	}

	// 회원등급 등록화면
	@PostMapping("/admin/adUserLevelInsert")
	public String adUserLevelInsert(UserLevel userLevel, Model model, HttpSession session) {

		String getSAID = (String) session.getAttribute("SAID");
		String libNum = (String) session.getAttribute("LIBNUM");

		adminService.adUserLevelInsert(userLevel);

		return "redirect:/admin/adUserLevelList";
	}

	/**
	 * 관리자페이지에서 회원 등급 리스트
	 * 
	 * @param model
	 * @return adUserLevelList페이지
	 * @author 한우리
	 */
	// 관리자가 유저 회원 등급 리스트
	@GetMapping("/admin/adUserLevelList")
	public String adUserLevelList(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("userLevel", adminService.adUserLevelList(libNum));

		return "/adminpage/userManagement/adUserLevelList";
	}

	/**
	 * 관리자페이지에서 회원 등급 수정
	 * 
	 * @param model
	 * @param ulLevel
	 * @return adUserLevelUpdate페이지
	 * @author 한우리
	 */
	// 관리자가 유저 회원 등급 수정
	@GetMapping("/admin/adUserLevelUpdate")
	public String getAdUserLevelUpdate(@RequestParam(value = "ulLevel", required = false) String ulLevel,
			HttpSession session, Model model) {
		String getSAID = (String) session.getAttribute("getSAID");
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("lUpdate", adminService.getAdUserLevelUpdate(ulLevel, getSAID));

		return "/adminpage/userManagement/adUserLevelUpdate";
	}

	// 관리자가 유저 회원 등급 수정후 리스트로 보냄
	@PostMapping("/admin/adUserLevelUpdate")
	public String adUserLevelUpdate(UserLevel userLevel) {
		adminService.adUserLevelUpdate(userLevel);

		return "redirect:/admin/adUserLevelList";
	}

	/**
	 * @관리자 유저 회원 등급 내역 검색리스트
	 * @param model
	 * @return adUserLevelHistorySearchList페이지
	 * @author 한우리
	 */
	// 관리자 유저 회원 등급 내역 검색리스트
	@GetMapping("/admin/adUserLevelHistorySearchList")
	public String adUserLevelHistorySearchList(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("levelHistory", adminService.adUserLevelHistorySearchList(libNum));

		return "/adminpage/userManagement/adUserLevelHistorySearchList";
	}

	@PostMapping("/admin/adUserLevelHistorySearchList")
	public String adUserLevelHistorySearch(Model model) {
		model.addAttribute("levelHistory", adminService.adUserLevelHistorySearch());

		return "/adminpage/userManagement/adUserLevelHistorySearchList";
	}

	/************************************************************************************************/

	/**
	 * 관리자페이지에서 회원권한등록
	 * 
	 * @return adUserAuthorityInsert페이지
	 * @author 한우리
	 */
	// 회원 권한 등록 화면
	@GetMapping("/admin/adUserAuthorityInsert")
	public String adUserAuthorityInsert() {

		return "/adminpage/userManagement/adUserAuthorityInsert";
	}

	/**
	 * 관리자페이지에서 회원권한등록
	 * 
	 * @param userAuthoritySet
	 * @param model
	 * @return adUserAuthorityInsert페이지
	 * @author 한우리
	 */
	@PostMapping("/admin/adUserAuthorityInsert")
	public String adUserAuthorityInsert(UserAuthoritySet userAuthoritySet, Model model, HttpSession session) {

		String getSAID = (String) session.getAttribute("SAID");
		String libNum = (String) session.getAttribute("LIBNUM");

		userAuthoritySet.setlCode(libNum);
		userAuthoritySet.setuId(getSAID);
		adminService.adUserAuthorityInsert(userAuthoritySet);

		return "redirect:/admin/adUserAuthorityList";
	}

	/**
	 * 관리자페이지에서 회원권한 리스트화면
	 * 
	 * @param userAuthoritySet
	 * @return adUserAuthorityLis페이지
	 * @author 한우리
	 */
	// 관리자가 회원권한 리스트
	@GetMapping("/admin/adUserAuthorityList")
	public String adUserAuthorityList(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("userAuthority", adminService.adUserAuthorityList(libNum));

		return "/adminpage/userManagement/adUserAuthorityList";
	}

	// 관리자가 회원권한 수정
	@GetMapping("/admin/adUserAuthorityUpdate")
	public String getAdUserAuthorityUpdate(@RequestParam(value = "uasCode", required = false) String uasCode,
			HttpSession session, Model model) {

		String getSAID = (String) session.getAttribute("SAID");
		model.addAttribute("aUpdate", adminService.getAdUserAuthorityUpdate(uasCode, getSAID));

		return "/adminpage/userManagement/adUserAuthorityUpdate";
	}

	// 관리자가 회원권한 수정 후 리스트로 보냄
	@PostMapping("/admin/adUserAuthorityUpdate")
	public String adUserAuthorityUpdate(UserAuthoritySet userAuthoritySet) {
		adminService.adUserAuthorityUpdate(userAuthoritySet);

		return "redirect:/admin/adUserAuthorityList";
	}

	/**
	 * @관리자 유저 회원 권한 내역 검색리스트
	 * @param model
	 * @return adUserAuthorityHistorySearchList페이지
	 * @author 한우리
	 */
	// 관리자 유저 회원 등급 내역 검색리스트
	@GetMapping("/admin/adUserAuthorityHistorySearchList")
	public String adUserAuthorityHistorySearchList(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("authorityHistory", adminService.adUserAuthorityHistorySearchList(libNum));

		return "/adminpage/userManagement/adUserAuthorityHistorySearchList";
	}

	@PostMapping("/admin/adUserAuthorityHistorySearchList")
	public String adUserAuthorityHistorySearch(Model model) {
		model.addAttribute("authorityHistory", adminService.adUserAuthorityHistorySearch());

		return "/adminpage/userManagement/adUserAuthorityHistorySearchList";
	}

	/************************************************************************************************/

	/**
	 * 관리자페이지에서 사서 전체리스트
	 * 
	 * @param model
	 * @return librarianLevelList페이지
	 * @author 한우리
	 */
	// 관리자가 보는 사서 전체 리스트
	@GetMapping("/admin/librarianLevelList")
	public String librarianLevelList1(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("lList", adminService.librarianLevelList1(libNum));

		return "/adminpage/librarian/librarianLevelList";
	}

	// 관리자가 보는 사서 검색 전체 리스트2
	@PostMapping("/admin/librarianLevelList")
	public String librarianLevelList2(Model model, HttpSession session) {

		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("lList", adminService.librarianLevelList2(libNum));

		return "/adminpage/librarian/librarianLevelList";
	}

	/**
	 * 관리자페이지에서 사서등록
	 * 
	 * @return librarianInsert페이지
	 * @author 한우리
	 */
	// 사서 등록
	@GetMapping("/admin/librarianInsert")
	public String librarianInsert() {

		return "/adminpage/librarian/librarianInsert";
	}

	// 사서 등록
	@PostMapping("/admin/librarianInsert")
	public String librarianInsert(HttpSession session, User user, LibrarianLevel librarianLevel) {
		String libNum = (String) session.getAttribute("LIBNUM");

		user.setlCode(libNum);
		librarianLevel.setlCode(libNum);
		adminService.librarianInsert1(user);
		adminService.librarianInsert2(librarianLevel);

		return "redirect:/admin/librarianLevelList";
	}

	/**
	 * 관리자가 사서정보&권한 수정하기
	 * 
	 * @return librarianLevelUpdate폼
	 * @return librarianLevelList 리스트
	 * @author 한우리
	 */
	// 관리자가 사서정보&권한 수정하기 >> 폼
	@GetMapping("/admin/librarianLevelUpdate")
	public String getLibrarianLevelUpdate(@RequestParam(value = "uId", required = false) String uId,
			HttpSession session, Model model) {

		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("librarianLevelUpdate", adminService.getLibrarianLevelUpdate(uId, libNum));

		return "/adminpage/librarian/librarianLevelUpdate";
	}

	// 관리자가 사서정보&권한 수정후 리스트로 보내기
	@PostMapping("/admin/librarianLevelUpdate")
	public String librarianLevelUpdate(User user, LibrarianLevel librarianLevel) {

		adminService.librarianLevelUpdate1(user);
		adminService.librarianLevelUpdate2(librarianLevel);

		return "redirect:/admin/librarianLevelList";

	}

	// 사서 상세보기 폼

	@GetMapping("/admin/librarianDetail")
	public String librarianDetail(Model model, @RequestParam(value = "uId", required = false) String uId) {

		model.addAttribute("librarianDetail", adminService.librarianDetail(uId));

		return "/adminpage/librarian/librarianDetail";
	}

	/*****************************************************************************
	 * 사서 마이페이지 @@@@@
	 ****************************************************************************/

	/**
	 * 사서 자신 정보 수정폼
	 * 
	 * @param model
	 * @return librarianMyUpdate페이지
	 * @author 한우리
	 */
	// 사서 자신 정보 수정폼
	@GetMapping("/admin/librarianMyUpdate")
	public String getLibrarianMyUpdate(Model model, HttpSession session) {

		String getSAID = (String) session.getAttribute("SAID"); // 세션에서 사서ID
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("librarianMyUpdate", adminService.getLibrarianMyUpdate(getSAID, libNum));

		return "/adminpage/librarian/librarianMyUpdate";
	}

	// 사서 자신 정보 수정 //제출하다
	@PostMapping("/admin/librarianMyUpdate")
	public String librarianMyUpdate(User user) {

		adminService.librarianMyUpdate(user);
		return "redirect:/admin/librarianMyDetail";
	}

	// 사서 자신 정보 상세보기
	@GetMapping("/admin/librarianMyDetail")
	public String librarianMyDetail(Model model, HttpSession session) {

		String getSAID = (String) session.getAttribute("SAID"); // 세션에서 사서ID
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("librarianMyDetail", adminService.librarianMyDetail(getSAID, libNum));

		return "/adminpage/librarian/librarianMyDetail";

	}

	/*******************************************************************************************/

	// userSearchList 삭제 결과값 가져오는 ajax - 회원 삭제
	// 컨트롤러를 통해 보내고있는 응답의 유형을 나타 내기 위해 produce를 사용
	@RequestMapping(value = "/deleteUser", produces = "text/plain")
	public @ResponseBody String deleteUser(Model model, @RequestParam(value = "said", required = false) String said,
			@RequestParam(value = "write", required = false) String write,
			@RequestParam(value = "uId", required = false) String uId) {

		int result = adminService.deleteUser(said, write, uId);
		String text = "";
		if (result == 0) {
			text = "비밀번호가 틀렸습니다";
		} else if (result == 1) {
			text = "회원 삭제가 완료되었습니다";
		}
		return text;
	}

	// adUserLevelList 삭제 결과값 가져오는 ajax - 회원등급 삭제
	@RequestMapping(value = "/deleteLevel", produces = "text/plain")
	public @ResponseBody String deleteLevel(Model model, @RequestParam(value = "said", required = false) String said,
			@RequestParam(value = "write", required = false) String write,
			@RequestParam(value = "ulLevel", required = false) String ulLevel) {

		int result = adminService.deleteLevel(said, write, ulLevel);
		String text = "";
		if (result == 0) {
			text = "비밀번호가 틀렸습니다";
		} else if (result == 1) {
			text = "등급 삭제가 완료되었습니다";
		}
		return text;
	}

}
