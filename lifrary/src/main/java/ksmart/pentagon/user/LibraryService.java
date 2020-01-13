package ksmart.pentagon.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.StudyCate;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserLevelHistory;

/*
 * @file   LibraryService.java 
 * @name   library service 
 * @brief  도서관 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class LibraryService {
	@Autowired
	private LibraryMapper libraryMapper;

	public Map<String,Object> loginCheck(String uId, String uPw, String libNum) {

		User user = libraryMapper.loginCheck(uId, libNum); // DB에서 uId인 user의 uPw
		String result = null;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		if(user != null) {//아이디 있음 
			if(uPw.equals(user.getuPw())) { //비밀번호 일치
				result = "로그인 성공";
				resultMap.put("user", user);
			} else { // 비밀번호 불일치
				result = "비밀번호 불일치";
			}
		}else {//아이디 없음
			result = "아이디 없음";
		}
		resultMap.put("result", result);
		
	return resultMap;

	}

	
	/*****************************************************************/
	
	//회원가입
	public int userInsertUser(User user) {
		System.out.println("userInsertUser 서비스진입");
		
		return libraryMapper.userInsertUser(user);
	}
	public int userInsertUserLevelHistory(UserLevelHistory userLevelHistory) {
		System.out.println("userInsertUserLevelHistory 서비스진입");
		
		return libraryMapper.userInsertUserLevelHistory(userLevelHistory);
	}
	public int userInsertUserAuthorityHistory(UserAuthorityHistory userAuthorityHistory) {
		System.out.println("userInsertUserAuthorityHistory 서비스진입");
		
		return libraryMapper.userInsertUserAuthorityHistory(userAuthorityHistory);
	}
	public int userInsertStudyCate(StudyCate studyCate) {
		System.out.println("userInsertStudyCate 서비스진입");
		
		return libraryMapper.userInsertStudyCate(studyCate);
	}
	
	//회원 마이페이지 - 내정보 상세보기
	public User myUserDetail(String getSID ,String libNum) {
		System.out.println("myUserDetail 서비스진입");
		return libraryMapper.myUserDetail(getSID, libNum);
	}
	
	//사서 - 사서 내 정보 수정하기.
	public User getMyUserUpdate(String getSID ,String libNum) {
		System.out.println("getMyUserUpdate 서비스진입");
		return libraryMapper.getMyUserUpdate(getSID, libNum);
	}
	public int myUserUpdate(User user) {
		System.out.println("myUserUpdate 서비스진입");
		return libraryMapper.myUserUpdate(user);
	}
	

	
	//회원 탈퇴 AJAX
	public String deleteUser(String SID, String uPw, String libNum) {
		System.out.println("deleteUser 서비스진입");
		
		User u = libraryMapper.deleteUserCheck(SID, uPw, libNum);
		String result = "";
		System.out.println("user 확인 >>"+u);
		if(u == null) { // 일치하지 않음
			result = "불일치";
		}else { // 일치함
			libraryMapper.deleteUser(SID);	//삭제 
			result = "삭제";
		}
		return result;
	}
}
