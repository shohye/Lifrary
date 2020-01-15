package ksmart.pentagon.codeup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUp {

	public static String codeMaker(String code) {
		String total = null;

		if (code.indexOf("-") == -1) {
			String subInt = code.substring(code.length() - 3, code.length());
			String subName = code.substring(0, code.length() - 3);
			int codeInt = Integer.parseInt(subInt);
			String intCodeFormat = String.format("%03d", codeInt + 1);
			total = subName + intCodeFormat;
		} else {

			Date today = new Date();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyMMdd");
			int nowDate = Integer.parseInt(simpleFormat.format(today));
			String count = null;
			String name = code.substring(0, code.indexOf("-"));
			String date = code.substring(code.lastIndexOf("-") + 1, code.lastIndexOf("-") + 7);
			String subCode = code.substring(code.lastIndexOf("-") + 7, code.lastIndexOf("-") + 7 + 5);
			int intCode = Integer.parseInt(subCode);
			int intDate = Integer.parseInt(date);
			if (intDate < nowDate) {
				total = name + "-" + nowDate + count;
			} else {
				String intCodeFormat = null;
				total = name + "-" + intDate + (intCodeFormat = String.format("%05d", intCode + 1));
			}
		}
		return total;
	}
}
