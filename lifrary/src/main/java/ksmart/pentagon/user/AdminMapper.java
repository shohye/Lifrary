package ksmart.pentagon.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.UserLevel;

/*
 * @file   AdminMapper.java 
 * @name   Admin mapper
 * @brief  어드민 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface AdminMapper {

	//유저 레벨 전체 가져오기.
	public List<UserLevel> getUserLevel();
}
