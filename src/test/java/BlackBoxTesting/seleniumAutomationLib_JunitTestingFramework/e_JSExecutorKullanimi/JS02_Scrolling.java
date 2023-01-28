package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JS02_Scrolling
{
    static FirefoxDriver firefox_driver;
    static String url="https://www.amazon.com";
    //static JavascriptExecutor jse;


    @BeforeAll
    static void initialize_driver_and_JSExecutor() throws InterruptedException {
        firefox_driver=new FirefoxDriver();

        //jse=firefox_driver;

        //NAVIGATE TO URL
        String jsScript="window.location='"+ url +"'";
        firefox_driver.executeScript(jsScript);
        Thread.sleep(8000);


    }

    @Test
    @Order(1)
    void scrollToElement() throws InterruptedException {

        //horizontal-yatay  vertical-dikey
        firefox_driver.executeScript("window.scrollBy(100,500)");
        Thread.sleep(3000);
        firefox_driver.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        firefox_driver.executeScript("window.scrollBy(document.body.scrollWidth,0)");


        firefox_driver.executeScript("document.querySelector('div[class=navFooterColHead]:nth-child(1)').scrollIntoView(true)");
    }
}
