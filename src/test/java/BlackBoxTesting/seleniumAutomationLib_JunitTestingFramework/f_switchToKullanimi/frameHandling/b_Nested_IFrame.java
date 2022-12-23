package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.frameHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class b_Nested_IFrame
{

    @BeforeAll
    static void  setUp()
    {
        getDriver().get("https://demoqa.com/nestedframes");
    }

    @Test
    void _switchTo_nested_IFrame()
    {

        System.out.println("SWITCH TO IFRAME BY ID/NAME");
        getDriver().switchTo().frame("frame1");

        //PARENT IFRAME'E SWITCH YAP
        System.out.println(getDriver().findElement(By.tagName("body")).getText());


        //frame(index:0) == html'deki [index:1]
        //CHILD IFRAME' SWITCH YAP
        getDriver().switchTo().frame(0);
        System.out.println(getDriver().findElement(By.tagName("body")).getText());


        //PARENT IFRAME'E SWITCH YAP
        //getDriver().switchTo().parentFrame();
        //System.out.println(getDriver().findElement(By.tagName("body")).getText());

        //YA DA DIREK WEBPAGE'E SWITCH BACK YAPMAK ISTIYORSAK
        getDriver().switchTo().defaultContent();
        System.out.println(getDriver().findElement(By.xpath("//div[contains(text(),'Sample Nested')]")).getText());







    }
}
