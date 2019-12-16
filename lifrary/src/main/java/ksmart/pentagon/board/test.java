package ksmart.pentagon.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyMMdd");
		int nowDate = Integer.parseInt(simpleFormat.format(today));
		String count = null;
		System.out.println(nowDate);
		System.out.println(count = String.format("%05d", 1));
		String max = "board-19121600002";
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
			String total = name+"-"+nowDate+count;
			System.out.println(total);
		}else {
			String intMaxFormat = null;
			String total= name+"-"+intDate+(intMaxFormat = String.format("%05d",intMax+1 ));
			System.out.println(total);
		}
		
	}

}
