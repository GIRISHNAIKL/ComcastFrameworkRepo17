package Command_prompt;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCreatiion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Date dateobj=new java.util.Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sim.format(dateobj);
		System.out.println(actDate);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dataRequires=sim.format(cal.getTime());
		System.out.println(dataRequires);
		

	}

}
