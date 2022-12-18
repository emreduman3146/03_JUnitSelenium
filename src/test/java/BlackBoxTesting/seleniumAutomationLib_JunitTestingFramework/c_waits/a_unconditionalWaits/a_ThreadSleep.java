package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits.a_unconditionalWaits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class a_ThreadSleep
{


    @Test
    void _driverWait() throws InterruptedException
    {
        getDriver().get("https://www.instagram.com/");//compiler->01010101

        assertTrue(getDriver().getTitle().equals("Instagram"));

        System.out.println("Navigated to the URL!");

        //Bunu bilin ama hicbir zaman kullanmayin.
        //Automation mantigina aykiri bir kullanimdir.
        //JAVA Hard Wait olarak anilir
        Thread.sleep(1000);

        //W3C protokolunun dili olan JSON Formatindaki kodun chrome gidip action yaptirmasi
        getDriver().findElement(By.name("username")).sendKeys("automation@gmail.com");
        getDriver().findElement(By.xpath("//*[@name='password']")).sendKeys("automationUItesting");

    }
}
