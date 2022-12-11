package whiteBoxTesting.Application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class e2_ParameterizedTesting_String
{


    StringManipulation str=new StringManipulation();


    @DisplayName("Parametre olarak gonderdigimiz string degerin tersini dogru ceviriyor mu?")
    @ParameterizedTest
    @CsvSource(
            {
            "HelloWorld!,!dlroWolleH",
            "Software_QA_Automation_Engineer,reenignE_noitamotuA_AQ_erawtfoS"
            }

    )
    // @NullAndEmptySource
    //bu test methodum 4 defa calisicak
    //2 tanesi normal string deger ile
    //1 tane null deger ile
    //1 tane "" bos deger ile
    void testReverseString(String normalString,String reversedString)
    {
        //test yazilirken kesinlikle sout ifadeleri silinir
        System.out.println("normalString = " + normalString);
        System.out.println("str.reverseString(normalString) = " + str.reverseString(normalString));


        assertEquals(reversedString,str.reverseString(normalString));
    }



    //Bu zamana kadar int double,String gibi params gonderdik
    //Hatta birden fazla params'i ayni anda da gonderdik
    //Peki ya null deger / "" bos deger gondermek istersem nasil olur?
    //cevabi asagida


    @ParameterizedTest
    @NullSource// parametre olarak "null" ifadesi gonderilir
    //String isim;//null
    //String soyisim=null;
    void testReverseString(String input)
    {
       // assertEquals(null,str.reverseString(input));

        assertNull(     str.reverseString(input)           );// parantezlerimin arasina null deger koyarsan pass ederim
        assertNull(null);

        //str.reverseString(input)==null
    }

    @ParameterizedTest
    @EmptySource
    //String isim="";
    void test2ReverseString(String input)
    {
        StringManipulation str=new StringManipulation();
        assertEquals("",str.reverseString(input));
        assertTrue(str.reverseString(input).length()==0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    //bu method 2 defa calisir
    //ilk null deger gider
    //2.de "" deger gider
    void test3ReverseString(String input)
    {
        StringManipulation str=new StringManipulation();
        assertEquals(input,str.reverseString(input));
    }



}
