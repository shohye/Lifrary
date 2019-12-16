package ksmart.pentagon.booklend;


import java.util.List;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.User;

public interface BookLendMapper {
	
	public List<BookLend> bookSearchList(String libNum);
	
	public int bookLendCheck(String libNum, String svBook);
	
	public BookStock bookInfo(String libNum, String svBook);
	
	public BookStock bookInfoStock(String libNum, String svBook);
		
	public User userInfo(String libNum, String svUser);
	
	public String maxCode();
	
	public int lendInsert(BookLend booklend);
}
