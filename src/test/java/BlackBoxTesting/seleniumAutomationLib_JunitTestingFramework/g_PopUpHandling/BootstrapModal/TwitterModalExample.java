package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.g_PopUpHandling.BootstrapModal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class TwitterModalExample
{

    @Test
    void twitterLoginModal() throws InterruptedException {
        getDriver().get("https://twitter.com/i/flow/login");

        //wait'i tanimla
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        //wait'i kullan
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@autocomplete=\"username\"]")));

        WebElement signInModal=getDriver().findElement(By.xpath("//div[@aria-labelledby=\"modal-header\"]"));
        WebElement usernameTextbox=signInModal.findElement(By.xpath(".//input[@autocomplete=\"username\"]"));
        usernameTextbox.sendKeys("Software QA Engineer");

        WebElement nextButton=signInModal.findElement(By.xpath(".//*[.='Next']"));
        nextButton.click();


    }
}
