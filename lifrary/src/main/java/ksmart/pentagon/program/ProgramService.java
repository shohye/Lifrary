package ksmart.pentagon.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.ProgramApply;
import ksmart.pentagon.vo.ProgramManager;

/*
 * @file   ProgramService.java 
 * @name   program service
 * @brief  프로그램(행사, 강좌) 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class ProgramService {

	@Autowired private ProgramMapper programMapper;
	
	//프로그램 리스트 전체 가져오기
	public List<ProgramManager> getProgramList(){
		return programMapper.getProgramList();
	}
	
	//선택한 프로그램 1개 가져오기
	public ProgramManager getProgram(String pmCode) {
		return programMapper.getProgram(pmCode);
	}
	
	//프로그램 신청하기
	public void insertProgram(ProgramApply pa) {
		pa.setPaCode("pa-19120900001");
		programMapper.insertProgram(pa);
	}
}
