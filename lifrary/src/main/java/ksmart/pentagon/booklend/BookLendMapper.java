package ksmart.pentagon.booklend;


import java.util.List;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.User;

public interface BookLendMapper {
	
	public List<BookLend> bookSearchList();
	
	public BookStock bookInfo(String svBook);
	
	public User userInfo(String svUser);

}
