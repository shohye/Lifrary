package ksmart.pentagon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @file   LibraryService.java 
 * @name   library service 
 * @brief  도서관 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class LibraryService {
	@Autowired private LibraryMapper libraryMapper;
	
}
