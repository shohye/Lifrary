package ksmart.pentagon.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;
import ksmart.pentagon.vo.UserLevelHistory;

/*
 * @file   AdminService.java 
 * @name   admin service
 * @brief  공공시설 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	
	//사서 채널 로그인 처리 / 회원 정보 유무 확인후 로그인
	public Map<String,Object> adminLoginCheck(String uId, String uPw) {
		
		User user = adminMapper.adminLoginCheck(uId);
		String result = null;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		
		if(user != null) {
			if(uPw.equals(user.getuPw())) { // 비밀번호 일치
				result = "로그인 성공";
				resultMap.put("user", user);
			} else {
				result = "비밀번호 불일치";
			}
			
		} else {
			result = "아이디 없음";
		}
		resultMap.put("result", result);
		System.out.println(result + " <== service result");
		return resultMap;
	}
	
	
	//유저 회원 전체 가져오기 
	public List<User> getUserList(){
		System.out.println("getUserList 서비스진입");
		System.out.println(adminMapper.getUserList());
		
		return adminMapper.getUserList();
	}
	
	//유저 회원 리스트 검색 가져오기
	public List<User> getUserSearch(){
		System.out.println("getUserSearch 서비스진입");
		System.out.println(adminMapper.getUserSearch());
		
		return adminMapper.getUserSearch();
	}
	
	//유저 회원 수정 처리 
	public int adminUserUpdate(User user) {
		System.out.println("adminUserUpdate 서비스진입");
		System.out.println("유저 회원 수정처리 =>> "+ adminMapper.adminUserUpdate(user));
		return adminMapper.adminUserUpdate(user);
	}
	
	//유저 회원 수정 화면 불러오기
	public User getAdminUserUpdate(String uId) {
		System.out.println("adminUserUpdateId 서비스진입");
		
		return adminMapper.getAdminUserUpdate(uId);
	}
	
	//유저 회원 상세보기
	 public User adminUserDetail(String uId) {
		 System.out.println("adminUserDetail 서비스진입");
		 
		 return adminMapper.adminUserDetail(uId);
	 }
	
	 
	 /**************************************************************/
	 
	 
	 //관리자가 회원 등급 등록하기
	 public int adUserLevelInsert(UserLevel userLevel) {
		System.out.println("adUserLevelInsert 서비스진입");
		int result = adminMapper.adUserLevelInsert(userLevel);
		System.out.println("adminMapper.adUserLevelInsert(userLevel) 확인완료 ==>> " + result);
		
		 return result; 
	 }
	 
	 //유저 레벨 전체 가져오기.
	 public List<UserLevel> adUserLevelList(){
		 System.out.println("adUserLevelList 서비스 진입");
		 System.out.println(adminMapper.adUserLevelList());
		 
		 return adminMapper.adUserLevelList();
	 }
	 
	 //관리자가 유저 레벨 수정 하기
	 public UserLevel getAdUserLevelUpdate(String ulLevel) {
		 System.out.println("getAdUserLevelUpdate 서비스 진입");
		
		 return adminMapper.getAdUserLevelUpdate(ulLevel);
	 }
	 
	 //관리자가 회원 등급 수정하고 리스트로넘기기
	 public int adUserLevelUpdate(UserLevel userLevel) {
		 System.out.println("adUserLevelUpdate 서비스 진입");
		 
		 return adminMapper.adUserLevelUpdate(userLevel); 
	 }
	 
	 //유저 회원등급 내역 리스트 전체 가져오기 
	 public List<UserLevelHistory> adUserLevelHistorySearchList(){
		 System.out.println("adUserLevelHistorySearchList 서비스진입");
		 System.out.println(adminMapper.adUserLevelHistorySearchList());
		
		 return adminMapper.adUserLevelHistorySearchList();
	}
	
	//유저 회원등급 내역 검색 리스트 전체 가져오기
	 public List<UserLevelHistory> adUserLevelHistorySearch(){
		 System.out.println("adUserLevelHistorySearch 서비스진입");
		 System.out.println(adminMapper.adUserLevelHistorySearch());
		
		 return adminMapper.adUserLevelHistorySearch();
	}
	 
	 
	 /**************************************************************/
	 
	 
	 //관리자가 회원 권한 등록하기
	 public int adUserAuthorityInsert(UserAuthoritySet userAuthoritySet) {
		 System.out.println("adUserAuthorityInsert 서비스진입");
		 int result = adminMapper.adUserAuthorityInsert(userAuthoritySet);
		 System.out.println("adminMapper.adUserAuthorityInsert(userAuthoritySet) 확인완료 ==>> " + result);
		 
		 return result;
	 }
	 
	 //관리자가 회원 권한 리스트보기
	 public List<UserAuthoritySet> adUserAuthorityList(){
		 System.out.println("adUserAuthorityList 서비스 진입");
		 System.out.println("확인완료 adUserAuthorityList ==>>" + adminMapper.adUserAuthorityList());
		
		 return adminMapper.adUserAuthorityList();
	 }
	 
	 //관리자가 회원 권한 수정하기
	 public UserAuthoritySet getAdUserAuthorityUpdate(String uasCode) {
		 System.out.println("getAdUserAuthorityUpdate 서비스 진입");
		 System.out.println("확인완료 getAdUserAuthorityUpdate ==>>" + adminMapper.getAdUserAuthorityUpdate(uasCode));
		 
		 return adminMapper.getAdUserAuthorityUpdate(uasCode); 
	 }
	 
	 //관리자가 회원 권한 수정하고 리스트로넘기기
	 public int adUserAuthorityUpdate(UserAuthoritySet userAuthoritySet) {
		 System.out.println("adUserAuthorityUpdate 서비스 진입");
		 
		 return adminMapper.adUserAuthorityUpdate(userAuthoritySet);
	 }
	 
	 //유저 권한등급 내역 리스트 전체 가져오기 
	 public List<UserAuthorityHistory> adUserAuthorityHistorySearchList(){
		 System.out.println("adUserAuthorityHistorySearchList 서비스진입");
		 System.out.println(adminMapper.adUserAuthorityHistorySearchList());
		
		 return adminMapper.adUserAuthorityHistorySearchList();
	}
	
	//유저 권한등급 내역 검색 리스트 전체 가져오기
	 public List<UserAuthorityHistory> adUserAuthorityHistorySearch(){
		 System.out.println("adUserAuthorityHistorySearch 서비스진입");
		 System.out.println(adminMapper.adUserAuthorityHistorySearch());
		
		 return adminMapper.adUserAuthorityHistorySearch();
	}
	 
	 
	 
	 /**********************************************************************************/
	 
	 
	 
	//관리자가 사서 등록하기 
	public int librarianInsert1(User user) {
		System.out.println("librarianInsert1 서비스진입");
		return adminMapper.librarianInsert1(user);
	}
	public int librarianInsert2(LibrarianLevel librarianLevel) {
		System.out.println("librarianInsert2 서비스진입");
		return adminMapper.librarianInsert2(librarianLevel);
	}
	
	//관리자 - 사서 리스트 
	public List<User> librarianLevelList1(){
		System.out.println("librarianLevelList1 서비스진입");
		
		return adminMapper.librarianLevelList1();
	}
	public List<User> librarianLevelList2(){
		System.out.println("librarianLevelList2 서비스진입");
		
		return adminMapper.librarianLevelList2();
	}
	
}
