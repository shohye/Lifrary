package ksmart.pentagon.librarianbook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.LibrarianBook;

@Mapper
public interface LibrarianBookMapper {
	
	public List<LibrarianBook> librarianBookList(LibrarianBook librarianBook);
	
	public LibrarianBook bookRecommendDetail(LibrarianBook librarianBook);
	
	public void bookRecommendDelete(@RequestParam(value = "lbCode")String lbCode);
	
	public BookInformation getBookInformation(@RequestParam(value = "isbnVal")String isbnVal);
	
	public String maxlbCode();
	
	public String checkBsCode(@RequestParam(value = "putIsbn")String putIsbn);
	
	public void bookRecommendInsert(LibrarianBook librarianBook);
	
	public void bookRecommendUpdate(LibrarianBook librarianBook);
}
