package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.windowHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_NewTab
{
    static WebElement tabButton;

    @BeforeAll
    static void setUp()
    {
        getDriver().get("https://demoqa.com/browser-windows");

        tabButton =getDriver().findElement(By.id("tabButton"));
        tabButton.click();

        //muhtemelen bir hata alacagim oyuzden try catch kullan akilli ol
        try {
            WebElement text = getDriver().findElement(By.id("sampleHeading"));
            System.out.println(text.getText());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void _switchTo_newTab_with_foreach()
    {

        System.out.println("TAB HANDLING BASLIYOR :)");


        //Get handles of the windows
        String mainWindowHandle = getDriver().getWindowHandle();//Return type of getWindowHandle() is String
        System.out.println("mainWindowHandle = " + mainWindowHandle);



        //JAVA-COLLECTIONS(LIST-SET-QUEUE) - MAP
       // [ [CDwindow-C46D97E6B71B718CF1D094EA313F652C], [CDwindow-C46D97E6B71B718CF1D094vwhrvbiwrvbiwrbviwrbvrw]]
        Set<String> allWindowHandles = getDriver().getWindowHandles();//return type of getWindowHandles() is Set<String>

        for(String s:allWindowHandles)
            System.out.println(s);




        //FOREACH LOOP
        //DRIVER'IN BULUNDUG TAB'IN NUMARASI ILE GITMEK ISTEDGIM TABIN NUMARASI BIRBIRINE ESITM OLMADIGI ZAMAN(KI HICBIR ZAMAN AYNI OLMAZ)
        //  IF BLOCK'UNUN ICINE GIR
        for (String siradakiWindow:allWindowHandles)
        {
            if (!mainWindowHandle.equalsIgnoreCase(siradakiWindow))
            {
                //ACILAN IKINCI TABIN ICINE DRIVERIMI SWITCH ET.
                getDriver().switchTo().window(siradakiWindow);//child window'a switch ediyoruz.

                WebElement text = getDriver().findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }

        }

    }


}
