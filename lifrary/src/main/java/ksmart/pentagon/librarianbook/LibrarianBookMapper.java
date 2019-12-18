package ksmart.pentagon.librarianbook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.LibrarianBook;

@Mapper
public interface LibrarianBookMapper {
	
	public List<LibrarianBook> librarianBookList(LibrarianBook librarianBook);
}
