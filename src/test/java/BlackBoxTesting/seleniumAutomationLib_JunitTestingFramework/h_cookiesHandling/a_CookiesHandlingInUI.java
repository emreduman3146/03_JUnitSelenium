package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.h_cookiesHandling;


import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_CookiesHandlingInUI
{
    @BeforeAll
    static void  navigateToUrl()
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7000));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

        getDriver().get("https://www.hepsiburada.com/");
    }

    @Test
    void handleCookiesPopUp_inUI()
    {
        //ALTTAN CIKAN COOKIES POPUP'ini LOCAE ET
        var cookiesPopUp=getDriver().findElement(By.id("onetrust-banner-sdk"));

        if(cookiesPopUp.isDisplayed())
        {
            //CEREZ AYARLARI BUTTON'UNA TIKLA
            getDriver().findElement(By.id("onetrust-pc-btn-handler")).click();

            //TOOGLE'a tikla
            getDriver().findElement(By.xpath("//*[@id=\"ot-pc-content\"]//span[1]")).click();

            //CEREZ AYARLARIMI KAYDET
            getDriver().findElement(By.xpath("//button[.=\"Çerez ayarlarımı kaydet\"]")).click();

        }

        Assert.assertTrue( cookiesPopUp.getAttribute("style").contains("hidden;"));




    }
}
