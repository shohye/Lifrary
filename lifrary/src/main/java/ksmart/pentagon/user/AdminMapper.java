package ksmart.pentagon.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.UserLevel;

@Mapper
public interface AdminMapper {

	//유저 레벨 전체 가져오기.
	public List<UserLevel> getUserLevel();
}
