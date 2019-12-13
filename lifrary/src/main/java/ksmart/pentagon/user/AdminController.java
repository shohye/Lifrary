package ksmart.pentagon.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;

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

	@Autowired private AdminService adminService;
	
	/*
	 * @GetMapping("/test") public String test(Model model) {
	 * System.out.println("@@@@@@@@@@@@@@@@@컨트롤러 진입@@@@@@@@@@@@@@@@@@");
	 * model.addAttribute("getUserLevel", adminService.getUserLevel());
	 * System.out.println("@@@@@@@@@@@@@@@@@서비스 탈출@@@@@@@@@@@@@@@@@@"); return
	 * "test"; }
	 */
	/**
	 * 어드민 로그인 페이지로 진입
	 * @param model
	 * @return adminLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "adminpage/librarian/adminLogin";
	}
	
	/**
	 * 관리자페이지에서 전체회원리스트조회
	 * @param model
	 * @return userSearchList페이지
	 * @author 한우리
	 */
	//전체회원리스트
	@GetMapping("/admin/userSearchList")
	public String userSearchList(Model model) {
		System.out.println("userSearchList 전체회원리스트  @GetMapping ");
		
		List<User> uList = adminService.getUserList();
		System.out.println(uList + " <<== adminService.getUserList() ");
		model.addAttribute("uList",uList);
		
		return "/adminpage/userManagement/userSearchList";
	}
	
	/**
	 * 관리자페이지에서 전체회원리스트조회
	 * @param model
	 * @return userSearchList페이지
	 * @author 한우리
	 */
	//전체회원리스트
	@PostMapping("/admin/getUserSearch")
	public String getUserSearch(Model model) {
		System.out.println(" getUserSearch 전체회원리스트  @PostMapping");
		model.addAttribute("uList", adminService.getUserSearch());
	
		return "/adminpage/userManagement/userSearchList";
	}
	
	/**
	 * 관리자페이지에서 회원수정처리
	 * @param model
	 * @param uId
	 * @return adminUserUpdate페이지
	 * @author 한우리
	 */
   //회원수정처리
	@GetMapping("/admin/adminUserUpdate") 
	public String getAdminUserUpdate(@RequestParam(value = "uId") String uId, Model model) {
		System.out.println("getAdminUserUpdate @GetMapping 회원수정 처리 (Id로 업데이트)"); 
		model.addAttribute("uUpdate", adminService.getAdminUserUpdate(uId));
		
		return "/adminpage/userManagement/adminUserUpdate"; 
	}
	
	/**
	 * 관리자페이지에서 회원수정처리
	 * @param model
	 * @param user
	 * @return userSearchList페이지
	 * @author 한우리
	 */
	//회원수정화면
	@PostMapping("/admin/adminUserUpdate")
	public String adminUserUpdate(User user) {
		System.out.println("adminUserUpdate @PostMapping 회원수정 화면 ");
		System.out.println(user.toString() + "<==== user ");
		adminService.adminUserUpdate(user);
		
		return "redirect:/admin/userSearchList";
	}
		
	/**
	 * 관리자페이지에서 회원상세보기 페이지
	 * @return adminUserDetail페이지
	 * @param model
	 * @param uId
	 * @author 한우리
	 */
	//회원상세보기 페이지
	@GetMapping("/admin/adminUserDetail")
	public String adminUserDetail(Model model, @RequestParam(value="uId",required=false) String uId) {
		System.out.println("adminUserDetail 회원상세보기 화면 "); 
		model.addAttribute("userDetail", adminService.adminUserDetail(uId));
		System.out.println(adminService.adminUserDetail(uId) + "adminUserDetail 확인바람유!");
		
		return "/adminpage/userManagement/adminUserDetail";
	}
	
	
	/************************************************************************************************/
	
	
	/**
	 * 관리자페이지에서 회원등급 등록
	 * @return userLevelInsert페이지
	 * @author 한우리
	 */
	//회원등급등록화면
   @GetMapping("/admin/userLevelInsert") 
   public String userLevelInsert() {
	  System.out.println("userLevelInsert @GetMapping 회원등급등록화면  "); 
	  
	  return "/adminpage/userManagement/userLevelInsert";
   }

   //회원등급 등록화면
   @PostMapping("/admin/userLevelInsert")
   public String userLevelInsert(UserLevel userLevel , Model model) {
	   System.out.println("userLevelInsert @PostMapping 회원등급등록화면 ");	   
	   adminService.userLevelInsert(userLevel);
	   System.out.println(userLevel + "==> adminService.userLevelInsert(userLevel) 확인완료");
	
	   return "redirect:/admin/userLevelInsert";
   }
   
	/**
	 * 관리자페이지에서 회원 등급 리스트 
	 * @param model
	 * @return adUserLevelList페이지
	 * @author 한우리
	 */
	//관리자가 유저 회원 등급 리스트
	@GetMapping("/admin/adUserLevelList")
	public String adUserLevelList(Model model) {
		System.out.println(" adUserLevelList 전체회원리스트  @PostMapping");
		List<UserLevel> userLevel = adminService.adUserLevelList();
		System.out.println(userLevel + " <<== adminService.adUserLevelList()");
		model.addAttribute("userLevel",userLevel);
		
	
		return "/adminpage/userManagement/adUserLevelList";
	}
	
	
   /************************************************************************************************/
   
   
   /**
	 * 관리자페이지에서 회원권한등록
	 * @return adUserAuthorityInsert페이지
	 * @author 한우리
	 */
   //회원 권한 등록 화면
   @GetMapping("/admin/adUserAuthorityInsert")
   public String adUserAuthorityInsert() {
	   System.out.println("adUserAuthorityInsert @GetMapping 회원권한등록화면 "); 
	   
	  return "/adminpage/userManagement/adUserAuthorityInsert";
   }
   
   /**
	 * 관리자페이지에서 회원권한등록
	 * @param userAuthoritySet
	 * @param model
	 * @return adUserAuthorityInsert페이지
	 * @author 한우리
	 */
   @PostMapping("/admin/adUserAuthorityInsert")
   public String adUserAuthorityInsert(UserAuthoritySet userAuthoritySet, Model model ) {
	   System.out.println("adUserAuthorityInsert @PostMapping 회원권한등록화면 "); 
	   adminService.adUserAuthorityInsert(userAuthoritySet);
	   System.out.println(userAuthoritySet + "==> adminService.userLevelInsert(userLevel) 확인완료");
	  
	  return "redirect:/admin/adUserAuthorityInsert"; 
   }
   

   /************************************************************************************************/
   
   
   /**
	 * 관리자페이지에서 사서 전체리스트
	 * @param model
	 * @return librarianSearchList페이지
	 * @author 한우리
	 */
   	//사서 전체 리스트
	@GetMapping("/admin/librarianSearchList")
	public String librarianSearchList(Model model) { 
		 System.out.println("librarianSearchList 전체사서리스트 ");
	 
	  return "/adminpage/librarian/librarianSearchList"; 
	 }
	 
   /**
	 * 관리자페이지에서 사서등록
	 * @return librarianInsert페이지
	 * @author 한우리
	 */
	//사서 등록 
	@GetMapping("/admin/librarianInsert") 
    public String librarianInsert() {
      System.out.println("librarianInsert 사서등록 "); 
      
      return "/adminpage/librarian/librarianInsert";
     }

   /**
	 * 관리자페이지에서 사서등록
	 * @param librarianLevel
	 * @param model
	 * @return librarianInsert페이지
	 * @author 한우리
	 */
	//사서 등록
	@PostMapping("/admin/librarianInsert")
    public String librarianInsert(LibrarianLevel librarianLevel, Model model) {
	   System.out.println(librarianLevel + " ==> librarianInsert librarianLevel");
	   
	   return "redirect:/admin/librarianInsert";
   } 
	
		
	
}
