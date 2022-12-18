package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits.a_unconditionalWaits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class b_Wait
{


    @Test
    void _driverWait() throws InterruptedException {
        getDriver().get("https://www.instagram.com/");

        assertTrue(getDriver().getTitle().equals("Instagram"));

        System.out.println("Navigated to the URL!");


        //SELENIUM HARD WAIT
        synchronized (getDriver())
        {
            //bu satiri direk yazamayiz, ise yaramaz
            getDriver().wait(5000);

        }

        //W3C protokolunun dili olan JSON Formatindaki kodun chrome gidip action yaptirmasi
        getDriver().findElement(By.name("username")).sendKeys("automation@gmail.com");
        getDriver().findElement(By.xpath("//*[@name='password']")).sendKeys("automationUItesting");

    }
}
