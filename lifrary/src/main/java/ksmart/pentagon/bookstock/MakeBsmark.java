package ksmart.pentagon.bookstock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeBsmark {
	
	private static MakeBsmark makeBsmark;
	
	private List<Map<String, Integer>> intList;
	private List<Map<String, Character>> charList;
	private List<Map<String, Character>> nameList;
	
	private MakeBsmark() {}
	
	public static MakeBsmark getinstance() {
		
		if(makeBsmark == null) {
			makeBsmark = new MakeBsmark();
		}		
		return makeBsmark;
	}
		
	private void action(String str, boolean isChartype) {
			
		if(intList == null && !isChartype) intList = new ArrayList<Map<String, Integer>>();
		if(charList == null && isChartype) charList = new ArrayList<Map<String, Character>>();
		
			
		for(int i = 0 ; i < str.length(); i++){
			
			if( str != null ) {
												
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
	
	private void action2(String str2, boolean isChartype) {		

		if(nameList == null && isChartype) nameList = new ArrayList<Map<String, Character>>();
		
			
		for(int i = 0 ; i < str2.length(); i++){
			
			if( str2 != null ) {
												
				char character = str2.charAt(i);
								
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
												
						Map<String, Character> nameMap = new HashMap<String, Character>();
						nameMap.put("char", (char) character);
						nameMap.put("reCho", (char) reCho);
						nameMap.put("reJun", (char) reJun);
						
						if((char)jon != 0x0000) {
							char reJon = StaticCodeClass.JON[jon];	
							nameMap.put("reJon", (char) reJon);
						}
						nameList.add(nameMap);
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
	
	public List<Map<String, Character>> getNameList(String str2){
		action2(str2, true);
		return nameList;
	}
	
}
