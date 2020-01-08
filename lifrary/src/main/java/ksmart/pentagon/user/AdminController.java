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

	@Autowired private AdminService adminService;
	
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
		System.out.println(session.getAttribute("LIBNUM")+" <== 도서관 코드");
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
		session.setAttribute("LIBNUM", user.getlCode());
		session.setAttribute("SADIV",user.getuDivision()); // 사서 / 관리자 구분
		session.setAttribute("SANAME",user.getuName()); // 이름
		session.setAttribute("SALI",user.getLibrarianLevel().getLlInsert()); // library insert - 사서 등록
		session.setAttribute("SALC",user.getLibrarianLevel().getLlCarry()); // library carry - 수서
		session.setAttribute("SALBA",user.getLibrarianLevel().getLlBookAdmin()); // library book admin - 대출, 반납, 예약
		session.setAttribute("SALS",user.getLibrarianLevel().getLlStats()); // library stats - 통계
		session.setAttribute("SALBS",user.getLibrarianLevel().getLlBookStock()); // library book stock - 장서 점검 
		System.out.println(result + " < == result");
		System.out.println(user.getlCode());
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
	public String userSearchList(Model model, HttpSession session) {
		System.out.println("userSearchList 전체회원리스트  @GetMapping ");
		
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
		model.addAttribute("uList",adminService.getUserList(libNum));
		System.out.println("전체회원리스트 uList 확인바람 =>> "+ adminService.getUserList(libNum));
		
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
		System.out.println( "adminUserDetail 확인바람유!==> "+ adminService.adminUserDetail(uId));
		
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
   public String adUserLevelInsert(UserLevel userLevel , Model model, HttpSession session) {
	   System.out.println("adUserLevelInsert @PostMapping 회원등급등록화면 ");	  
	   
	   String getSAID = (String)session.getAttribute("SAID");
	   String libNum = (String)session.getAttribute("LIBNUM");
	   System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + getSAID );
	   System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
	   
		/*
		 * userLevel.setlCode(libNum); userLevel.setuId(getSAID);
		 * System.out.println("userLevel 확인 바람==>> " + userLevel);
		 */
	   
	   adminService.adUserLevelInsert(userLevel);
	   
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
	public String adUserLevelList(Model model, HttpSession session) {
		System.out.println(" adUserLevelList 전체회원리스트  @PostMapping");
		
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
		model.addAttribute("userLevel",adminService.adUserLevelList(libNum));
		System.out.println("관리자가 유저회원등급 리스트 userLevel 확인바람 =>> "+ adminService.adUserLevelList(libNum));
		
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
	public String getAdUserLevelUpdate(@RequestParam(value = "ulLevel",required=false)String ulLevel,
										HttpSession session ,Model model) {
		System.out.println("getAdUserLevelUpdate 회원등급 수정  @GetMapping");
		String getSAID = (String)session.getAttribute("getSAID");
		String libNum = (String) session.getAttribute("LIBNUM");	
		System.out.println("getSAID 세션에서가져온 아이디  >>>" + getSAID );
		System.out.println("LIBNUM 세션에서가져온 도서코드  >>>" + libNum );
		
		model.addAttribute("lUpdate", adminService.getAdUserLevelUpdate(ulLevel, getSAID));
		System.out.println("userLevel 확인바람  ==>>" + adminService.getAdUserLevelUpdate(ulLevel, getSAID));
		
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
	public String adUserLevelHistorySearchList(Model model, HttpSession session) {
		System.out.println("adUserLevelHistorySearchList 회원전체 등급내역 리스트 @GetMapping");
		
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
		model.addAttribute("levelHistory", adminService.adUserLevelHistorySearchList(libNum));
		System.out.println("회원등급내역리스트 levelHistory " + adminService.adUserLevelHistorySearchList(libNum));
		
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
   public String adUserAuthorityInsert(UserAuthoritySet userAuthoritySet, Model model, HttpSession session) {
	   System.out.println("adUserAuthorityInsert @PostMapping 회원권한등록화면 "); 
	   
	   String getSAID = (String)session.getAttribute("SAID");
	   String libNum = (String)session.getAttribute("LIBNUM");
	   System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + getSAID );
	   System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
	   
	   userAuthoritySet.setlCode(libNum);
	   userAuthoritySet.setuId(getSAID);
	   System.out.println("userAuthoritySet 확인바람 >>> " + userAuthoritySet);
	   adminService.adUserAuthorityInsert(userAuthoritySet);
	   System.out.println("회원권한등록화면  확인완료  ==>> ");
	  
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
   public String adUserAuthorityList(Model model, HttpSession session) {
	   System.out.println("adUserAuthorityList 회원권한 리스트화면 ");
	   
	   String libNum = (String)session.getAttribute("LIBNUM");
	   System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
	   
	   model.addAttribute("userAuthority", adminService.adUserAuthorityList(libNum));
	   System.out.println("회원권한 리스트 userAuthority 확인완료  ==>>" + adminService.adUserAuthorityList(libNum));
	  	  
	   return "/adminpage/userManagement/adUserAuthorityList";
   }
   
   //관리자가 회원권한 수정
   @GetMapping("/admin/adUserAuthorityUpdate")
   public String getAdUserAuthorityUpdate(@RequestParam(value = "uasCode",required=false) String uasCode,
		   										HttpSession session , Model model) {
	   System.out.println("getAdUserAuthorityUpdate 회원권한 수정화면 @GetMapping");
	   
	   String getSAID = (String)session.getAttribute("SAID");
	   System.out.println("SAID 세션에서가져온 관리자ID  >>>" + getSAID );
	   model.addAttribute("aUpdate", adminService.getAdUserAuthorityUpdate(uasCode, getSAID));
	   System.out.println("aUpdate 확인바람  ==>>" );
	
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
	public String adUserAuthorityHistorySearchList(Model model, HttpSession session) {
		System.out.println("adUserAuthorityHistorySearchList 회원전체 권한내역 리스트 @GetMapping");
		
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
		model.addAttribute("authorityHistory", adminService.adUserAuthorityHistorySearchList(libNum));
		System.out.println("회원권한내역리스트 authorityHistory " + adminService.adUserAuthorityHistorySearchList(libNum));
		
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
	 * @param model
	 * @return librarianLevelList페이지
	 * @author 한우리
	 */
   	//관리자가 보는 사서 전체 리스트
	@GetMapping("/admin/librarianLevelList")
	public String librarianLevelList1(Model model, HttpSession session) { 
		 System.out.println("librarianLevelList1 전체사서리스트 @GetMapping");
		 
		 String libNum = (String)session.getAttribute("LIBNUM");
		 System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
			
		 model.addAttribute("lList", adminService.librarianLevelList1(libNum));
		 System.out.println("관리자가 보는 전체사서리스트 lList ==>> " + adminService.librarianLevelList1(libNum));
		 
		 return "/adminpage/librarian/librarianLevelList"; 
	 }
	
	//관리자가 보는 사서 검색 전체 리스트2
	@PostMapping("/admin/librarianLevelList")
	public String librarianLevelList2(Model model, HttpSession session) {
		 System.out.println("librarianLevelList2 전체사서리스트 @PostMapping ");
		 
		 String libNum = (String)session.getAttribute("LIBNUM");
		 System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		 
		 model.addAttribute("lList", adminService.librarianLevelList2(libNum));
		 System.out.println("관리자가 보는 전체사서 검색리스트 lList ==>> " + adminService.librarianLevelList2(libNum));
		 
		return "/adminpage/librarian/librarianLevelList";
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
    public String librarianInsert(HttpSession session, User user, LibrarianLevel librarianLevel) {
		System.out.println("user 확인 ==>> " + user);
		System.out.println("librarianLevel 확인 ==>> " + librarianLevel);
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
	      user.setlCode(libNum);
	      librarianLevel.setlCode(libNum);
	      System.out.println("user 확인 2222==>> " + user);
		adminService.librarianInsert1(user);
		adminService.librarianInsert2(librarianLevel);

	   return "redirect:/admin/librarianLevelList";
   } 
	
	/**
	 * 관리자가 사서정보&권한 수정하기 
	 * @return librarianLevelUpdate폼
	 * @return librarianLevelList 리스트
	 * @author 한우리
	 */
	//관리자가 사서정보&권한 수정하기 >> 폼
	@GetMapping("/admin/librarianLevelUpdate")
	public String getLibrarianLevelUpdate(@RequestParam(value = "uId",required=false)String uId
										, HttpSession session, Model model) {
		System.out.println("getLibrarianLevelUpdate 관리자가 사서정보&권한 수정하기 @GetMapping");
		
		String libNum = (String) session.getAttribute("LIBNUM");
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		model.addAttribute("librarianLevelUpdate",adminService.getLibrarianLevelUpdate(uId, libNum));
		System.out.println("관리자가 사서 수정하는거 제발 확인 @!" + adminService.getLibrarianLevelUpdate(uId, libNum));
		
		return "/adminpage/librarian/librarianLevelUpdate";
	}
	
	//관리자가 사서정보&권한 수정후 리스트로 보내기 
	@PostMapping("/admin/librarianLevelUpdate")
	public String librarianLevelUpdate(User user, LibrarianLevel librarianLevel) {
		System.out.println("librarianLevelUpdate 관리자가 사서정보&권한 수정하기 @PostMapping");
		System.out.println("user 확인 librarianLevelUpdate ==>> " + user);
		System.out.println("librarianLevel 확인 librarianLevelUpdate ==>> " + librarianLevel);
		
		adminService.librarianLevelUpdate1(user);
		adminService.librarianLevelUpdate2(librarianLevel);
		System.out.println("user 확인 librarianLevelUpdate1 ==>> " + user);
		System.out.println("librarianLevel 확인 librarianLevelUpdate2 ==>> " + librarianLevel);
		
		return "redirect:/admin/librarianLevelList";
		
	}
	
	
	  //사서 상세보기 폼
	  
	 @GetMapping("/admin/librarianDetail") 
	 public String librarianDetail(Model model, @RequestParam(value="uId",required=false) String uId) {
		 System.out.println("librarianDetail 회원상세보기 화면 ");
	  
		 model.addAttribute("librarianDetail", adminService.librarianDetail(uId));
		 System.out.println("librarianDetail 확인바람유! >>> " + adminService.librarianDetail(uId));
	  
		 return "/adminpage/librarian/librarianDetail"; 
	}
	 
	
	
	
	/*****************************************************************************
	 * 사서 마이페이지 @@@@@
	 * ****************************************************************************/
	
   /**
	 * 사서 자신 정보 수정폼
	 * @param model
	 * @return librarianMyUpdate페이지
	 * @author 한우리
	 */
   	//사서 자신 정보 수정폼
	@GetMapping("/admin/librarianMyUpdate") 
    public String getLibrarianMyUpdate(Model model, HttpSession session) {
	   System.out.println("getLibrarianMyUpdate 나 사서! 내정보 수정 하는 폼 ");
	   
	   String getSAID = (String) session.getAttribute("SAID");	//세션에서 사서ID
	   String libNum = (String) session.getAttribute("LIBNUM");
		System.out.println("getSAID 세션에서가져온 아이디  >>>" + getSAID ); 
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
	   
	   model.addAttribute("librarianMyUpdate", adminService.getLibrarianMyUpdate(getSAID, libNum));
	   System.out.println("librarianMyUpdate 값 넘어오는지 확인바람");
	   
	   return "/adminpage/librarian/librarianMyUpdate"; 
	}
	
	//사서 자신 정보 수정 //제출하다
	@PostMapping("/admin/librarianMyUpdate")
	public String librarianMyUpdate(User user) {
		System.out.println("librarianMyUpdate 나 사서! 내정보 수정 후 상세보기로  ");
		
		adminService.librarianMyUpdate(user);
		return "redirect:/admin/librarianMyDetail";
	}
	
	
	//사서 자신 정보 상세보기 
	@GetMapping("/admin/librarianMyDetail")
	public String librarianMyDetail(Model model, HttpSession session) {
		System.out.println("librarianMyDetail 나 사서! 내정보  상세보기 ");
		
		String getSAID = (String) session.getAttribute("SAID");	//세션에서 사서ID
		String libNum = (String) session.getAttribute("LIBNUM");
		System.out.println("getSAID 세션에서가져온 아이디  >>>" + getSAID ); 
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );

		model.addAttribute("librarianMyDetail", adminService.librarianMyDetail(getSAID, libNum));
		System.out.println("librarianMyDetail 값 넘어오는지 확인바람"+ adminService.librarianMyDetail(getSAID, libNum));
		
		return "/adminpage/librarian/librarianMyDetail";
		
	}
	
/*******************************************************************************************/
	
	
	
    // userSearchList 삭제 결과값 가져오는 ajax - 회원 삭제
	//컨트롤러를 통해 보내고있는 응답의 유형을 나타 내기 위해 produce를 사용
    @RequestMapping(value="/deleteUser", produces = "text/plain")
    public @ResponseBody String deleteUser( Model model 
    		, @RequestParam(value="said",required=false)String said
    		, @RequestParam(value="write",required=false)String write
    		, @RequestParam(value="uId",required=false)String uId) {
		System.out.println("deleteUser 관리자가 회원 삭제하기 ");

    	int result = adminService.deleteUser(said, write, uId);
    	String text ="";
    	if(result == 0) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 1) {
			text = "회원 삭제가 완료되었습니다";
		}				
 		return text;
    }
    
    // adUserLevelList 삭제 결과값 가져오는 ajax - 회원등급 삭제
    @RequestMapping(value="/deleteLevel", produces = "text/plain")
    public @ResponseBody String deleteLevel( Model model 
    		, @RequestParam(value="said",required=false)String said
    		, @RequestParam(value="write",required=false)String write
    		, @RequestParam(value="ulLevel",required=false)String ulLevel) {
    	System.out.println("deleteLevel 관리자가 회원 등급 삭제하기 ");
    	
    	int result = adminService.deleteLevel(said, write, ulLevel);
    	String text ="";
    	if(result == 0) {
    		text = "비밀번호가 틀렸습니다";
    	}else if(result == 1) {
    		text = "등급 삭제가 완료되었습니다";
    	}				
    	return text;
    }
	
}
