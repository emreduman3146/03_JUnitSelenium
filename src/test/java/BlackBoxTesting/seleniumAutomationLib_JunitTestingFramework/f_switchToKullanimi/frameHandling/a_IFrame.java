package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.frameHandling;

import com.beust.ah.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_IFrame {

    static Actions actions;//Actions Classindan bir obje declare edilmis ama initialize edilmemis=null

    @BeforeAll
    static void  setUp()
    {
        getDriver().get("https://demoqa.com/frames");
        actions=new Actions(getDriver());
    }

    @Test
    void _switchTo_IFrame()
    {
        //bu webelement iframe'in icindedir.
        //driver iframe'in icine direk giremez ve oradaki elementi locate edemez
        //noSuchElementException hatasi firlatir
        //WebElement textInTheIframe=getDriver().findElement(By.xpath("(//h1[@id='sampleHeading' and text()='This is a sample page'])[1]"));
        //System.out.println(textInTheIframe.getText());

       List<WebElement> iframeElementleri=getDriver().findElements(By.xpath("//iframe"));
        for(WebElement element: iframeElementleri) {
            System.out.println(element);
            System.out.println(element.getText());
        }

        System.out.println("SWITCH TO IFRAME BY INDEX");
        getDriver().switchTo().frame(3);



        WebElement frame1Heading= getDriver().findElement(By.id("sampleHeading"));
        String frame1Text=frame1Heading.getText();
        System.out.println(frame1Text);

        System.out.println("ANA WEBPAGE'E GERI DONMEK - SWITCH BACK");
        getDriver().switchTo().defaultContent();
        System.out.println(getDriver().findElement(By.xpath("//div[contains(text(),'Sample Iframe')]")).getText());


        System.out.println("SWITCH TO IFRAME BY ID/NAME");
        getDriver().switchTo().frame("frame1");

        frame1Heading= getDriver().findElement(By.id("sampleHeading"));
        frame1Text=frame1Heading.getText();
        System.out.println(frame1Text);


        System.out.println("ANA WEBPAGE'E GERI DONMEK - SWITCH BACK");
        getDriver().switchTo().defaultContent();
        System.out.println(getDriver().findElement(By.xpath("//div[contains(text(),'Sample Iframe')]")).getText());



        System.out.println("SWITCH TO IFRAME BY WEBELEMENT");
        WebElement iframe01= getDriver().findElement(By.cssSelector("[width=\"500px\"][src=\"/sample\"]"));
        getDriver().switchTo().frame(iframe01);

        frame1Heading= getDriver().findElement(By.id("sampleHeading"));
        frame1Text=frame1Heading.getText();
        System.out.println(frame1Text);

    }


    @Test
    void _scroll_iframe()
    {

        System.out.println("SWITCH TO IFRAME BY ID/NAME");
        getDriver().switchTo().frame("frame2");

        WebElement frame1Heading= getDriver().findElement(By.id("sampleHeading"));
        String frame1Text=frame1Heading.getText();
        System.out.println(frame1Text);


        //ACTIONS CLASSI ILE IFRAME ICINDE SCROLL OLMUYOR
        //ILERLEYEN KONULARDA FARKLI SCROLL'LAR OGRENECEGIZ
        actions.scrollByAmount(5, 20).perform();




    }

}
