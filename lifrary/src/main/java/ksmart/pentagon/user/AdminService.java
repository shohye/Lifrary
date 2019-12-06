package ksmart.pentagon.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
