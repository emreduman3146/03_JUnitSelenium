package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JS03_waits_DOM
{
    //DOM=DOCUMENT.OBJECT.MANIPULATION

    static EdgeDriver edgeDriver;
    static String url="https://www.google.com";
    //static JavascriptExecutor jse;


    @BeforeAll
    static void initialize_driver_and_JSExecutor() throws InterruptedException {
        edgeDriver=new EdgeDriver();

        //jse=firefox_driver;

        //NAVIGATE TO URL
        String jsScript="window.location='"+ url +"'";
        edgeDriver.executeScript(jsScript);
        Thread.sleep(3000);


    }

    @Test
    void changeSytle()
    {
        //verilen sure kadar bekler ve function in icindeki gorevi 5 saniye sonra gerceklestirir
        edgeDriver.executeScript("setTimeout(function(){},5000);");
        edgeDriver.executeScript("document.body.style.backgroundColor='red'") ;


        edgeDriver.executeScript("setTimeout(function(){document.body.style.backgroundColor='yellow'},5000);");

        edgeDriver.executeAsyncScript("setTimeout(arguments[0],5000)");

        edgeDriver.executeScript("alert('Bu benim alertim')");
    }


}
