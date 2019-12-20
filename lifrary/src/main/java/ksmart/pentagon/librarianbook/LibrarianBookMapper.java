package ksmart.pentagon.librarianbook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.LibrarianBook;

@Mapper
public interface LibrarianBookMapper {
	
	public List<LibrarianBook> librarianBookList(LibrarianBook librarianBook);
	
	public LibrarianBook bookRecommendDetail(LibrarianBook librarianBook);
	
	public void bookRecommendDelete(@RequestParam(value = "lbCode")String lbCode);
}
