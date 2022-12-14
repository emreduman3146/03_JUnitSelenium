package whiteBoxTesting.Application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class g1_ConditionalTesting
{

    @Test
    @EnabledOnOs(value = {OS.WINDOWS, OS.MAC})
    public void enableThisTestMethod_ForWindowsAndMacPC()
    {
        System.out.println("Selenium ile test yazdigimizi dusunelim" +
                "database'e yeni yuklenen urunlerin fiyatlarini kontrol eden" +
                "bir UI Automation kodu/testi yazdik" +
                "ve bu testin sadece belli OS lerde calismasini saglayabiliriz");
    }



    @Test
    @DisabledOnOs(value = { OS.MAC})
    public void disableThisTestMethod_ForMacPC()
    {
        System.out.println("Bu test methodu mac pclerde run edilemez");
    }



    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max= JRE.JAVA_19)
    public void enableThisTestMethod_from11to19Version()
    {
        System.out.println("Bu test methodu JAVA 11-19 Arasi versionda run edilebilir");
    }


    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max= JRE.JAVA_11)//
    public void disableThisTestMethod_ForJava19()
    {
        System.out.println("Bu test methodu java 8-11 arasi versionlarda calismaz");
    }


}
