package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.mouseInterface;

import com.beust.ah.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_Click {

    //scope:global
    static Actions actions;//null


    @BeforeAll
    static void setUp() {
        System.out.println("Selenium WebDriver'inin yetenegini Actions classi ile genisletelim");

        actions=new Actions(getDriver());//initialized eedilmis

        getDriver().get("https://demoqa.com/buttons");

    }

    @Test
    void _click() {
        WebElement clickMeButton = getDriver().findElement(By.xpath("//*[text()='Click Me']"));
        //clickMeButton.click();

        //actions.click(clickMeButton);//mouse'daki sol tiklama

        //actions.click(clickMeButton).perform();

    }


    @Test
    void _click2() {
        WebElement clickMeButton = getDriver().findElement(By.xpath("//*[text()='Click Me']"));


        //kullanim1
        //actions.moveToElement(clickMeButton).click().perform();

        //kullanim2
        // perform()
        // This method is used to perform a sequence of actions without calling build() first.
        //actions.moveToElement(clickMeButton);//1 tane action tutuyor: moveToElement()
        //actions.click();//artik bu mor actions objesi 2 tane action tutuyor: moveToElement+click
        //actions.perform();//artik bu mor actions objesi 3 tane action tutuyor: moveToElement+click+perform



        //Kullanim3
        //The build() method of action interface generates a composite action that contains all the actions gathered
        // which are ready to be performed. All actions to be performed are specified by method calls.

        //yeni bir obje- icinde 1 tane action barindirir
        //Actions icindeEmirBulunduranAction=actions.moveToElement(clickMeButton);

        //Actions moveTo_click=icindeEmirBulunduranAction.click();

        //moveTo_click.perform();



        //Kullanim4
       // Action act=actions.moveToElement(clickMeButton).click().build();
        //act.perform();

        //Kullanim5
        actions.moveToElement(clickMeButton).click().build().perform();





    }



    @Test
    void _contextClick() {


        WebElement rightClickMeButton = getDriver().findElement(By.xpath("//*[text()='Right Click Me']"));

       //ne yapmak istiyorum, sag click yapmak istiyorum
        actions.contextClick(rightClickMeButton).perform();
    }

    @Test
    void _doubleClick()
    {
        WebElement doubleClickMeButton=getDriver().findElement(By.xpath("//*[text()='Double Click Me']"));

       // actions.doubleClick(doubleClickMeButton).perform();

        actions.moveToElement(doubleClickMeButton).doubleClick().build().perform();
    }


    @AfterAll
    static void tearDown()
    {
        //getDriver().close();
    }

}
