package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JS02_Scrolling {

    FirefoxDriver firefoxDriver;
    JavascriptExecutor jse_firefox;

    @BeforeEach
    void setUp()
    {
        firefoxDriver= new FirefoxDriver();
        jse_firefox=firefoxDriver;

    }



    @Test
    @Order(1)
    void scrollToElement() throws InterruptedException {

        jse_firefox.executeScript("window.location='https://youtube.com'");


        String script = "document.body.style.backgroundColor = 'red';";
        jse_firefox.executeScript(script);

        //Vertical+horizantol scroll by  pixels
        jse_firefox.executeScript("window.scrollBy(5,600)");

        jse_firefox.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        jse_firefox.executeScript("window.scrollBy(document.body.scrollWidth,0)");


        //  jse_firefox.executeScript("document.getElementById('text-8').scrollIntoView(true);");

    }
}
