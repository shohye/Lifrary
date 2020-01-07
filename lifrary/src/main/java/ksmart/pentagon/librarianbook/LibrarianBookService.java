package ksmart.pentagon.librarianbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.codeup.CodeUp;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.LibrarianBook;

@Service
public class LibrarianBookService {

	@Autowired private LibrarianBookMapper librarianBookMapper;
	public List<LibrarianBook> librarianBookList(LibrarianBook librarianBook) {
		return librarianBookMapper.librarianBookList(librarianBook);
	}
	
	public LibrarianBook librarianBookDetail(LibrarianBook librarianBook) {
		return librarianBookMapper.bookRecommendDetail(librarianBook);
	}
	
	public void bookRecommendDelete(@RequestParam(value = "lbCode")String lbCode) {
		librarianBookMapper.bookRecommendDelete(lbCode);
	}
	
	public BookInformation getBookInformation(@RequestParam(value = "isbnVal")String isbnVal) {
		return librarianBookMapper.getBookInformation(isbnVal);
	}
	
	public String bookRecommendInsert(LibrarianBook librarianBook,@RequestParam(value = "isbn")String putIsbn) {
		String maxBlCode = librarianBookMapper.maxlbCode();
		String lbCode = CodeUp.codeMaker(maxBlCode);
		System.out.println("LibrarianBookService36"+lbCode);
		librarianBook.setLbCode(lbCode);
		String bsCode = librarianBookMapper.checkBsCode(putIsbn);
		System.out.println("service39!!" + bsCode);
		librarianBook.setBsCode(bsCode);
		System.out.println("service41"+librarianBook);
		librarianBookMapper.bookRecommendInsert(librarianBook);
		return lbCode;
	}
	
	public void bookRecommendUpdate(LibrarianBook librarianBook) {
		librarianBookMapper.bookRecommendUpdate(librarianBook);
	}
}
