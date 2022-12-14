package whiteBoxTesting.Application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.remote.tracing.Status;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class e1_ParameterizedTesting_Calculator
{



    @ParameterizedTest//TestDatasi kabul eden @Test demektir
    @ValueSource(ints = {1,2})//testdata kendisidir
    @Tag("isEven_Int")
    //List<Integer> intList= new Arraylist<>();
    //9 parametremiz tet methodumuzu 9 defa calsitirir
    //Her calismada 1 sonraki testdata kullanilir
    public void testDigitIfItIsEven_viaParameterizedTest(int i)
    {
        CalculatorProgram cal=new CalculatorProgram();
        assertTrue(cal.isEven(i));

       /*
        assertTrue(cal.isEven(1));
        assertTrue(cal.isEven(2));
        assertTrue(cal.isEven(3));
        assertTrue(cal.isEven(4));
        assertTrue(cal.isEven(5));
       */

    }


    //JAVA'DAKI OVERLOADING OZELLIGI VAR
    @ParameterizedTest
    @ValueSource(doubles = {1.0,2.0,3.0,4.0,5,6,7,8,9})
    public void testDigitIfItIsEven_viaParameterizedTest(double i)
    {
        CalculatorProgram cal=new CalculatorProgram();
        assertTrue(cal.isEven(i));

    }


    @ParameterizedTest
    @CsvSource(
            {
                    "3,7,1,21", //sayi1:3 sayi2:7 ebob:1 ekok:21===>testdata1
                    "6,8,2,24"

            }
            //javada nested/icice array konusu
            //int[][] intArray1={{1,2,3},{4,5,6},{7,8,9}};
            //bu test methodu 2 kez doner
    )
    public void testEbobEkok(int i1, int i2, int i3, int i4)
    {
        int[] ebob_ekok_result_array=CalculatorProgram.ebob_ekok_bulma(i1,i2);
        System.out.println("ebob_ekok_result_array[0] = " + ebob_ekok_result_array[0]);//arrayin ilk elemani ebob:1
        System.out.println("ebob_ekok_result_array[1] = " + ebob_ekok_result_array[1]);

        assertEquals(i3,ebob_ekok_result_array[0]);//1 1'e equals ise pass
        assertEquals(i4,ebob_ekok_result_array[1]);
    }


    @ParameterizedTest
    @CsvSource(value={
                    "3|7|1|21",
                    "6|8|2|24",}, delimiter = '|'
    )
    public void test2EbobEkok(int i1, int i2, int i3, int i4)
    {
        int[] ebob_ekok_result_array=CalculatorProgram.ebob_ekok_bulma(i1,i2);
        System.out.println("ebob_ekok_result_array[0] = " + ebob_ekok_result_array[0]);
        System.out.println("ebob_ekok_result_array[1] = " + ebob_ekok_result_array[1]);

        assertEquals(i3,ebob_ekok_result_array[0]);
        assertEquals(i4,ebob_ekok_result_array[1]);

    }



    @ParameterizedTest
    @CsvSource(value =
                        {"NULL",
                        " abc",
                         "def"
                        }
     , nullValues = "NULL")
    void customNullArgument(String title)
    {
        System.out.println(title);
        assertNull(title);
    }



}
