package whiteBoxTesting.Application;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class e5_ParameterizedTesting_Method
{

    public static Stream<Integer> testdataProviderMethod(){
        Stream<Integer> stream01=Stream.of(2,4,6,8,0);
        return stream01;
    }



    @ParameterizedTest
    @MethodSource("testdataProviderMethod")
    void isEvenTest(int digit) {
        CalculatorProgram cal=new CalculatorProgram();
        assertTrue(cal.isEven(digit));
    }







    @ParameterizedTest
    @MethodSource("stringProviderMethod")
    void stringReversedTest(String input, String reversed) {
        assertTrue(new StringManipulation().reverseString(input).equals(reversed));
    }

    public static Stream<Arguments> stringProviderMethod(){

        Stream<Arguments> stream01=Stream.of(
                Arguments.arguments("usa","asu"),
                Arguments.arguments("canada","adanac"),
                Arguments.arguments("turkiye","eyikrut")
        );

        return stream01;
    }





}
