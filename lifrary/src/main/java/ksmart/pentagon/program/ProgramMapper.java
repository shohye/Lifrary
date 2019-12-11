package ksmart.pentagon.program;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.ProgramApply;
import ksmart.pentagon.vo.ProgramManager;

/*
 * @file   ProgramMapper.java 
 * @name   program mapper 
 * @brief  프로그램(행사, 강좌) 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface ProgramMapper {

	//프로그램 리스트 전체 가져오기
	public List<ProgramManager> getProgramList();
	
	//선택한 프로그램 1개 가져오기
	public ProgramManager getProgram(String pmCode);
	
	//프로그램 신청하기
	public void insertProgram(ProgramApply pa);
}
