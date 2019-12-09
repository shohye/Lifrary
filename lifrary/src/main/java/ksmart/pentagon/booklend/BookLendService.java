package ksmart.pentagon.booklend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;

@Service
public class BookLendService {
	
	@Autowired private BookLendMapper booklendmapper;
	
	public List<BookLend> bookSearchList(){
		
		return booklendmapper.bookSearchList();
		
	}
	
	public BookStock bookInfo(String svBook) {
		
		BookStock bookStock = booklendmapper.bookInfo(svBook);
		
		if(bookStock == null) {
			
			System.out.println("검색된 도서가 없습니다.");
		}
		
		else {
			
			System.out.println("검색된 도서가 있습니다.");
		}
		
		return bookStock;
		
	}

}
