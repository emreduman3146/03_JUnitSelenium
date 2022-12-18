package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits.conditionalWaits;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class a_PageLoadTimeout
{


    @Test
    void _pageLoadTimeout()
    {

        //Sayfa yuklenene kadar bekle
        //Max 5 SN.'ye kadar bekle
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        getDriver().get("https://www.instagram.com/");

        //webelementlerin yuklenmesini beklemez
        //sayfa yuklendigi an, artik beklemiyorum, webelementler yuklenmis mi yuklenmemis mi beni ilgilendirmez.

        assertTrue(getDriver().getTitle().equals("Instagram"));

        System.out.println("Navigated to the URL!");
    }

}
