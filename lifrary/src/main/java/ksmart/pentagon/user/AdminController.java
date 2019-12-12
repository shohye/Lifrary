package ksmart.pentagon.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;

/*
 * @file   AdminController.java //파일
 * @name   admin controller //이름
 * @brief  관리자페이지 회원관리  //기능
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

	@Autowired private AdminService adminService;
	
	@GetMapping("/test")
	public String test(Model model) {
		System.out.println("@@@@@@@@@@@@@@@@@컨트롤러 진입@@@@@@@@@@@@@@@@@@");
		model.addAttribute("getUserLevel", adminService.getUserLevel());
		System.out.println("@@@@@@@@@@@@@@@@@서비스 탈출@@@@@@@@@@@@@@@@@@");
		return "test";
	}
	/**
	 * 어드민 로그인 페이지로 진입
	 * @param model
	 * @return adminLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */
	@GetMapping("/admin/login")
	public String adminLoginCheck(HttpSession session) {
		//library => admin  로그인 페이지로 이동시, session에 값이 있는경우 remove해준다.
		if(session.getAttribute("SID") != null) {
			System.out.println("세션에 SID값이 있습니다");
			session.removeAttribute("SID");
			session.removeAttribute("SDIV");
			session.removeAttribute("SNAME");
			System.out.println("세션이 잘 종료되었습니다.");
		}else {
			System.out.println("세션값이 없습니다.");
		}
		return "/adminpage/librarian/adminLogin";
	}
	
	/**
	 * 어드민 로그인 체크후 세션처리까지 하는 메서드
	 * @param uId
	 * @param uPw
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/login")
	public String adminLogin(@RequestParam(value = "uId")String uId, @RequestParam(value = "uPw")String uPw, HttpSession session, Model model) {
		System.out.println(uId + " <== uId");
		System.out.println(uPw + " <== uPw");
		
		Map<String,Object> map =  adminService.adminLoginCheck(uId, uPw);
		String result = (String)map.get("result");
		User user = (User)map.get("user");
		
		if(!result.equals("로그인 성공")) {
			//경고창 출력을 위해 result보내주기
			model.addAttribute("result", result);
			return "/adminpage/librarian/adminLogin";
		}
		
		session.setAttribute("SAID",user.getuId()); // 아이디
		session.setAttribute("SADIV",user.getuDivision()); // 사서 / 관리자 구분
		session.setAttribute("SANAME",user.getuName()); // 이름
		session.setAttribute("SALI",user.getLibrarianLevel().getLlInsert()); // library insert - 사서 등록
		session.setAttribute("SALC",user.getLibrarianLevel().getLlCarry()); // library carry - 수서
		session.setAttribute("SALBA",user.getLibrarianLevel().getLlBookAdmin()); // library book admin - 대출, 반납, 예약
		session.setAttribute("SALS",user.getLibrarianLevel().getLlStats()); // library stats - 통계
		session.setAttribute("SALBS",user.getLibrarianLevel().getLlBookStock()); // library book stock - 장서 점검 
		System.out.println(result + " < == result");
		return "redirect:/admin/index";
	}
	/**
	 * 사서채널 로그아웃 / 세션 제거.
	 * 도서관 코드가 없어지면 안되므로 , 설정된 세션만 remove해준다.
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
		
		return "redirect:/adminLogin";
	}
	
	
	//전체회원리스트
	@GetMapping("/admin/userSearchList")
	public String userSearchList(Model model) {
		System.out.println("userSearchList 전체회원리스트  @GetMapping ");
		
		List<User> uList = adminService.getUserList();
		System.out.println(uList + " <<== adminService.getUserList() ");
		model.addAttribute("uList",uList);
		
		return "/adminpage/userManagement/userSearchList";
	}
	
	//전체회원리스트
	@PostMapping("/admin/getUserSearch")
	public String getUserSearch(Model model) {
		System.out.println(" getUserSearch 전체회원리스트  @PostMapping");
		model.addAttribute("uList", adminService.getUserSearch());
	
		return "/adminpage/userManagement/userSearchList";
	}
	
   //회원수정처리
	@GetMapping("/admin/adminUserUpdate") 
	public String getAdminUserUpdate(@RequestParam(value = "uId") String uId, Model model) {
		System.out.println("getAdminUserUpdate @GetMapping 회원수정 처리 (Id로 업데이트)"); 
		model.addAttribute("uUpdate", adminService.getAdminUserUpdate(uId));
		
		return "/adminpage/userManagement/adminUserUpdate"; 
	}
	
	//회원수정화면
	@PostMapping("/admin/adminUserUpdate")
	public String adminUserUpdate(User user) {
		System.out.println("adminUserUpdate @PostMapping 회원수정 화면 ");
		System.out.println(user.toString() + "<==== user ");
		adminService.adminUserUpdate(user);
		
		return "redirect:/userSearchList";
	}
		
		
	//회원등급등록화면
   @GetMapping("/admin/userLevelInsert") 
   public String userAuthorityInsert() {
	  System.out.println("userLevelInsert 회원등급등록화면 "); 
	  
	  return "/adminpage/userManagement/userLevelInsert";
	  }

   	//사서 전체 리스트
	@GetMapping("/admin/librarianSearchList")
	public String librarianSearchList(Model model) { 
		 System.out.println("librarianSearchList 전체사서리스트 ");
	 
	  return "/adminpage/librarian/librarianSearchList"; }
	 
	//사서 등록 
	@GetMapping("/admin/librarianInsert") 
    public String librarianInsert() {
      System.out.println("librarianInsert 사서등록 "); 
      return "/adminpage/librarian/librarianInsert";
     }
   
	//사서 등록
	@PostMapping("/admin/librarianInsert")
    public String librarianInsert(LibrarianLevel librarianLevel, Model model) {
	   System.out.println(librarianLevel + " ==> librarianInsert librarianLevel");
	   
	   return "redirect:/adminpage/librarian/librarianInsert";
   } 
	
		
	
}
