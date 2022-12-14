package whiteBoxTesting.Application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static whiteBoxTesting.Application.CalculatorProgram.add;

public class h_TimeoutAnnotation
{

    @BeforeEach
    @Timeout(2)//bu method 1 sn. icinde tamamlanmazsa test fail eder
    void setUp() {
        System.out.println("@BeforeEach calisti!!!");
    }


    @Test
    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)//1 SALISE
    //bu test 1 milisecond milisaniyede tamamlanmazsa test fail eder
    void add_positiveScenarioTest()
    {
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,5),15);
        //100 SATIR KOD VAR
    }


}
