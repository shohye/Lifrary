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

	// 프로그램 좌측메뉴에 최근등록 프로그램 3개까지 뿌려주기.
	public List<ProgramManager> getLatelyProgram(String libNum) {
		return programMapper.getLatelyProgram(libNum);
	}

	// 프로그램 리스트 전체 가져오기
	public List<ProgramManager> getProgramList(String libNum) {
		return programMapper.getProgramList(libNum);
	}

	// 검색결과에 맞는 프로그램 리스트 가져오기
	public List<ProgramManager> getSearchProgramList(String keywords, String target, String libNum) {

		System.out.println(keywords + " <== keywords");
		System.out.println(target + " <== target");

		return programMapper.getSearchProgramList(keywords, target, libNum);

	}

	/* 프로그램 신청 리스트 가져오기 메서드 오버로딩을 이용 */

	// 프로그램 신청 리스트 전체 가져오기 (사서채널)
	public List<ProgramApply> adminGetProgramApplyList(String libNum) {
		return programMapper.adminGetProgramApplyList(libNum);
	}

	// 프로그램 신청 리스트 전체 가져오기 (도서관 마이페이지)
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
	public void applyProgram(ProgramApply pa) {
		String appUpdate = "insert";
		programMapper.applyProgram(pa);
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

	// 프로그램 등록하기
	public void insertProgram(ProgramManager pm) {
		programMapper.insertProgram(pm);
	}
}
