package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.a_mouseInterface;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class b_DragDrop
{

    static Actions actions;//null


    @BeforeAll
    static void setUp()
    {
        System.out.println("Selenium WebDriver'inin yetenegini Actions classi ile genisletelim");
        actions=new Actions(getDriver());
    }

    @Test
    void _clickAndHold()
    {
        getDriver().get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

        WebElement letterA = getDriver().findElement(By.xpath("//li[text()='A']"));

        //actions.moveToElement(letterA).clickAndHold().perform();
        //actions.clickAndHold(letterA).perform();
        actions.clickAndHold(letterA).moveByOffset(200, 200).perform();


        //PARMAGINI SOL MOUSE TUSUNDAN CEK
        actions.release().perform();


        /*
        The clickAndHold() method is used to left-clicking on an element and holds it
        without releasing the left button of the mouse
         */

        /*
        The release() method is used to release or to drop an element from the mouse.
        It can release the left mouse button on a web element.
         */

    }

    @Test
    void _clickAndHold2()
    {
        getDriver().get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

        WebElement letterA = getDriver().findElement(By.xpath("//li[text()='A']"));
        WebElement letterD = getDriver().findElement(By.xpath("//li[text()='D']"));


        actions.moveToElement(letterA);
        actions.clickAndHold();
        actions.moveToElement(letterD);
        actions.release();//parmagimi sol mouse tusundan cek
        actions.perform();//yukaridaki tum emirleri perform et



    }


    @Test
    void _dragAndDrop()//surukle ve birak
    {
        getDriver().get("https://selenium08.blogspot.com/2020/01/drag-me.html");

        WebElement kaydirilanElement = getDriver().findElement(By.id("draggable"));

        actions.dragAndDropBy(kaydirilanElement, 300, 200);

        //build() methodu ile istedigim actionalri depoladim
       // Action actionToBuild= actions.build();

       // actionToBuild.perform();


       // actions.build().perform();

        actions.perform();

        /*
        The dragAndDrop() method is used to drag an element on to the location of another target element and drop it.
        We need to pass source element and target element to dragAndDrop() method of actions class
         where the source element will be dragged and dropped.
         */

    }


    @Test
    void _dragAndDrop2()
    {

        getDriver().get("https://selenium08.blogspot.com/2020/01/drag-drop.html");

        WebElement kaydirilanElement = getDriver().findElement(By.id("draggable"));
        WebElement hedefElement = getDriver().findElement(By.id("droppable"));


        actions.dragAndDrop(kaydirilanElement, hedefElement);
        actions.build().perform();

        System.out.println("Drag and drop action has been performed successfully");

    }


    @Test
    void _dragAndDropBy()
    {

        String URL = "https://selenium08.blogspot.com/2020/01/drag-me.html";
        getDriver().get(URL);

        WebElement elementim = getDriver().findElement(By.id("draggable"));

        actions.dragAndDropBy(elementim, 200, 150);
        actions.build().perform();

        /*
        This method accepts three input parameters: target WebElement that has to be dragged.
        xOffset is an input parameter that represents the amount of offset to be moved along the x-axis.
        yOffset is an input parameter that represents the amount of offset to be moved along the y-axis.
         */
    }


    @Test
    void _dragAndDropBy2()
    {

        String URL = "https://jqueryui.com/resources/demos/resizable/default.html";
        getDriver().get(URL);

        WebElement resizable = getDriver().findElement(By.cssSelector("[style=\"z-index: 90;\"]+div+div"));

        actions.dragAndDropBy(resizable, 200, 150);
        actions.build().perform();

        /*
        This method accepts three input parameters: target WebElement that has to be dragged.
        xOffset is an input parameter that represents the amount of offset to be moved along the x-axis.
        yOffset is an input parameter that represents the amount of offset to be moved along the y-axis.
         */
    }

    @AfterAll
    static void tearDown()
    {
        //getDriver().close();
    }
}
