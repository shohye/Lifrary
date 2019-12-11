package ksmart.pentagon.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
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
	
	//유저 레벨 전체 가져오기.
	public List<UserLevel> getUserLevel(){
		System.out.println("@@@@@@@@@@@@@@@@@서비스 진입@@@@@@@@@@@@@@@@@@");
		System.out.println(adminMapper.getUserLevel());
		
		return adminMapper.getUserLevel();
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
	
	//관리자가 사서 등록하기 
	public int librarianInsert(LibrarianLevel librarianLevel) {
		System.out.println("librarianInsert 서비스진입");
		int result = adminMapper.librarianInsert(librarianLevel);
		System.out.println(result + "==> libraryMapper.librarianInsert(librarianLevel) ");
			
		return result;
	} 
}
