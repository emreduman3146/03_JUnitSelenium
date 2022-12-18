package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.b_keyboardInterface;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


//Bu class bir onceki class ile ayni isi yapar
public class c_KeyboardScrolling
{

    static Actions actions;
    @BeforeAll
    static void setUp()
    {
        getDriver().get("https://demoqa.com/text-box");
        actions= new Actions(getDriver());
    }



    @Test
    void _keyDown_keyUp() throws InterruptedException {
        WebElement fullName = getDriver().findElement(By.id("userName"));
        fullName.sendKeys("Software Developer In Test");

        WebElement email=getDriver().findElement(By.id("userEmail"));
        email.sendKeys("QA@engineer.com");

        WebElement currentAddress=getDriver().findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Istanbul");


        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).
                build().
                perform();




    }

    @AfterAll
    static void tearDown()
    {
        //getDriver().quit();
    }


}
