package ksmart.pentagon.bookstock;

import java.util.*;

import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.CallNumber;

public interface CallNumberMapper {
	
	// 저작기호 = 저자기호 + 도서기호
	// 저자기호 만들기
	public String makeBsmarkAuthor(String biAuthor);
	// 도서기호 만들기
	public String makeBsmarkName(String biName);
	
	public String makeBsmarkNum(String text);
	
	//해당 저자명 있는지 체크
	public List<String> checkAuthor(String biAuthor);
	
	//저자기호 있는지 체크
	public List<String> checkAuthorMark(String resultStr, String lCode);
	
	//해당 저작기호 있는지 체크
	public List<String> checkWriterMark(String writer, String lCode);

}
