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

	@Autowired
	private ProgramMapper programMapper;

	// 프로그램 리스트 전체 가져오기
	public List<ProgramManager> getProgramList() {		
		return programMapper.getProgramList();
	}
	
	//프로그램 신청 리스트 전체 가져오기
		public List<ProgramApply> getProgramApplyList(){
			return programMapper.getProgramApplyList();
		}
	

	// 선택한 프로그램 1개 가져오기
	public ProgramManager getProgram(String pmCode) {
		return programMapper.getProgram(pmCode);
	}

	// 프로그램 신청하기
	public void insertProgram(ProgramApply pa) {
		//자동 코드 기능이 생기면 수정할것.
		pa.setPaCode("pa-19120900005");
		programMapper.insertProgram(pa);
	}
	
	//프로그램 수정하기
		public void updateProgram(ProgramManager pm) {
			programMapper.updateProgram(pm);
		}
}
