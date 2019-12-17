package ksmart.pentagon.booklend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Code {

	public static String codeCreate(String code) {
		String result = "";
		String count = null;
		
		Date today = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyMMdd");
		int nowDate = Integer.parseInt(simpleFormat.format(today));
		
		System.out.println(nowDate);
		System.out.println(count = String.format("%05d", 1));
		
		String max = code;
		String name = max.substring(0, max.indexOf("-"));
		String date = max.substring(max.lastIndexOf("-")+1, max.lastIndexOf("-")+7);
		String subMax = max.substring(max.lastIndexOf("-")+7,max.lastIndexOf("-")+7+5);
		int intMax = Integer.parseInt(subMax);
		int intDate = Integer.parseInt(date);
		
		System.out.println("코드이름"+name);
		System.out.println("날짜"+date);
		System.out.println("맥스번호"+intMax);
		
		if(intDate < nowDate) {
			System.out.println("어제");
			result = name+"-"+nowDate+count;
			System.out.println(result);
		}else {
			String intMaxFormat = null;
			result = name+"-"+intDate+(intMaxFormat = String.format("%05d",intMax+1 ));
			System.out.println(result);
		}
		return result;
	}
}
