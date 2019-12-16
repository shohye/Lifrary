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

	/* 프로그램 신청 리스트 가져오기 메서드 오버로딩을 이용 */

	// 프로그램 신청 리스트 전체 가져오기
	public List<ProgramApply> getProgramApplyList() {
		return programMapper.getProgramApplyList();
	}

	// 프로그램 신청 리스트 전체 가져오기
	public List<ProgramApply> getProgramApplyList(String uId) {
		return programMapper.getProgramApplyList(uId);
	}

	// 선택한 프로그램 1개 가져오기
	public ProgramManager getProgram(String pmCode) {
		return programMapper.getProgram(pmCode);
	}

	// 선택한 paCode에 맞는 pm 정보 가져오기
	public ProgramManager getProgramDetail(String paCode) {
		System.out.println(programMapper.getProgramDetail(paCode) + "<== pm 객체 리턴");
		return programMapper.getProgramDetail(paCode);
	}

	// 프로그램 삭제하기(사서)
	public void deleteProgram(String pmCode) {
		programMapper.deleteProgram(pmCode);
		
		// 프로그램 삭제시 신청한 사람들 취소로 바꾸기
		programMapper.deleteCancleProgram(pmCode);
		
	}
	

	// 프로그램 신청하기
	public void insertProgram(ProgramApply pa) {
		String appUpdate = "insert";
		// 자동 코드 기능이 생기면 수정할것.
		pa.setPaCode("pa-19121600008");
		programMapper.insertProgram(pa);
		programMapper.updateApplicant(appUpdate, pa.getPmCode()); // 신청시 applicant + 1 해주기.
	}

	// 프로그램 취소하기
	public void cancleProgram(String paCode, String pmCode) {
		String appUpdate = "cancle";
		programMapper.cancleProgram(paCode);
		programMapper.updateApplicant(appUpdate, pmCode);
	}

	// 프로그램 수정하기
	public void updateProgram(ProgramManager pm) {
		programMapper.updateProgram(pm);
	}
}
