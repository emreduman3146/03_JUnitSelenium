package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.setDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class b_WebDriverWait
{

    @BeforeEach
    void before()
    {
        //chrome'un launch edillmesini  ve sayfanin load edilmesini bekle
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        getDriver().get("https://www.instagram.com/");
        assertTrue(getDriver().getTitle().equals("Instagram"));
        System.out.println("Navigated to the URL!");


    }

    @RepeatedTest(5)
    public void test01() throws InterruptedException
    {

        //username textbox gozukene kadar bekle, max 5 sn bekle
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        getDriver().findElement(By.name("username")).sendKeys("automation@gmail.com");
        getDriver().findElement(By.xpath("//*[@name='password']")).sendKeys("automationUItesting");

        //Login button'in clickable olana kadar bekler
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log in']")));
        getDriver().findElement(By.xpath("//div[text()='Log in']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slfErrorAlert")));
        getDriver().findElement(By.id("slfErrorAlert")).isDisplayed();//kirmizi uyari mesaji

        //getDriver().close();
        getDriver().quit();
        setDriver(null);

    }

}
