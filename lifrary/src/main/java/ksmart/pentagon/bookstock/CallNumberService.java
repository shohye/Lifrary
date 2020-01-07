package ksmart.pentagon.bookstock;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.CallNumber;

@Service
public class CallNumberService {
	
	@Autowired private CallNumberMapper callNumberMapper;
	
	@Autowired private MakeBsmarkService makeBsmarkService;
	
	// 저작기호 = 저자기호 + 도서기호

    // 저자기호 구하기
	public String makeBsmarkAuthor(String biAuthor, String lCode) {	
		
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
			
			// informaton 작가명
			List<String> author = callNumberMapper.checkAuthor(biAuthor);
			// stock 작가기호
			List<String> authorMark = callNumberMapper.checkAuthorMark(resultStr,lCode);
			String plus = "1";
			String resultStrPlus = "";
			
			// 작가명 자체가 겹칠때 = 같은작가(동일 인물)   //이라고 예를 들자.. 동명이인은 알아서 하시기를,,
			if(author.size()>0) {
				
			// 작가명 자체가 겹치지 않을때
			}else {
				
			   if(authorMark.size()>0) {  // 작가명이 겹치지 않으나, 작가기호가 겹칠때
				   resultStr += plus;
					
			    /*  List<String> authorMark2 = callNumberMapper.checkAuthorMark(resultStr);
					if(authorMark2.size()>0) {
						resultStrPlus = resultStr+"2";					
					}*/					
				}else { // 작가명이 겹치지 않고 작가기호도 겹치지 않을때
				}				
			}			
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
	
	// 도서 기호 구하기2
	public String makeBsmarkName2(String biName) {
		System.out.println("============ makeBsmarkName ============");	
		List<Map<String, Character>> nameList = makeBsmarkService.getCharList(biName);
		List<Map<String, Integer>> nIntList = makeBsmarkService.getIntList(biName);
		
		String resultStr = "";
		
		if(nIntList != null && nIntList.size() > 1) {
			
			Map<String, Integer> nameIntNextMap = nIntList.get(0);
			
			int a = (int)nameIntNextMap.get("cho"); //1번째
			int b = (int)nameIntNextMap.get("jun"); //2번째
			
			if(a != 0)  {
				Character temp = (char)(0xAC00 + 28 * 21 *(a) + 28 * (b));
				resultStr = temp.toString();
			}			
		}				
		return resultStr;		
	}
	
	
	public List<String> checkWriterMark(String writer, String lCode) {
		return callNumberMapper.checkWriterMark(writer,lCode);
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
