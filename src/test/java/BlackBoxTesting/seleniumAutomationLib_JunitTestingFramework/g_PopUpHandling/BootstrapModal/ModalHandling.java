package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.g_PopUpHandling.BootstrapModal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class ModalHandling
{

    @Test
    void kampanyaPopUplari_uyelikPopuplari()
    {
        getDriver().get("https://demoqa.com/modal-dialogs");
        WebElement smallModalButton =getDriver().findElement(By.id("showSmallModal"));
        smallModalButton.click();

        WebElement smallModalPopUp=getDriver().findElement(By.xpath("//*[@role='document']"));
        WebElement modalHeader=smallModalPopUp.findElement(By.xpath(".//*[@id='example-modal-sizes-title-sm']"));
        System.out.println("modalHeader.getText() = " + modalHeader.getText());

        WebElement modalBody=smallModalPopUp.findElement(By.xpath(".//*[@class='modal-body']"));
        System.out.println("modalBody.getText() = " + modalBody.getText());

        WebElement modalCloseButton=smallModalPopUp.findElement(By.xpath(".//*[@id='closeSmallModal']"));
        modalCloseButton.click();


    }
}
