package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	LinkedList<Appt> appts = new LinkedList<Appt>();
		 Appt appt = new Appt(21,
				 30,
				 15,
				 1,
				 2018,
				 "Birthday Party",
				 "This is my birthday party.");

		 int days[] = {0, 1, 2, 3, 4, 5, 6};
		 appt.setRecurrence(days, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 appts.add(appt);

		 GregorianCalendar start = new GregorianCalendar(2018, 1, 15);
		 GregorianCalendar end = new GregorianCalendar(2018, 1, 17);

		 TimeTable t = new TimeTable();
		 LinkedList<CalDay> c = t.getApptRange(appts, start, end);

		 String a =	"[\t --- 1/15/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" +
				 " \n" +
				 ", \t --- 1/16/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" +
				 " \n]";

		 assertEquals(a, c.toString());

		 LinkedList<Appt> bppts = new LinkedList<Appt>();
		 int bdays[] = {5};
		 appt.setRecurrence(bdays, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 bppts.add(appt);

		 start = new GregorianCalendar(2018, 1, 2);
		 end = new GregorianCalendar(2018, 1, 4);


		 c = t.getApptRange(appts, start, end);

		 a ="[\t --- 1/2/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n" +
				 ", \t --- 1/3/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n]";
		 assertEquals(a, c.toString());

		 start = new GregorianCalendar(2018, 1, 15);
		 end = new GregorianCalendar(2018, 1, 17);


		 LinkedList<Appt> cppts = new LinkedList<Appt>();
		 appt.setRecurrence(days, Appt.RECUR_BY_MONTHLY, 1, -1);
		 cppts.add(appt);
		 c = t.getApptRange(cppts, start, end);

		 a = "[\t --- 1/15/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n"+
				 "[]\n" +
				 ", \t --- 1/16/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n" +
				 "]";
		// assertEquals(a, c.toString());
		 //appt.setRecurrence(bdays, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 //bppts.add(appt);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
