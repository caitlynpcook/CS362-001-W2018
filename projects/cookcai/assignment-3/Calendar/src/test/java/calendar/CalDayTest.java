package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	// test constructor
	@Test
	public void test01()  throws Throwable  {
		CalDay d = new CalDay();
		assertFalse(d.isValid());

		GregorianCalendar c = new GregorianCalendar();
		CalDay day = new CalDay(c);
		assertTrue(day.isValid());

	}

	// test addAppt
	@Test
	public void test02()  throws Throwable  {
		int startHour = 22;
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
		assertEquals(1, day.getSizeAppts());

		day.addAppt(appt);
		appt.setStartDay(startDay - 1);
		day.addAppt(appt);
		appt.setStartDay(startDay + 1);
		day.addAppt(appt);
		appt.setStartDay(startDay - 2);
		day.addAppt(appt);
	}

	// test setters
	@Test
	public void test03() throws Throwable{
		GregorianCalendar c = new GregorianCalendar();
		CalDay day = new CalDay(c);

		assertEquals(c.get(c.DAY_OF_MONTH), day.getDay());
		assertEquals(c.get(c.MONTH), day.getMonth());
		assertEquals(c.get(c.YEAR), day.getYear());
	}


	@Test
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

	// test iterator
	@Test
	public void test05(){
		GregorianCalendar c = new GregorianCalendar();
		CalDay day = new CalDay(c);
		CalDay d = new CalDay();

		assertNull(d.iterator());

		int startHour = 22;
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

		day.addAppt(appt);
		assertNotNull(day.iterator());
	}

	// test toString
	@Test
	public void test06(){
		GregorianCalendar c = new GregorianCalendar(2018, 2, 26);
		CalDay day = new CalDay(c);
		CalDay d = new CalDay();


		String a = "\t --- 2/26/2018 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n";
		assertEquals(a, day.toString());
	}
}
