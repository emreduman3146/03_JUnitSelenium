package whiteBoxTesting.Application;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Month;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class e4_ParameterizedTesting_Enum
{

    @ParameterizedTest
    @EnumSource(value = Day.class)
    //BU METHOD 7 KEZ CALISIR
    void daysOfWeek(Day day)
    {
        assertNotNull(day);
    }






    @ParameterizedTest
    @EnumSource(value = Day.class, names = {"MONDAY", "TUESDAY"})
    void daysOfWeek2(Day day)
    {
        assertNotNull(day);
    }





    @ParameterizedTest
    @EnumSource(value = Day.class, mode = EXCLUDE, names = {"MONDAY", "FRIDAY"})
    void daysOfWeek3(Day day)
    {
        assertNotNull(day);
    }


    @ParameterizedTest
    @EnumSource(Month.class) // passing all 12 months
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month)
    {
        //local variable, method variable
        int monthNumber = month.getValue();//1,2,3,4,5,6,7,8,9,10,11,12
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }



    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }




    @ParameterizedTest
    @EnumSource(
            value = Month.class,//12 tane testdata'yi kullan
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EXCLUDE)
    void exceptFourMonths_OthersAre31DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(31, month.length(isALeapYear));
    }




    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void fourMonths_AreEndingWithBer(Month month) {
        EnumSet<Month> months =
                EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertTrue(months.contains(month));
    }


}
