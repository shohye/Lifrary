package ksmart.pentagon.mypage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.StudyCate;

@Mapper
public interface StudyMapper {

	public List<StudyCate> studyCateList(String libNum, String sId);
}
