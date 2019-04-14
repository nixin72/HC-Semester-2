package b20_l09_project;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Calendar;

public class DateConverter
{

	public static void main(String[] args)
	{
		//instantiating objects
	  Calendar cal = Calendar.getInstance();
		GregorianCalendar aDate = new GregorianCalendar();
		GregorianCalendar myBirthday = new GregorianCalendar(1998,7,4);
		
		DateFormat sm = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat md = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat lg = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat fl = DateFormat.getDateInstance(DateFormat.FULL);
		
		//printing out the date in all the different formats
		System.out.println(sm.format(aDate.getTime()) + "\n"
				+ md.format(aDate.getTime()) + "\n"
				+ lg.format(aDate.getTime()) + "\n"
				+ fl.format(aDate.getTime()) + "\n");
		
		//printing out the date one week from today
		cal.add(Calendar.DATE, 7);
		System.out.println(md.format(cal.getTime()));
		
		//Printing out my birthday
		System.out.println(fl.format(myBirthday.getTime()));
		
		//printing out my 21st birthday
		myBirthday.add(Calendar.YEAR, 21);
		System.out.println(fl.format(myBirthday.getTime()));
	}

}
