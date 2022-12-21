package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.b_keyboardInterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class a_Keyboard
{
    static Actions actions;


    @BeforeAll
    static void setUp()
    {
        System.out.println("Selenium WebDriver'inin yetenegini Actions classi ile genisletelim");
        actions=new Actions(getDriver());
    }

    @Test
    void _sendKeys()
    {
        getDriver().get("https://www.google.com");

        WebElement searchBox=getDriver().findElement(By.name("q"));

        //searchBox.sendKeys("facebook",".com","     ");
        //Kullanim1
        actions.sendKeys(searchBox,"facebook",".com","   ").perform();
        actions.sendKeys("\ue007").perform();
       // actions.sendKeys(Keys.ENTER).perform();


        //Kullanim2
       // actions.sendKeys(searchBox, "facebook",Keys.ENTER).perform();


        /*
        The sendKeys() method is used to type in alphanumeric
        and special character keys into the WebElement such as textarea, textbox, and so on.
         */
    }

    @Test
    void _sendKeys2_toUnderstand_WhyWeShouldUse_ActionsClass()
    {
        getDriver().get("https://demoqa.com/text-box");

        WebElement fullName = getDriver().findElement(By.id("userName"));
        fullName.sendKeys("Software Developer In Test");

        WebElement email=getDriver().findElement(By.id("userEmail"));
        email.sendKeys("QA@engineer.com");

        WebElement currentAddress=getDriver().findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Istanbul");


        //WebElementAdi.sendKeys()
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("A");
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("C");

        //Press the TAB Key to Switch Focus to Permanent Address
        currentAddress.sendKeys(Keys.TAB);

        WebElement permanentAddress=getDriver().findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(Keys.CONTROL);
        permanentAddress.sendKeys("V");

        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


    }

    @Test
    void _keyDown_keyUp()
    {
        getDriver().get("https://demoqa.com/text-box");

        WebElement fullName = getDriver().findElement(By.id("userName"));
        fullName.sendKeys("Software Developer In Test");

        WebElement email=getDriver().findElement(By.id("userEmail"));
        email.sendKeys("QA@engineer.com");

        WebElement currentAddress=getDriver().findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Istanbul");


        // Select the Current Address using CTRL + A
        actions.keyDown(Keys.CONTROL);//mac:command
        actions.sendKeys("a");//ctrl+a
        actions.keyUp(Keys.CONTROL);//ctrl+a
        actions.build().perform();

        // Copy the Current Address using CTRL + C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        //Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        //Paste the Address in the Permanent Address field using CTRL + V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();


        WebElement permanentAddress=getDriver().findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));


         /*
            The keyDown() method is used to perform the action of pressing and holding a key.
            The keys can be Shift, Ctrl, and Alt keys.
         */

        /*
        The keyUp() method is used to release a key that has been already pressed using keyDown() method.
         */
    }


}
