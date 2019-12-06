package ksmart.pentagon.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @file   ProgramService.java 
 * @name   program service
 * @brief  프로그램(행사, 강좌) 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class ProgramService {

	@Autowired private ProgramMapper programMapper;
}
