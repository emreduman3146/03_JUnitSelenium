package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits.conditionalWaits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.setDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class d_FluentWait
{


    @BeforeEach
    void before()
    {

        getDriver().get("https://www.instagram.com/");
        assertTrue(getDriver().getTitle().equals("Instagram"));
        System.out.println("Navigated to the URL!");


    }

    @RepeatedTest(5)
    public void _fluentWait() throws InterruptedException
    {

        //ANA AYARLAR

        //JAVA BILGISI: POLIMORPHISM VAR
        //Parent:Wait  child:FluentWait
        Wait wait = new FluentWait(getDriver())
                .withTimeout(Duration.ofMillis(5000))//max 5 seconds beklet driveri
                .pollingEvery(Duration.ofMillis(500))//Bu 5 saniye icinde de tolamda 10 tekrar yap
                .ignoring(Exception.class)//ne tur hata cikarsa ciksin, Exception bunlrin babasidir, yabni o hatayi yakala
                .withMessage("Fluent wait kullaniyorum");



        //Ayarlarin istedigin webELemente uygulanmasi
        WebElement username = (WebElement) wait.until
        (
            driver ->
            {
                return getDriver().findElement(By.name("username"));
            }

        );

        //WebElement ile action alma
        username.sendKeys("automation@gmail.com");

        getDriver().findElement(By.xpath("//*[@name='password']")).sendKeys("automationUItesting");
        getDriver().findElement(By.xpath("//div[text()='Log in']")).click();


        //Ayarlarin istedigin webELemente uygulanmasi
        WebElement uyariMesaji = (WebElement) wait.until(driver ->
        {
            return getDriver().findElement(By.id("slfErrorAlert"));
        });

        assertTrue(uyariMesaji.isDisplayed());

        //getDriver().close();
        getDriver().quit();
        setDriver(null);

    }
}
