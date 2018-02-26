package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	public Appt random_appt(int valid){
		// decide whether valid or invalid
		// choose random values for time
		// hour, minute, day, month, year, title, description
		Random random = new Random(System.currentTimeMillis());

		int startHour=ValuesGenerator.RandInt(random);
		int startMinute=ValuesGenerator.RandInt(random);
		int startDay=ValuesGenerator.RandInt(random);
		int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
		int startYear=ValuesGenerator.RandInt(random);
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		if(valid == 0){ // invalid appt
			if(appt.getValid()){
				appt.setStartMinute(startMinute+60);
			}
			return appt;
		} else{	// valid appt
			if(!appt.getValid()) {
				do {
					startHour = ValuesGenerator.RandInt(random);
					startMinute = ValuesGenerator.RandInt(random);
					startDay = ValuesGenerator.RandInt(random);
					startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					startYear = ValuesGenerator.RandInt(random);

					appt.setStartMinute(startMinute);
					appt.setStartHour(startHour);
					appt.setStartDay(startDay);
					appt.setStartMonth(startMonth);
					appt.setStartYear(startYear);
				}while(!appt.getValid());
			}
			return appt;
		}
	}

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		// The list of the of methods to be tested in the Appt class
		String[] methodArray = new String[] {"deleteAppt", "getApptRange"};//, "getApptRange"};

		int n = random.nextInt(methodArray.length);
		// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
    // deleteAppt
	// getApptRange

	 @Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("TESTING TIMETABLE CLASS");
		 Random random = new Random(System.currentTimeMillis());

		 try {
			 for(int i = 0; elapsed < 60*500; i++) {

                 String methodName = TimeTableRandomTest.RandomSelectMethod(random);

				 int n = ValuesGenerator.RandInt(random);

					 // TEST CASES FOR VARIOUS FUNCTIONS
					 if (methodName.equals("deleteAppt")) {
					     if(n%10 < 2){
					     	// appts = null
							 Appt appt = random_appt(1);
							 TimeTable t = new TimeTable();

							 t.deleteAppt(null, appt);
						 } else if (n%10 < 4){
							 // appt = null
							 LinkedList<Appt> appts = new LinkedList<Appt>();

							 for(int j = 0; j < 10; j++){
								 appts.add(random_appt(1));
							 }
							 TimeTable t = new TimeTable();
                             t.deleteAppt(appts, null);
						 } else if (n%10 == 4){
							 // both = null
							 TimeTable t = new TimeTable();
							 t.deleteAppt(null, null);
						 } else if (n%10 < 6){
						 	// appt invalid
							 LinkedList<Appt> appts = new LinkedList<Appt>();

							 for(int j = 0; j < 10; j++){
								 appts.add(random_appt(1));
							 }
							 Appt a = random_appt(0);
							 TimeTable t = new TimeTable();
							 t.deleteAppt(appts, a);
						 } else{
							 // all valid args, random values
							 TimeTable t = new TimeTable();
							 LinkedList<Appt> appts = new LinkedList<Appt>();

							 Appt a = random_appt(1);
							 appts.add(a);
							 for(int j = 0; j < 10; j++){
								 appts.add(random_appt(1));
							 }
							 Appt b = random_appt(1);

							 appts.add(b);
							 t.deleteAppt(appts, a);
							 t.deleteAppt(appts, b);
						 }
					 } else if(methodName.equals("getApptRange")){
					 	// first day after last day
						 TimeTable t = new TimeTable();
						 LinkedList<Appt> appts = new LinkedList<Appt>();

						 GregorianCalendar a = new GregorianCalendar(ValuesGenerator.RandInt(random),
								 ValuesGenerator.getRandomIntBetween(random, 1, 11),ValuesGenerator.getRandomIntBetween(random, 1, 2),
								 ValuesGenerator.RandInt(random),ValuesGenerator.RandInt(random));
						 GregorianCalendar b = new GregorianCalendar(ValuesGenerator.RandInt(random),
								 ValuesGenerator.getRandomIntBetween(random, 1, 11), ValuesGenerator.RandInt(random),
								 ValuesGenerator.RandInt(random),ValuesGenerator.RandInt(random));

						 GregorianCalendar first = (a.before(b) ? a:b);
						 GregorianCalendar last = (a.before(b) ? b:a);


						 for(int j = 0; j < 10; j++){
							 appts.add(random_appt(1));
						 }
						 for(int j = 0; j < 10; j++){
							 appts.add(random_appt(0));
						 }
						 t.getApptRange(appts, first, last);

					 }
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((i%10000)==0 && i!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+(500*60));
			 }

		 }catch(NullPointerException e){

		 }

		 
	 }


	
}
