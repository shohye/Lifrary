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
import org.springframework.web.bind.annotation.RequestParam;

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
			System.out.println("(도서관)세션값이 없습니다.");
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
		
		return "redirect:/admin/login";
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
		System.out.println(user.toString() + "<==== user확인바람 ");
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
   @GetMapping("/admin/adUserLevelInsert") 
   public String adUserLevelInsert() {
	  System.out.println("adUserLevelInsert @GetMapping 회원등급등록화면  "); 
	  
	  return "/adminpage/userManagement/adUserLevelInsert";
   }

   //회원등급 등록화면
   @PostMapping("/admin/adUserLevelInsert")
   public String adUserLevelInsert(UserLevel userLevel , Model model) {
	   System.out.println("adUserLevelInsert @PostMapping 회원등급등록화면 ");	   
	   adminService.adUserLevelInsert(userLevel);
	   System.out.println(userLevel + "==> adminService.adUserLevelInsert(userLevel) 확인완료");
	
	   return "redirect:/admin/adUserLevelList";
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
	
	/**
	 * 관리자페이지에서 회원 등급 수정
	 * @param model
	 * @param ulLevel
	 * @return adUserLevelUpdate페이지
	 * @author 한우리
	 */
	//관리자가 유저 회원 등급 수정 
	@GetMapping("/admin/adUserLevelUpdate")
	public String getAdUserLevelUpdate(@RequestParam(value = "ulLevel",required=false)String ulLevel, Model model) {
		System.out.println(" getAdUserLevelUpdate 회원등급 수정  @GetMapping");
		model.addAttribute("lUpdate", adminService.getAdUserLevelUpdate(ulLevel));
		System.out.println("userLevel 확인바람  ==>>" + adminService.getAdUserLevelUpdate(ulLevel));
		
		return "/adminpage/userManagement/adUserLevelUpdate";
	}
	
	//관리자가 유저 회원 등급 수정후 리스트로 보냄 
	@PostMapping("/admin/adUserLevelUpdate")
	public String adUserLevelUpdate(UserLevel userLevel) {
		System.out.println("adUserLevelUpdate 회원등급 수정  @PostMapping");
		System.out.println(" 회원등급수정 userLevel.toString()  ==>> " + userLevel.toString());
		adminService.adUserLevelUpdate(userLevel);
		
		return "redirect:/admin/adUserLevelList";
	}
	
	/**
	 * @관리자 유저 회원 등급 내역 검색리스트
	 * @param model
	 * @return adUserLevelHistorySearchList페이지
	 * @author 한우리
	 */
	//관리자 유저 회원 등급 내역 검색리스트 
	@GetMapping("/admin/adUserLevelHistorySearchList")
	public String adUserLevelHistorySearchList(Model model) {
		System.out.println("adUserLevelHistorySearchList 회원전체 등급내역 리스트 @GetMapping");
		List<UserLevelHistory> levelHistory = adminService.adUserLevelHistorySearchList();
		System.out.println("회원등급내역리스트 levelHistory " + adminService.adUserLevelHistorySearchList());
		model.addAttribute("levelHistory", levelHistory);
		
		return "/adminpage/userManagement/adUserLevelHistorySearchList";
	}
	
	@PostMapping("/admin/adUserLevelHistorySearchList")
	public String adUserLevelHistorySearch(Model model) {
		System.out.println("adUserLevelHistorySearch 회원전체 등급내역 검색리스트 @PostMapping");
		model.addAttribute("levelHistory", adminService.adUserLevelHistorySearch());
		
		return "/adminpage/userManagement/adUserLevelHistorySearchList";
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
	   System.out.println("회원권한등록화면  확인완료  ==>> " + adminService.adUserAuthorityInsert(userAuthoritySet));
	  
	  return "redirect:/admin/adUserAuthorityList"; 
   }
   
   /**
    * 관리자페이지에서 회원권한 리스트화면
    * @param userAuthoritySet
    * @return adUserAuthorityLis페이지
    * @author 한우리
    */
   //관리자가 회원권한 리스트 
   @GetMapping("/admin/adUserAuthorityList")
   public String adUserAuthorityList(Model model) {
	   System.out.println("adUserAuthorityList 회원권한 리스트화면 ");
	   List<UserAuthoritySet> userAuthority = adminService.adUserAuthorityList();
	   System.out.println("회원권한 리스트 userAuthority 확인완료  ==>>" + userAuthority);
	   model.addAttribute("userAuthority", userAuthority);
	  	  
	   return "/adminpage/userManagement/adUserAuthorityList";
   }
   
   //관리자가 회원권한 수정
   @GetMapping("/admin/adUserAuthorityUpdate")
   public String getAdUserAuthorityUpdate(@RequestParam(value = "uasCode",required=false) String uasCode, Model model) {
	   System.out.println("getAdUserAuthorityUpdate 회원권한 수정화면 @GetMapping");
	   model.addAttribute("aUpdate", adminService.getAdUserAuthorityUpdate(uasCode));
	   System.out.println("aUpdate 확인바람  ==>>" + adminService.getAdUserAuthorityUpdate(uasCode));
	
	   return "/adminpage/userManagement/adUserAuthorityUpdate";
   }
   
   //관리자가 회원권한 수정 후 리스트로 보냄
   @PostMapping("/admin/adUserAuthorityUpdate")
   public String adUserAuthorityUpdate(UserAuthoritySet userAuthoritySet) {
	   System.out.println("adUserAuthorityUpdate 회원권한 수정화면 @PostMapping");
	   System.out.println(" 회원권한수정 userAuthoritySet.toString()  ==>> " + userAuthoritySet.toString());
	   adminService.adUserAuthorityUpdate(userAuthoritySet);
	
	   return "redirect:/admin/adUserAuthorityList";  
   }
   

	/**
	 * @관리자 유저 회원 권한 내역 검색리스트
	 * @param model
	 * @return adUserAuthorityHistorySearchList페이지
	 * @author 한우리
	 */
	//관리자 유저 회원 등급 내역 검색리스트 
	@GetMapping("/admin/adUserAuthorityHistorySearchList")
	public String adUserAuthorityHistorySearchList(Model model) {
		System.out.println("adUserAuthorityHistorySearchList 회원전체 권한내역 리스트 @GetMapping");
		List<UserAuthorityHistory> authorityHistory = adminService.adUserAuthorityHistorySearchList();
		System.out.println("회원권한내역리스트 authorityHistory " + adminService.adUserAuthorityHistorySearchList());
		model.addAttribute("authorityHistory", authorityHistory);
		
		return "/adminpage/userManagement/adUserAuthorityHistorySearchList";
	}
	
	@PostMapping("/admin/adUserAuthorityHistorySearchList")
	public String adUserAuthorityHistorySearch(Model model) {
		System.out.println("adUserAuthorityHistorySearch 회원전체 권한내역 검색리스트 @PostMapping");
		model.addAttribute("authorityHistory", adminService.adUserAuthorityHistorySearch());
		
		return "/adminpage/userManagement/adUserAuthorityHistorySearchList";
	}

	
	
   /************************************************************************************************/
   
   
   /**
	 * 관리자페이지에서 사서 전체리스트
	 * @param modelㅊ
	 * @return librarianSearchList페이지
	 * @author 한우리
	 */
   	//사서 전체 리스트
	@GetMapping("/admin/librarianSearchList")
	public String librarianSearchList(Model model) { 
		 System.out.println("librarianSearchList 전체사서리스트 @GetMapping");
		 List<User> lList = adminService.librarianSearchList();
		 System.out.println("회원권한내역리스트 lList " + lList);
		 model.addAttribute("lList", lList);
		 
	  return "/adminpage/librarian/librarianSearchList"; 
	 }
	
	@PostMapping("/admin/librarianSearchList")
	public String librarianSearch(Model model) {
		 System.out.println("librarianSearchList 전체사서리스트 @PostMapping ");
		 model.addAttribute("lList", adminService.librarianSearch());
		 
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

	//사서 등록
	@PostMapping("/admin/librarianInsert")
    public String librarianInsert(User user, LibrarianLevel librarianLevel, Model model) {
		System.out.println("user 확인 ==>> " + user);
		System.out.println("librarianLevel 확인 ==>> " + librarianLevel);
		
		adminService.librarianInsert1(user);
		adminService.librarianInsert2(librarianLevel);

	   return "redirect:/admin/librarianSearchList";
   } 
	
	
	
	
	/*****************************************************************************
	 * 사서 권한 리스트 /수정
	 * ****************************************************************************/
	
	
   /**
	 * 관리자페이지에서 사서 권한리스트
	 * @param model
	 * @return librarianLevelList페이지
	 * @author 한우리
	 */
   	//사서 권한 리스트
	
    @GetMapping("/admin/librarianLevelList") 
    public String librarianLevelList(Model model) {
	   System.out.println("librarianLevelList 사서 권한 리스트 ");
	  
	   return "/adminpage/librarian/librarianLevelList"; 
	  
	}
	
	
	
	
	
	
}
