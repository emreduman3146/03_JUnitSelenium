package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.management.ManagementFactory;

public class JS03_DOM {

    WebDriver edgeDriver;
    JavascriptExecutor jse_edge;

    @BeforeEach
    void setUp()
    {
        edgeDriver= WebDriverManager.edgedriver().create();
        jse_edge=(JavascriptExecutor)edgeDriver;

        jse_edge.executeScript("window.location='https://google.com'");

    }


    @Test
    void changeStyle() throws InterruptedException {
        jse_edge.executeScript("setTimeout(function(){}, 5000);");
        jse_edge.executeScript("document.body.style.backgroundColor = 'red'");


        jse_edge.executeScript("setTimeout(function(){document.body.style.backgroundColor = 'yellow'}, 5000);");

        jse_edge.executeAsyncScript("setTimeout(arguments[arguments.length - 1], 5000);");
        jse_edge.executeAsyncScript("setTimeout(arguments[0], 5000);");
        jse_edge.executeAsyncScript( "var callback = arguments[arguments.length - 1]; setTimeout(callback, 5000);");


        jse_edge.executeScript("alert('JSScriptExecutorOgreniyorum');");




    }


}
