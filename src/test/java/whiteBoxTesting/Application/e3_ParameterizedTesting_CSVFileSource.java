package whiteBoxTesting.Application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class e3_ParameterizedTesting_CSVFileSource
{



    @ParameterizedTest(name = "#{index} - Run test with args={0}-{1}")
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    //, numLinesToSkip = 1 eklemzsek direk line1'den baslar verileri almaya
    public void csvFileTestData_stringReverse2(String input, String expected)
    {

        StringManipulation stringManipulation=new StringManipulation();
        assertEquals(expected,stringManipulation.reverseString(input));
    }




}
