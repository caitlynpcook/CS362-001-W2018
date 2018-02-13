package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {

	// test getters
	@Test
	public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	// test setters
	@Test
	public void test02()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		appt.setStartHour(19);
		appt.setStartMinute(0);
		appt.setStartDay(17);
		appt.setStartMonth(02);
		appt.setStartYear(2017);
		appt.setTitle("New Title");
		appt.setDescription("New description of event");

		// assertions
		assertTrue(appt.getValid());
		assertEquals(19, appt.getStartHour());
		assertEquals(0, appt.getStartMinute());
		assertEquals(17, appt.getStartDay());
		assertEquals(02, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("New Title", appt.getTitle());
		assertEquals("New description of event", appt.getDescription());

		appt.setTitle(null);
		assertEquals("", appt.getTitle());
		appt.setDescription(null);
		assertEquals("", appt.getDescription());
	}

	// test recurrence functions
	@Test
	public void test03() throws Throwable {
		int days[] = {1, 3}; // recurDays
		int recurBy = 2; // recurBy
		int incr = 3; // recurIncrement
		int num_rec = 4; // recurNumber

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 1;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		// Test default recurrence settings
		assertTrue(!appt.isRecurring());
		assertNotNull(appt.getRecurDays());

		appt.setRecurrence(days, recurBy, incr, num_rec);

		// Test manually setting recurrence
		assertEquals(num_rec, appt.getRecurNumber());
		assertEquals(recurBy, appt.getRecurBy());
		assertEquals(days, appt.getRecurDays());
		assertTrue(appt.isRecurring());
		assertEquals(incr, appt.getRecurIncrement());
	}

	// test string rep
	@Test
	public void test04() throws Throwable{
		int startHour = 28;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 1;
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

		assertEquals(null, appt.toString()); // invalid appt

		appt.setStartHour(21);
		assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

		appt.setStartHour(11);
		assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n", appt.toString());

		appt.setStartHour(12);
		assertEquals("\t1/15/2018 at 12:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
	}

	// test compareTo
	@Test
	public void test05() throws Throwable{
		int startHour = 21;
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

		Appt appt_b = new Appt(startHour,
				startMinute + 1,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		assertTrue(appt.compareTo(appt_b) < 0);

		appt_b.setStartMinute(startMinute-1);
		assertFalse(appt.compareTo(appt_b) < 0);
	}

	// test isValid()
	@Test
	public void test06(){
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		assertTrue(appt.getValid());

		// Hours
		appt.setStartHour(24);
		assertEquals(false, appt.getValid());
		appt.setStartHour(23);
		assertEquals(true, appt.getValid());

		appt.setStartHour(-1);
		assertEquals(false, appt.getValid());
		appt.setStartHour(0);
		assertEquals(true, appt.getValid());

		appt.setStartHour(21);

		// Minutes
		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(0);
		assertEquals(true, appt.getValid());

		appt.setStartMinute(60);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(59);
		assertEquals(true, appt.getValid());

		// Day
		appt.setStartDay(0);
		assertEquals(false, appt.getValid());
		appt.setStartDay(1);
		assertEquals(true, appt.getValid());

		appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear, 0) + 1);
		assertEquals(false, appt.getValid());
		appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear, 0));
		assertEquals(true, appt.getValid());

		// Month
		//appt.setStartMonth(0);
		//assertEquals(false, appt.getValid());
		appt.setStartMonth(1);
		assertEquals(true, appt.getValid());

		//appt.setStartMonth(13);
		//assertEquals(false, appt.getValid());
		appt.setStartMonth(12);
		assertEquals(true, appt.getValid());

		// Year
		//appt.setStartYear(-1);
		//assertEquals(false, appt.getValid());
		appt.setStartYear(2016);
		assertEquals(true, appt.getValid());

		appt.setStartMonth(2);
		appt.setStartDay(29);
		assertEquals(true, appt.getValid());

		appt.setStartYear(2017);
		assertEquals(false, appt.getValid());
	}
//add more unit tests as you needed
	
}
