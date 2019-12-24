package ksmart.pentagon.bookstock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MakeBsmarkService {
	
	private List<Map<String, Integer>> intList;
	private List<Map<String, Character>> charList;	
			
	private void action(String str, boolean isChartype) {
			
		if(!isChartype) intList = new ArrayList<Map<String, Integer>>();
		if(isChartype) charList = new ArrayList<Map<String, Character>>();
					
		if( str != null ) {
			
			for(int i = 0 ; i < str.length(); i++){			
												
				char character = str.charAt(i);
								
				if(character >= 0xAC00){   
					// 유니코드
					char uniVal = (char) (character - 0xAC00);
					
					char cho = (char) (((uniVal - (uniVal % 28))/28)/21);    
					char jun = (char) (((uniVal - (uniVal % 28))/28)%21);
					char jon = (char) (uniVal %28);
					
					// 각 배열에 유니코드 넣어서 해당하는 한글 출력
					char reCho = StaticCodeClass.CHO[cho];
					char reJun = StaticCodeClass.JUN[jun];
					
					if(isChartype) {
						
						Map<String, Character> charMap = new HashMap<String, Character>();

						charMap.put("char", (char) character);
						charMap.put("reCho", (char) reCho);
						charMap.put("reJun", (char) reJun);
						
						
						if((char)jon != 0x0000) {
							char reJon = StaticCodeClass.JON[jon];	
							charMap.put("reJon", (char) reJon);
						}
						
						charList.add(charMap);
					}
					
					if(!isChartype) {
						
						Map<String, Integer> intMap = new HashMap<String, Integer>();
						intMap.put("cho", (int) cho);
						intMap.put("jun", (int) jun);
						if((char)jon != 0x0000) {						
							intMap.put("jon", (int) jon);
						}
						intList.add(intMap);
					}														
				}
			}
		}	
	}
			
	public List<Map<String, Integer>> getIntList(String str){
		action(str, false);
		return intList;
	}
	
	public List<Map<String, Character>> getCharList(String str){
		action(str, true);
		return charList;
	}
	
}
