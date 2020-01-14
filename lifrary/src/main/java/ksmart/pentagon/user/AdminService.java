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
	@Autowired
	private AdminMapper adminMapper;

	// 사서 채널 로그인 처리 / 회원 정보 유무 확인후 로그인
	public Map<String, Object> adminLoginCheck(String uId, String uPw) {

		User user = adminMapper.adminLoginCheck(uId);
		String result = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (user != null) {
			if (uPw.equals(user.getuPw())) { // 비밀번호 일치
				result = "로그인 성공";
				resultMap.put("user", user);
			} else {
				result = "비밀번호 불일치";
			}

		} else {
			result = "아이디 없음";
		}
		resultMap.put("result", result);
		return resultMap;
	}

	// 유저 회원 전체 가져오기
	public List<User> getUserList(String libNum) {

		return adminMapper.getUserList(libNum);
	}

	// 유저 회원 리스트 검색 가져오기
	public List<User> getUserSearch() {

		return adminMapper.getUserSearch();
	}

	// 유저 회원 수정 처리
	public int adminUserUpdate(User user) {
		return adminMapper.adminUserUpdate(user);
	}

	// 유저 회원 수정 화면 불러오기
	public User getAdminUserUpdate(String uId) {

		return adminMapper.getAdminUserUpdate(uId);
	}

	// 유저 회원 상세보기
	public User adminUserDetail(String uId) {

		return adminMapper.adminUserDetail(uId);
	}

	/**************************************************************/

	// 관리자가 회원 등급 등록하기
	public int adUserLevelInsert(UserLevel userLevel) {
		int result = adminMapper.adUserLevelInsert(userLevel);

		return result;
	}

	// 유저 레벨 전체 가져오기.
	public List<UserLevel> adUserLevelList(String libNum) {

		return adminMapper.adUserLevelList(libNum);
	}

	// 관리자가 유저 레벨 수정 하기
	public UserLevel getAdUserLevelUpdate(String ulLevel, String getSAID) {
		return adminMapper.getAdUserLevelUpdate(ulLevel, getSAID);
	}

	// 관리자가 회원 등급 수정하고 리스트로넘기기
	public int adUserLevelUpdate(UserLevel userLevel) {

		return adminMapper.adUserLevelUpdate(userLevel);
	}

	// 유저 회원등급 내역 리스트 전체 가져오기
	public List<UserLevelHistory> adUserLevelHistorySearchList(String libNum) {

		return adminMapper.adUserLevelHistorySearchList(libNum);
	}

	// 유저 회원등급 내역 검색 리스트 전체 가져오기
	public List<UserLevelHistory> adUserLevelHistorySearch() {

		return adminMapper.adUserLevelHistorySearch();
	}

	/**************************************************************/

	// 관리자가 회원 권한 등록하기
	public int adUserAuthorityInsert(UserAuthoritySet userAuthoritySet) {
		int result = adminMapper.adUserAuthorityInsert(userAuthoritySet);

		return result;
	}

	// 관리자가 회원 권한 리스트보기
	public List<UserAuthoritySet> adUserAuthorityList(String libNum) {

		return adminMapper.adUserAuthorityList(libNum);
	}

	// 관리자가 회원 권한 수정하기
	public UserAuthoritySet getAdUserAuthorityUpdate(String uasCode, String getSAID) {
		return adminMapper.getAdUserAuthorityUpdate(uasCode, getSAID);
	}

	// 관리자가 회원 권한 수정하고 리스트로넘기기
	public int adUserAuthorityUpdate(UserAuthoritySet userAuthoritySet) {

		return adminMapper.adUserAuthorityUpdate(userAuthoritySet);
	}

	// 유저 권한등급 내역 리스트 전체 가져오기
	public List<UserAuthorityHistory> adUserAuthorityHistorySearchList(String libNum) {

		return adminMapper.adUserAuthorityHistorySearchList(libNum);
	}

	// 유저 권한등급 내역 검색 리스트 전체 가져오기
	public List<UserAuthorityHistory> adUserAuthorityHistorySearch() {

		return adminMapper.adUserAuthorityHistorySearch();
	}

	/**********************************************************************************/

	// 관리자가 사서 등록하기
	public int librarianInsert1(User user) {
		return adminMapper.librarianInsert1(user);
	}

	public int librarianInsert2(LibrarianLevel librarianLevel) {
		return adminMapper.librarianInsert2(librarianLevel);
	}

	// 관리자가보는 사서 리스트 (권한부여가능)
	public List<User> librarianLevelList1(String libNum) {
		return adminMapper.librarianLevelList1(libNum);
	}

	public List<User> librarianLevelList2(String libNum) {
		return adminMapper.librarianLevelList2(libNum);
	}

	// 관리자 회원정보&권한 수정 -한개 정보 가져오기
	public User getLibrarianLevelUpdate(String uId, String libNum) {
		return adminMapper.getLibrarianLevelUpdate(uId, libNum);
	}

	// 관리자가 회원정보&권한 수정
	public int librarianLevelUpdate1(User user) {
		return adminMapper.librarianLevelUpdate1(user);
	}

	public int librarianLevelUpdate2(LibrarianLevel librarianLevel) {
		return adminMapper.librarianLevelUpdate2(librarianLevel);
	}

	// 관리자가 사서 상세보기
	public User librarianDetail(String uId) {
		return adminMapper.librarianDetail(uId);

	}

	/**********************************************************************************/

	// 사서 - 사서 내 정보 수정하기.
	public User getLibrarianMyUpdate(String getSAID, String libNum) {
		return adminMapper.getLibrarianMyUpdate(getSAID, libNum);
	}

	public int librarianMyUpdate(User user) {
		return adminMapper.librarianMyUpdate(user);
	}

	// 사서 마이페이지 - 내 정보 상세보기
	public User librarianMyDetail(String getSAID, String libNum) {
		return adminMapper.librarianMyDetail(getSAID, libNum);
	}

	/**********************************************************************************/

	// userSearchList - 관리자가 회원 삭제
	public int deleteUser(String said, String write, String uId) {

		User u = adminMapper.checkPw(said, write);
		int result = 0;
		if (u == null) {

		} else {
			result = adminMapper.deleteUser(uId);
		}
		return result;
	}

	// adUserLevelList - 관리자가 회원등급 삭제
	public int deleteLevel(String said, String write, String ulLevel) {
		User u = adminMapper.checkPw(said, write);
		int result = 0;
		if (u == null) {

		} else {
			result = adminMapper.deleteLevel(ulLevel);
		}
		return result;
	}

}
