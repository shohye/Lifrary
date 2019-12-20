package ksmart.pentagon.librarianbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
}
