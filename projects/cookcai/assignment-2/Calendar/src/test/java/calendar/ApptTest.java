package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
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

	 @Test
	  public void test02()  throws Throwable  {
		 // test setters
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
	 }

	 // test recurrence functions
	@Test
	public void test03() throws Throwable {
		// recurDays
		int days[] = {1, 3};
		// recurBy
		int recurBy = 2;
		// recurIncrement
		int incr = 3;
		// recurNumber
		int num_rec = 4;

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
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

		appt.setRecurrence(days, recurBy, incr, num_rec);

		// assertions
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

		assertEquals(null, appt.toString()); // invalid appt
		appt.setStartHour(9);

		String a = appt.toString();
		assertTrue(a.equals(appt.toString()));


	}


	// test compareTo
	@Test
	public void test05() throws Throwable{
		int startHour = 28;
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
	}
//add more unit tests as you needed

	
}
