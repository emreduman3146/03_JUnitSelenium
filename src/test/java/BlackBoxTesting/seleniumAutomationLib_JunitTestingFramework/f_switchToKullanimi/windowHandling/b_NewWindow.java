package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.windowHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class b_NewWindow
{
    static WebElement windowButton;

    @BeforeAll
    static void setUp()
    {
        getDriver().get("https://demoqa.com/browser-windows");

        windowButton=getDriver().findElement(By.id("windowButton"));
        windowButton.click();

        try {
            WebElement text = getDriver().findElement(By.id("sampleHeading"));
            System.out.println(text.getText());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void _switchTo_window_with_foreach()
    {

        System.out.println("WINDOWS HANDLING BASLIYOR :)");


            //Get handles of the windows
            String mainWindowHandle = getDriver().getWindowHandle();//Return type of getWindowHandle() is String
            System.out.println("mainWindowHandle = " + mainWindowHandle);

            Set<String> allWindowHandles = getDriver().getWindowHandles();//return type of getWindowHandles() is Set<String>
            for(String s:allWindowHandles)
                System.out.println(s);


            for (String siradakiWindow:allWindowHandles)
            {
                if (!mainWindowHandle.equalsIgnoreCase(siradakiWindow))
                {
                    getDriver().switchTo().window(siradakiWindow);//child window'a switch ediyoruz.

                    WebElement text = getDriver().findElement(By.id("sampleHeading"));
                    System.out.println("Heading of child window is " + text.getText());
                }

            }

        }

        //ILK TEST METHODU ILE AYNI SENARYO, JAVA KODLARI FARKLI

    @Test
    void _switchTo_window_with_iterator()
    {


        System.out.println("WINDOWS HANDLING BASLIYOR :)");


        //Get handles of the windows
        String mainWindowHandle = getDriver().getWindowHandle();//Return type of getWindowHandle() is String
        System.out.println("mainWindowHandle = " + mainWindowHandle);

        Set<String> allWindowHandles = getDriver().getWindowHandles();//return type of getWindowHandles() is Set<String>
        for(String s:allWindowHandles)
            System.out.println(s);


        //ILK METHOD'TA FOREACH LOOP KULLANARAL WINDOWLARIN ID'ERINI COMPARE ETTIK
        //ESIT DEGILSE SWITCH_TO YAP DEDIK


        //Elimizdeki Set'i al tek tek gezilebilir bir hale cevir
        Iterator<String> iterator = allWindowHandles.iterator();


        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext())//sirada bir deger varsa true/ yoksa false
        {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);//child window'a switch ediyoruz.

                WebElement text = getDriver().findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }


    }


    //ODEV IKI JAVA COLLECTION OLAN SET'IN ELEMANLARININ NASIL GEZILECEGININ FARKLI FARKLI YOLLARI BURADA
    // ->https://www.geeksforgeeks.org/how-to-get-elements-by-index-from-hashset-in-java/
    //LINK'E GIT  VE ORADAKI KODLARI KENDI PC'INDE DENE
    //IHTIYAC GORUYORSAN-> LIST - SET- QUEUE - MAP KONULARINI TEKRAR ET
    //MULAKATTA JAVA SORULARINDAN BIRISI KESINLIKLE COLLECTION'DIR
}
