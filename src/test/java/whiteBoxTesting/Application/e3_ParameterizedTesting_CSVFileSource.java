package whiteBoxTesting.Application;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class e3_ParameterizedTesting_CSVFileSource
{

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    //, numLinesToSkip = 1 eklemzsek direk line1'den baslar verileri almaya
    public void csvFileTestData_stringReverse(String input, String expected)
    {

        StringManipulation stringManipulation=new StringManipulation();
        assertEquals(expected,stringManipulation.reverseString(input));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv", numLinesToSkip = 1)
    //, numLinesToSkip = 1 eklemzsek direk line1'den baslar verileri almaya
    public void csvFileTestData_stringReverse2(String input, String expected)
    {

        StringManipulation stringManipulation=new StringManipulation();
        assertEquals(expected,stringManipulation.reverseString(input));
    }




}
