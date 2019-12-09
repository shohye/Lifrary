package ksmart.pentagon.booklend;


import java.util.List;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;

public interface BookLendMapper {
	
	public List<BookLend> bookSearchList();
	
	public BookStock bookInfo(String svBook);

}
