package calendar;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */

    // Test addAppt function
	// test invalid appt
	// test appt a before appt b
	// test appt b before a

	public Appt random_appt(){
		// decide whether valid or invalid
		// choose random values for time
		// hour, minute, day, month, year, title, description
		Random random = new Random(System.currentTimeMillis());
		int n = ValuesGenerator.RandInt(random);

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

		if(n%10 < 2){ // invalid appt
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

	 @Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 try {
			GregorianCalendar cal = new GregorianCalendar();
			CalDay c = new CalDay(cal);
		 	for(int i = 0; elapsed < 60*500; i++) {
				// generate a random appt
				Appt a = random_appt();
				// add it
				c.addAppt(a);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((i%10000)==0 && i!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+(500*60));
			}

		 }catch(NullPointerException e){

		 }
		 
	 }


	
}
