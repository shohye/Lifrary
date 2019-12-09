package ksmart.pentagon.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
	@Autowired private LibraryMapper libraryMapper;
	
	public void loginCheck(String uId, String uPw) {
		
		Map<String, String> result = libraryMapper.loginCheck(uId); // DB에서 uId인 user의  uPw
		System.out.println(result.get("uPw") + " <== service uPw");
		System.out.println(result.get("uDivision") + " <== service uDivision");
		
		String dbPw = result.get("uPw");
		String dbDivision = result.get("uDivision");
		
		/*
		 * if(uPw == dbPw) { session.setAttribute("SID", uId);
		 * session.setAttribute("SDIV", dbDivision); } else {
		 * 
		 * }
		 */
	}
	
}
