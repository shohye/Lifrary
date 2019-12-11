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

/*
 * @file   AdminController.java //파일
 * @name   admin controller //이름
 * @brief  관리자페이지 회원관리  //기능
 * @author 한우리 //작성자
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
	
	//전체회원리스트
	@GetMapping("/userSearchList")
	public String userSearchList(Model model) {
		System.out.println("userSearchList 전체회원리스트  @GetMapping ");
		
		List<User> uList = adminService.getUserList();
		System.out.println(uList + " <<== adminService.getUserList() ");
		model.addAttribute("uList",uList);
		
		return "/adminPage/userManagement/userSearchList";
	}
	
	//전체회원리스트
	@PostMapping("/getUserSearch")
	public String getUserSearch(Model model) {
		System.out.println(" getUserSearch 전체회원리스트  @PostMapping");
		model.addAttribute("uList", adminService.getUserSearch());
	
		return "/adminPage/userManagement/userSearchList";
	}
	
   //회원수정처리
	@GetMapping("/adminUserUpdate") 
	public String getAdminUserUpdate(@RequestParam(value = "uId") String uId, Model model) {
		System.out.println("getAdminUserUpdate @GetMapping 회원수정 처리 (Id로 업데이트)"); 
		model.addAttribute("uUpdate", adminService.getAdminUserUpdate(uId));
		
		return "/adminPage/userManagement/adminUserUpdate"; 
	}
	
	//회원수정화면
	@PostMapping("/adminUserUpdate")
	public String adminUserUpdate(User user) {
		System.out.println("adminUserUpdate @PostMapping 회원수정 화면 ");
		System.out.println(user.toString() + "<==== user ");
		adminService.adminUserUpdate(user);
		
		return "redirect:/userSearchList";
	}
		
	//회원등급등록화면
   @GetMapping("/userLevelInsert") 
   public String userAuthorityInsert() {
	  System.out.println("userLevelInsert 회원등급등록화면 "); 
	  
	  return "/adminPage/userManagement/userLevelInsert";
	  }

   	//사서 전체 리스트
	@GetMapping("/librarianSearchList")
	public String librarianSearchList(Model model) { 
		 System.out.println("librarianSearchList 전체사서리스트 ");
	 
	  return "/adminPage/librarian/librarianSearchList"; }
	 
	//사서 등록 
	@GetMapping("/librarianInsert") 
    public String librarianInsert() {
      System.out.println("librarianInsert 사서등록 "); 
      return "/adminPage/librarian/librarianInsert";
     }
   
	//사서 등록
	@PostMapping("/librarianInsert")
    public String librarianInsert(LibrarianLevel librarianLevel, Model model) {
	   System.out.println(librarianLevel + " ==> librarianInsert librarianLevel");
	   
	   return "redirect:/adminPage/librarian/librarianInsert";
   } 
	
}
