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

	// 프로그램 리스트 전체 가져오기
	public List<ProgramManager> getProgramList();

	// 프로그램 신청 리스트 전체 가져오기
	public List<ProgramApply> getProgramApplyList();
	
	// 프로그램 신청 리스트 전체 가져오기 (마이페이지 -> 리스트 들어갈때 세션 id가지고가기)
	public List<ProgramApply> getProgramApplyList(String uId);

	// 선택한 프로그램 1개 가져오기
	public ProgramManager getProgram(String pmCode);

	// 선택한 paCode에 맞는 pm 정보 가져오기
	public ProgramManager getProgramDetail(String paCode);
	
	// 프로그램 신청하기
	public void insertProgram(ProgramApply pa);
	
	// 프로그램 수정하기
	public void updateProgram(ProgramManager pm);
	
	// 프로그램 취소하기
	public void cancleProgram(String paCode);
	
	// 프로그램 신청자수 변경. (신청시(insert) +1 / 취소시(delete) -1)
	public void updateApplicant(String appUpdate, String pmCode);

}
