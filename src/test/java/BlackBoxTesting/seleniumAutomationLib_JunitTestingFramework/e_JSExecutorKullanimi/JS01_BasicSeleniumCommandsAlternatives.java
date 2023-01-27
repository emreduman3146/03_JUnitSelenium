package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class JS01_BasicSeleniumCommandsAlternatives
{

    static WebDriver driver;
    static JavascriptExecutor jse_driver;

    @BeforeAll
    static void initialize_Driver_And_JSE(){

        driver= WebDriverManager.chromedriver().avoidShutdownHook().create();
         jse_driver= (JavascriptExecutor) driver;




    }



    @Test
    @Order(1)
    void jse_goToUrL_getTitle_getURL_reloadThePage() throws InterruptedException {
        java.lang.String url = "https://www.google.com";

        //NAVIGATE TO THE URL
        //driver.get(url);
        //driver.navigate().to(url);
        jse_driver.executeScript("window.location= '"+url+"'");


        //getTitle()
        String title = jse_driver.executeScript("return document.title;").toString();
        System.out.println(title);

        //getURL()
        String domain_address = jse_driver.executeScript("return document.domain;").toString();
        System.out.println(domain_address);

        String url_address = jse_driver.executeScript("return document.URL;").toString();
        System.out.println(url_address);


        //reload the page
        ((JavascriptExecutor) driver).executeScript("location.reload();");


    }

    @Test
    @Order(2)
    void jse_locateElements_sendkeys_getText_click() throws InterruptedException {


        //LOCATE  MULTIPLE WEBELEMENT
        WebElement searchBar = (WebElement) jse_driver.executeScript("return document.getElementsByName('q')[0];");
        //document.getElementById() an element
        //document.getElementsByClassName()
        //document.getElementsByTagName()
        //document.querySelectorAll()->cssSelector



        //sendkeys()
        jse_driver.executeScript("arguments[0].value='Selenium';",searchBar);

        jse_driver.executeScript("return document.getElementsByName('q')[0].value+='4.7';");


        //getText()
        String text = (String) jse_driver.executeScript("return arguments[0].value", searchBar);
        System.out.println(text);



        //lOCATE A webelement
        //document.querySelector() ->cssSelector
        WebElement searchButton = (WebElement) jse_driver.executeScript("return document.querySelector('input[name=btnK]')");

        //Click element
        jse_driver.executeScript("arguments[0].click();", searchButton);






    }


}
