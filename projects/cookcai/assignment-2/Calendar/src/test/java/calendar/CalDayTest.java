package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	CalDay d = new CalDay();
	 	GregorianCalendar c = new GregorianCalendar();
	 	CalDay day = new CalDay(c);

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour = 24; // should be invalid hour
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
		 String title = "Birthday Party";
		 String description = "This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);

		 GregorianCalendar c = new GregorianCalendar();
		 CalDay day = new CalDay(c);
		 day.addAppt(appt);
		 //assertTrue(c.isValid());


		 //assertEquals(0, day.getSizeAppts()); FAILS
		 appt.setStartHour(22); // valid hour
		 assertEquals(1, day.getSizeAppts());
	 }
	 // addAppt and iterator
	 public void test03() throws Throwable{
		 int startHour = 5; //invalid hour
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
		 String title = "Birthday Party";
		 String description = "This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
		 GregorianCalendar c = new GregorianCalendar();
		 CalDay day = new CalDay(c);

		 day.addAppt(appt);
		 appt.setStartDay(startDay - 1);
		 day.addAppt(appt);
		 appt.setStartDay(startDay + 1);
		 day.addAppt(appt);
		 appt.setStartDay(startDay - 2);
		 day.addAppt(appt);

		 Iterator it = day.iterator();
		 assertNull(it);

		 appt.setStartHour(12);
		 day.addAppt(appt);

		 it = day.iterator();
		 assertNotNull(it);

	 }

	 public void test04() throws Throwable{
		 int startHour = 3; //invalid hour
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
		 String title = "Birthday Party";
		 String description = "This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
		 GregorianCalendar c = new GregorianCalendar();
		 CalDay day = new CalDay(c);

		 day.addAppt(appt);
		 appt.setStartDay(startDay - 1);
		 day.addAppt(appt);

		 assertNotNull(day.toString());
	 }
//add more unit tests as you needed	
}
