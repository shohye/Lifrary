package ksmart.pentagon.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.User;

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

}
