package ksmart.pentagon.codeup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUp {

	public static String codeMaker(String code) {
		String total = null;

		if (code.indexOf("-") == -1) {
			String subInt = code.substring(code.length() - 3, code.length());
			String subName = code.substring(0, code.length() - 3);
			System.out.println(subName);
			int codeInt = Integer.parseInt(subInt);
			String intCodeFormat = String.format("%03d", codeInt + 1);
			System.out.println(intCodeFormat);
			total = subName + intCodeFormat;
		} else {

			Date today = new Date();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyMMdd");
			int nowDate = Integer.parseInt(simpleFormat.format(today));
			String count = null;
			System.out.println(nowDate);
			System.out.println(count = String.format("%05d", 1));
			String name = code.substring(0, code.indexOf("-"));
			String date = code.substring(code.lastIndexOf("-") + 1, code.lastIndexOf("-") + 7);
			String subCode = code.substring(code.lastIndexOf("-") + 7, code.lastIndexOf("-") + 7 + 5);
			int intCode = Integer.parseInt(subCode);
			int intDate = Integer.parseInt(date);
			System.out.println("코드이름" + name);
			System.out.println("날짜" + date);
			System.out.println("맥스번호" + intCode);
			if (intDate < nowDate) {
				total = name + "-" + nowDate + count;
			} else {
				String intCodeFormat = null;
				total = name + "-" + intDate + (intCodeFormat = String.format("%05d", intCode + 1));
			}
		}
		System.out.println(total);
		return total;
	}
}
