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
    void _keysChord()
    {
        WebElement fullName = getDriver().findElement(By.id("userName"));
        fullName.sendKeys("Software Developer In Test");

        WebElement email=getDriver().findElement(By.id("userEmail"));
        email.sendKeys("QA@engineer.com");

        WebElement currentAddress=getDriver().findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Istanbul");

        WebElement permanentAddress=getDriver().findElement(By.id("permanentAddress"));



/*
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(Keys.TAB).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
*/

        //Actions classini kullanmadan normal yollarla klavye islemlerini nasil handle edebliriz?
        //Keys.chord() methodu 1'den fazla klavye komutu alabilir
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"c"));
        permanentAddress.sendKeys(Keys.chord(Keys.CONTROL,"v"));

        //ASSERTION KIYASLAMA-DOGRULAMA
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));



    }

    @AfterAll
    static void tearDown()
    {
        //getDriver().quit();
    }


}
