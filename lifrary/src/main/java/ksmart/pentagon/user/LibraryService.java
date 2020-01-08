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
	public int userInsert1(User user) {
		System.out.println("userInsert1 서비스진입");
		
		return libraryMapper.userInsert1(user);
	}
	public int userInsert2(UserLevelHistory userLevelHistory) {
		System.out.println("userInsert2 서비스진입");
		
		return libraryMapper.userInsert2(userLevelHistory);
	}
	public int userInsert3(UserAuthorityHistory userAuthorityHistory) {
		System.out.println("userInsert3 서비스진입");
		
		return libraryMapper.userInsert3(userAuthorityHistory);
	}
	public int userInsert4(StudyCate studyCate) {
		System.out.println("userInsert4 서비스진입");
		
		return libraryMapper.userInsert4(studyCate);
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
	
	//회원 탈퇴 페이지

}
