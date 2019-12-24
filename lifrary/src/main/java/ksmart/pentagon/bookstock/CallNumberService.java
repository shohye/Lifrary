package ksmart.pentagon.bookstock;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.CallNumber;

@Service
public class CallNumberService {
	
	@Autowired private CallNumberMapper callNumberMapper;
	
	@Autowired private MakeBsmarkService makeBsmarkService;
	
	// 저작기호 = 저자기호 + 도서기호

    // 저자기호 구하기
	public String makeBsmarkAuthor(String biAuthor) {	
		
		List<Map<String, Character>> charList = makeBsmarkService.getCharList(biAuthor);
		
		String resultStr = "";
		
		if(charList != null && charList.size() > 1) {
			
			resultStr += charList.get(0).get("char");
			
			Map<String, Character> charNextMap = charList.get(1);
			
			Character reCho = charNextMap.get("reCho"); //1번째
			Character reJun = charNextMap.get("reJun"); //2번째
			Character reJon = charNextMap.get("reJon"); //3번째
			
			if(reCho != null && !"".equals(reCho.toString()))  {
				resultStr += makeBsmarkNum(reCho.toString());
			}
			if(reJun != null && !"".equals(reJun.toString()))  {
				resultStr += makeBsmarkNum(reJun.toString());
			}
			
			
		/*	String authorMark = callNumberMapper.checkAuthor(resultStr);
			String plus = "1";
			if(authorMark == null) {
				
			}else {
				resultStr += plus;
				callNumberMapper.checkAuthor(resultStr);
			}*/
		}				
		return resultStr;
	}
	
	// 저자기호 구하기 (DB에 접근해서 2번째 글자의 숫자기호 구하기)
	public String makeBsmarkNum(String text) {		
		System.out.println("===============  서비스 메서드 실행    ===============");
		String result = callNumberMapper.makeBsmarkNum(text);
		System.out.println("메서드 실행..result=>"+result);
		return result;
	}
	
	// 도서 기호 구하기
	public String makeBsmarkName(String biName) {
		System.out.println("============ makeBsmarkName ============");	
		List<Map<String, Character>> nameList = makeBsmarkService.getCharList(biName);
		
		String resultStr = "";
		
		if(nameList != null && nameList.size() > 1) {
			
			Map<String, Character> nameNextMap = nameList.get(0);
			
			Character reCho = nameNextMap.get("reCho"); //1번째
			Character reJun = nameNextMap.get("reJun"); //2번째
			Character reJon = nameNextMap.get("reJon"); //3번째
			
			if(reCho != null && !"".equals(reCho.toString()))  {
				resultStr += reCho.toString();
			}			
		}				
		return resultStr;		
	}
}



/*for(int i = 0; i < list.size() ; i++)
{
	int a = (int)(list.get(i)).get("cho"); //문자 분해 초성 유니코드
	int b = (int)(list.get(i)).get("jun"); //문자 분해 중성 유니코드
	int c = (int)(list.get(i)).get("jon"); //문자 분해 종성 유니코드
	
	char temp = (char)(0xAC00 + 28 * 21 *(a) + 28 * (b) + (c) );
	
	lastStr = lastStr.concat(String.valueOf(temp));			
	System.out.println("lastStr=>"+ (char)(0xAC00 + 28 * 21 *(a) + 28 * (b) + (c) )); // 초.중.종 합친 한글자
	
}*/
