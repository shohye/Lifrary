package ksmart.pentagon.librarianbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.LibrarianBook;

@Service
public class LibrarianBookService {

	@Autowired private LibrarianBookMapper librarianBookMapper;
	public List<LibrarianBook> librarianBookList(LibrarianBook librarianBook) {
		return librarianBookMapper.librarianBookList(librarianBook);
	}
}
