package ksmart.pentagon.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;

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
	 public int userLevelInsert(UserLevel userLevel) {
		System.out.println("userAuthorityInsert 서비스진입");
		int result = adminMapper.userLevelInsert(userLevel);
		System.out.println(result + "==> adminMapper.userLevelInsert(userLevel) 확인완료");
		
		 return result; 
	 }
	 
	 //유저 레벨 전체 가져오기.
	 public List<UserLevel> adUserLevelList(){
		 System.out.println("adUserLevelList 서비스 진입");
		 System.out.println(adminMapper.adUserLevelList());
		 
		 return adminMapper.adUserLevelList();
	 }
	 
	 //유저 레벨 수정 폼 가져오기
	 public UserLevel getAdUserLevelUpdate(String ulLevel) {
		 System.out.println("getAdUserLevelUpdate 서비스 진입");
		
		 return adminMapper.getAdUserLevelUpdate(ulLevel);
	 }
	 
	 public int adUserLevelUpdate(UserLevel userLevel) {
		 System.out.println("adUserLevelUpdate 서비스 진입");
		 
		 return adminMapper.adUserLevelUpdate(userLevel); 
	 }
	 
	 
	 /**************************************************************/
	 
	 
	 //관리자가 회원 권한 등록하기
	 public int adUserAuthorityInsert(UserAuthoritySet userAuthoritySet) {
		 System.out.println("adUserAuthorityInsert 서비스진입");
		 int result = adminMapper.adUserAuthorityInsert(userAuthoritySet);
		 System.out.println(result + "==> adminMapper.adUserAuthorityInsert(userAuthoritySet) 확인완료");
		 
		 return result;
	 }
	 
	 
	//관리자가 사서 등록하기 
	public int librarianInsert(LibrarianLevel librarianLevel) {
		System.out.println("librarianInsert 서비스진입");
		int result = adminMapper.librarianInsert(librarianLevel);
		System.out.println(result + "==> libraryMapper.librarianInsert(librarianLevel)확인완료");
			
		return result;
	} 
}
