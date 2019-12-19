package ksmart.pentagon.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.StudyCate;

@Service
public class StudyService {
	@Autowired private StudyMapper studyMapper;
	
public List<StudyCate> studyCateList(String libNum, String sId) {
		
		
		
		return studyMapper.studyCateList(libNum, sId);

	}
}