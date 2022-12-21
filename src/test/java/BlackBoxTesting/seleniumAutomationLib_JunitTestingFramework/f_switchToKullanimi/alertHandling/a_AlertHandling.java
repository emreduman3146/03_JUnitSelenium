package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.alertHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_AlertHandling
{

    @BeforeAll
    static void setUp() {
        getDriver().get("https://demoqa.com/alerts");

    }

    @Test
    void notification_Accept() throws InterruptedException {


        //mavi button
        getDriver().findElement(By.id("alertButton")).click();

        //wait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        //Driver'imi switch et, nereye edeyim, alert'un icine et
        Alert alert = getDriver().switchTo().alert();

        String alertMessage = alert.getText();
        //You clicked a button

        System.out.println(alertMessage);


        alert.accept();
        //alert'un icindeki ok tusuna tikla demek

    }

    @Test
    void _promptAlert_SendKeys() {

        WebElement button = getDriver().findElement(By.id("promtButton"));
        button.click();

        Alert promptAlert = getDriver().switchTo().alert();


        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);


        promptAlert.sendKeys("alert'in icine sendkeys ile yazi gonderiyorum ve ok'a basiyorum");
        promptAlert.accept();//Cancel tusuna tiklar
        //promptAlert.dismiss();//Cancel tusuna tiklar


    }

    @Test
    void _confirmationAlert_Accept_Dismiss() {

        getDriver().findElement(By.id("confirmButton")).click();

        Alert confirmationAlert=getDriver().switchTo().alert();

        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);


        //confirmationAlert.accept();
        confirmationAlert.dismiss();

    }


    @Test
    void _unExpectedAlert() {

        try
        {
            getDriver().findElement(By.id("timerAlertButton")).click();

            WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(6));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert simpleAlert = getDriver().switchTo().alert();
            simpleAlert.accept();

            System.out.println("Unexpected alert accepted");
        }
        catch (Exception e)
        {
            System.out.println("unexpected alert not present");
        }

    }
}
