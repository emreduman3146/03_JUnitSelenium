package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.g_PopUpHandling.BootstrapAlert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class BootstrapAlertHandling
{
    @Test
    void kayitFormu_girisYapFormu_esnasindaCikan_alert()
    {
        getDriver().get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");

        WebElement success01=getDriver().findElement(By.xpath("//*[.='Autoclosable Success Message']"));
        success01.click();

        WebElement successAlert=getDriver().findElement(By.xpath("//*[contains(text(),'Autoclosable Success Message')]"));
        System.out.println("successAlert.getText() = " + successAlert.getText());


    }
}
