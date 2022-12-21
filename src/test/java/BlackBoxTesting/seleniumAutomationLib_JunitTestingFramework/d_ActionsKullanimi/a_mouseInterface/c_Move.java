package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.a_mouseInterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class c_Move
{
    static Actions actions;


    @BeforeAll
    static void setUp()
    {
        System.out.println("Selenium WebDriver'inin yetenegini Actions classi ile genisletelim");
        actions=new Actions(getDriver());
    }


    @Test
    void _moveByOffset() throws InterruptedException {
        getDriver().get("https://www.google.com");

        WebElement gmail = getDriver().findElement(By.xpath("//a[text()='Gmail']"));

        int getX = gmail.getLocation().getX();
        System.out.println("getX = " + getX);
        int getY = gmail.getLocation().getY();
        System.out.println("getY = " + getY);

        actions.moveByOffset(getX+60, getY+5).click();


        actions.build().perform();
        // actions.perform();


        /*
            moveByOffset() method is used to move the mouse cursor from point (0, 0)
            to point of Gmail element.
            Note that the initial position of the mouse cursor is (0, 0).
         */


    }


    @Test
    void _moveToElement_pause()
    {
        // The moveToElement() method is used to move the mouse cursor to the center of a specified element on the web page.
        // The web element is also scrolled into view.

        getDriver().get("https://www.trendyol.com/");


        //WebDriverWait - WAIT
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        By locator=By.xpath("//div[@class='country-select']//select");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        //SELECT DROPDOWN
        WebElement countryDropdown=getDriver().findElement(locator);
        Select select=new Select(countryDropdown);
        select.selectByVisibleText("Turkey");

        //ACTIONS MOVETOELEMENT()
        WebElement selectButton=getDriver().findElement(By.xpath("//button[text()=\"Select\"]"));
        //selectButton.click();
        actions.moveToElement(selectButton).click().build().perform();


        //ACTIONS MOVETOELEMENT() - scrolling
        WebElement oneCikanlar_ilkSecenek=getDriver().findElement(By.xpath("(//div[@class='styles-module_slider__o0fqa'])[2]/child::div[1]"));

        //takeAScreenShot();
        //oneCikanlar_ilkSecenek.click();

        // actions.moveToElement(oneCikanlar_ilkSecenek);
        actions.moveToElement(oneCikanlar_ilkSecenek,500,0);
        actions.pause(1000); //1 saniye
        actions.pause(Duration.ofSeconds(10));//10 saniye pause ederim
        //takeAScreenhot();
        actions.click().build().perform();

        /*
        This method is used to move the mouse cursor from the top-left corner of the web element
         to an offset position on the web page.
         The element is scrolled into view
         */


    }


}
