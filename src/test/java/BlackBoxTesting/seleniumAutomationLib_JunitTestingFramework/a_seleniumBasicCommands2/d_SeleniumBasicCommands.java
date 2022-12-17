package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;



@Epic("Selenium'daki temel methodlari ogrenmeye devam ediyoruz")
@Feature("BlackBoxTesting yapiyoruz")
@Tag("d_SeleniumBasicCommands")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class d_SeleniumBasicCommands {

    static WebElement emailBox,passwordBox,loginButton,warningMessage;

    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        getDriver().navigate().to("https://www.instagram.com/");
        System.out.println("Navigated to the URL!");

        Thread.sleep(3000);
        emailBox=getDriver().findElement(By.name("username"));
        passwordBox=getDriver().findElement(By.xpath("//*[@name='password']"));
        loginButton=getDriver().findElement(By.xpath("//div[text()='Log in']"));

        System.out.println("WebElements were located!!!");
    }


    @Test
    @Order(1)
    public void _submit() throws InterruptedException {
        emailBox.sendKeys("automation@gmail.com");
        passwordBox.sendKeys("automationUItesting");

        //loginButton.click();//yerine submit(); kullan

        /*
        <button class="_acan _acap _acas _aj1-" type="submit">
            <div class="_ab8w  _ab94 _ab99 _ab9f _ab9m _ab9p _abcm">Log in</div>
        </button>
         */

        passwordBox.submit();//type='submit' olan elemente tiklar gibi dusunun
                             //kullanici bilgilerimzii sisteme submit/sunmak eder
        Thread.sleep(3000);
    }




    @Test
    @Order(2)
    public void _getTagName() {

        String expectedTag="input";
        String actualTag=passwordBox.getTagName();
        System.out.println(actualTag);
        Assertions.assertEquals(expectedTag, actualTag);

    }


    @Test
    @Order(3)
    public void _getLocation() {

        Point point =passwordBox.getLocation();

        //the top-left corner
        System.out.println("point.x = " + point.x);
        System.out.println("point.y = " + point.y);

        getDriver().manage().window().minimize();



        point =passwordBox.getLocation();

        //the top-left corner
        System.out.println("point.x = " + point.x);
        System.out.println("point.y = " + point.y);

    }



    @Test
    @Order(4)
    public void _getClass() {



        String driverObjectReferenceClass=getDriver().getClass().getSimpleName();
        System.out.println("driverObjectReferenceClass = " + driverObjectReferenceClass);


        String webElementObjectReferenceClass=passwordBox.getClass().getSimpleName();
        System.out.println("webElementObjectReferenceClass = " + webElementObjectReferenceClass);
    }




    @AfterAll
    public static void afterAll() {
        System.out.println("Test classimizin @AfterAll methodudur");
     //   getDriver().close();
    }



}




    /*junit


submit() getClass()

datehandle()

 //select-deselect
 dropdownHandle(text index value isMultiple, getOptions getFirstSelectedOptions)

waits timeouts

actions
        draganddrop contextClick, double click
        keyboards actions(chord basili tutma)
        build perform

cookies

fileupload download


     */

    /*
    testng
iframe
    screenShot, video
    zoom in out
    all types of pop-up
    all types-of alerts
    windowsHandle(s) switchTo() window()
    apache poi
    webtables
    testng.runnner
    testngReport
        parallel crossbrowser execution





     */
    /*
    cucumber
    POModel
    cucumber feature files
    parallel crossbrowser execution
    cucumber report pdf,extent,...
    configCache
    .properties

    log4j logging
    screenshot put a word
    webElement.properties
    driver
    hook
    util
    action
    step


     */


