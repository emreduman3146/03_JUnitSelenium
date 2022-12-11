package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class f_RepeatedTest
{
    @RepeatedTest(4)
    void add_positiveTest()
    {
        System.out.println("");
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,5),15);
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,-5),5);
    }


    @RepeatedTest(value = 4,name = "{displayName} - {currentRepetition} / {totalRepetitions}")
    @DisplayName("toplama methodumun testi")
    void add_positiveTest2()
    {
        System.out.println("");
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,5),15);
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,-5),5);
    }
}
