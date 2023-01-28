package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JS01_BasicSeleniumCommandsAlternatives
{

   static WebDriver driver;
   static String url="https://www.google.com";
   static JavascriptExecutor jse;


   @BeforeAll
    static void initialize_driver_and_JSExecutor() throws InterruptedException {
       driver=WebDriverManager.chromedriver().avoidShutdownHook().create();
       jse= (JavascriptExecutor) driver;

       //NAVIGATE TO URL
       String jsScript="window.location='"+ url +"'";
       jse.executeScript(jsScript);


   }

   @Test
   @Order(1)
    void jse_goToURL_getTitle_getURL_reloadPage()
   {


       //getTitle()
       String title= (String)jse.executeScript("return document.title;");
       System.out.println(title);
       Object title2= jse.executeScript("return document.title;");
       System.out.println(title2);


       //getURL()
       System.out.println(jse.executeScript("return document.URL;"));//Object tipi
       System.out.println(jse.executeScript("return document.URL;").toString());//String tipi
       System.out.println((String)jse.executeScript("return document.URL;"));//String tipi


       //refresh page
       jse.executeScript("location.reload();");

   }

    @Test
    @Order(2)
    void jse_locateElement_sendKeys_getText_click()  {

       //locate webElement - google arama motorunun locate ediyoruz

        //findElement() - findElements()
        WebElement googleAramaMotoru=  (WebElement)jse.executeScript("return document.getElementsByName('q')[0];");

        //List<WebElement> ismiQ_olan_ElemetlerinListesi = (List<WebElement>) jse.executeScript("return document.getElementsByName('q');");


        //sendKeys()
        jse.executeScript("arguments[0].value='Selenium';", googleAramaMotoru);


        //getText()
        String value=jse.executeScript("return arguments[0].value",googleAramaMotoru).toString();
        System.out.println(value);

        //locate search_button
        WebElement searchButton= (WebElement) jse.executeScript("return document.querySelector('input[name=btnK]')");
        jse.executeScript("arguments[0].click();",searchButton);



        //document.getElementById()-sadece 1 tane element return eder
        //document.getElementsByClassName()-birden fazla sonuc return eder
        //document.querySelectorAll()-1den fazla sonuc return eder

    }

}
