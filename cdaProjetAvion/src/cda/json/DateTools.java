package cda.json;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	public static String getDate() {
		 SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		    Date date = new Date();
//		    System.out.println(s.format(date));
		
		return s.format(date);
	}
}