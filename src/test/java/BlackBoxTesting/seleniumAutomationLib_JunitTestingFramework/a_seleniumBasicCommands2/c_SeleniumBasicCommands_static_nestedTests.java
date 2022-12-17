package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.*;


@Epic("Selenium'daki temel methodlari ogrenmeye devam ediyoruz")
@Feature("BlackBoxTesting yapiyoruz")
@Tag("c_SeleniumBasicCommands_static_nestedTests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class c_SeleniumBasicCommands_static_nestedTests {

    static {
        getDriver().get("https://www.google.com");
    }


    @BeforeAll
    public static void webElementSetup() throws InterruptedException {
        getDriver().navigate().to("https://courses.letskodeit.com/practice");
        Thread.sleep(3000);
        System.out.println("Test classimizin @BeforeAll methodudur");
    }



    @Nested// Ana classimizdan Bagimsiz'dir
    @DisplayName("Tests isEnable() isDisplayed() - example1")
    @Tag("NestedTest1")
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    static class JavaInnerClass {

        static WebElement emailBox,passwordBox,loginButton,warningMessage;

        @BeforeAll//BeforeAll methodu static olamk zorundaydi, bu yuzden JavaInnerClass da static class olmak zorundadir
        public static void beforeAll() throws InterruptedException {
            getDriver().navigate().to("https://www.instagram.com/");
            System.out.println("Navigated to the URL!");

            Thread.sleep(3000);


            emailBox=getDriver().findElement(By.name("username"));
            passwordBox=getDriver().findElement(By.xpath("//*[@name='password']"));
            loginButton=getDriver().findElement(By.xpath("//div[text()='Log in']"));

            System.out.println("WebElements were located!!!");
            Thread.sleep(3000);
        }

        @BeforeEach
        public void beforeEach()
        {
            System.out.println("JavaInnerClass beforeEach methodu");
        }

        @Test
        @Tag("isEnabled_button")
        @Order(1)
        public void _isEnabled() throws InterruptedException {
            Thread.sleep(3000);
            emailBox.sendKeys("automation@gmail.com");
            passwordBox.sendKeys("automationUItesting");

            if(loginButton.isEnabled()) {
                loginButton.click();
                assertTrue(true);
                System.out.println("Login Button is enabled!");
            }
            else {
                assertTrue(false);
                System.out.println("Login Button is disabled!");

            }
        }

        @Test
        @Tag("isDisplayed_nonExistentElement")
        @Order(2)
        public void _isDisplayed()
        {
            try
            {
                Thread.sleep(3000);//muhtemel firlatilabilecek hata ismi ->InterruptedException

                //eger element yoksa isDisplayed() methodu NoSuchElementException firlatir
                //eger element varsa true donderir
                if( getDriver().findElement(By.id("slfErrorAlert")).isDisplayed())
                {
                    warningMessage=getDriver().findElement(By.id("slfErrorAlert"));
                    assertTrue(warningMessage.isDisplayed());
                }
            }
            catch (NoSuchElementException | InterruptedException e){
                System.out.println(e);
                Assertions.assertThrows(NoSuchElementException.class,()->getDriver().findElement(By.id("slfErrorAlert")));

            }
        }


        @Nested// Ana classimizdan Bagimsiz'dir
        @DisplayName("Tests isEnable() isDisplayed() - static example2")
        @Tag("NestedTest1_1")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        static class JavaInner_InnerClass
        {
            @BeforeAll
            static void beforeAll() throws InterruptedException {
                getDriver().navigate().to("https://courses.letskodeit.com/practice");
                Thread.sleep(3000);
            }

            @Test
            @Tag("isEnabled_textbox")
            @Order(1)
            public void _isEnabled2() {
               assertTrue(getDriver().findElement(By.id("enabled-example-input")).isEnabled());
               getDriver().findElement(By.id("disabled-button")).click();
               assertFalse(getDriver().findElement(By.id("enabled-example-input")).isEnabled());
            }

            @Test
            @Tag("isDisplayed_hiddenElement")
            @Order(2)
            public void _isDisplayed2() throws InterruptedException {
                assertTrue(getDriver().findElement(By.id("displayed-text")).isDisplayed());
                getDriver().findElement(By.id("hide-textbox")).click();
                Thread.sleep(1000);
                assertFalse(getDriver().findElement(By.id("displayed-text")).isDisplayed());
                //element var ama gizliyse isDisplayed() false return eder
            }



        }


        @AfterAll
        static void afterAll()
        {
            System.out.println("Tests are done!!!");
           // getDriver().close();
        }
    }



    @Test
    @Order(2)
    @Tag("isSelected")//Test suite'te calistirilabilsin diye
    public void _isSelected() {

        WebElement radioBenz=getDriver().findElement(By.id("benzradio"));
        if(radioBenz.isSelected()) {
            ///do nothing
        }
        else
            radioBenz.click();



        WebElement checkboxBMW=getDriver().findElement(By.id("bmwcheck"));
        if(checkboxBMW.isSelected()) {
            ///do nothing
        }
        else
            checkboxBMW.click();


        System.out.println("isSelected");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test classimizin @AfterAll methodudur");
    }








}




    /*junit


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


