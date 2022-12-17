package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.c_waits;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.setDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class a_ImplicitWait {


    /*
    Thread.sleep(10); -> PC'deki thread'in calismasini 10 saniye durdurur.
    Siradaki Java kodlari cpu'ya gonderilmez.
    O sirada yavas calisan websitesi kendisine gelmis olur
    JAVA HARD WAITING
     */

    /*
      getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      Bu kod Driver'i 10 saniyeye kadar bekletir.
      Eger bir sonraki selenium kodlarinin calismasi icin bir engel yok drive rbeklemeyi keser.
      Thread.sleep'e gore akilli beklemedir
     */




    @RepeatedTest(5)
    public void test01() throws InterruptedException
    {
        //getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        getDriver().get("https://www.instagram.com/");


        assertTrue(getDriver().getTitle().equals("Instagram"));

        System.out.println("Navigated to the URL!");

         implicitlyWait(3);//sayfa yuklenmesini de webElementlerin yuklenmesini de bekleyebilir

        //W3C protokolunun dili olan JSON Formatindaki kodun chrome gidip action yaptirmasi
        getDriver().findElement(By.name("username")).sendKeys("automation@gmail.com");
        getDriver().findElement(By.xpath("//*[@name='password']")).sendKeys("automationUItesting");

        getDriver().findElement(By.xpath("//div[text()='Log in']")).click();
        getDriver().findElement(By.id("slfErrorAlert")).isDisplayed();//kirmizi uyari mesaji

        //getDriver().close();
        getDriver().quit();
        setDriver(null);


    }


    public void implicitlyWait(int seconds)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }


}