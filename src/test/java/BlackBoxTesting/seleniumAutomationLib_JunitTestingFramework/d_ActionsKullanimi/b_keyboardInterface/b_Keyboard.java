package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.b_keyboardInterface;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


//Bu class bir onceki class ile ayni isi yapar
public class b_Keyboard
{

    static Actions actions;
    @BeforeAll
    static void setUp()
    {
        getDriver().get("https://demoqa.com/text-box");
        actions= new Actions(getDriver());
    }



    @Test
    void _keyDown_keyUp()
    {
        WebElement fullName = getDriver().findElement(By.id("userName"));
        fullName.sendKeys("Software Developer In Test");

        WebElement email=getDriver().findElement(By.id("userEmail"));
        email.sendKeys("QA@engineer.com");

        WebElement currentAddress=getDriver().findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Istanbul");


        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();


        WebElement permanentAddress=getDriver().findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));



    }

    @AfterAll
    static void tearDown()
    {
        getDriver().quit();
    }


}
