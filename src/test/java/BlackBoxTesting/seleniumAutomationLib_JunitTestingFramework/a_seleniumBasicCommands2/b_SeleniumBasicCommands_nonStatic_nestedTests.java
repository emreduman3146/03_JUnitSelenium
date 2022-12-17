package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("Selenium'daki temel methodlari ogrenmeye devam ediyoruz")
@Feature("BlackBoxTesting yapiyoruz")
@Tag("b_SeleniumBasicCommands_nonStatic_nestedTests_isSelected_isEnable_isDisplayed")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class b_SeleniumBasicCommands_nonStatic_nestedTests {


    static {
        getDriver().get("https://www.google.com");
    }

    @BeforeAll
    public static void webElementSetup() {
        System.out.println("Test classimizin @BeforeAll methodudur");
    }

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Ana test classi, @BeforeEach methodu ");
    }



    @Test
    @Order(2)
    @Tag("isSelected")//Test suite'te calistirilabilsin diye
    public void _isSelected() {
        System.out.println("isSelected");
    }




    @Nested// Ana classimizdan Bagimsiz'dir
    @DisplayName("Tests isEnable() isDisplayed() - example1")
    @Tag("NestedTest1")
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class JavaInnerClass {

        WebElement emailBox,passwordBox,loginButton,warningMessage;
        String kullaniciIsmi,sifre;


        @BeforeEach
        public void beforeEach() {
            System.out.println("JavaInnerClass, @BeforeEach methodu ");

        }

        @Test
        @Tag("isEnabled_button")
        @Order(1)
        public void _isEnabled() throws InterruptedException {
            getDriver().navigate().to("https://www.instagram.com/");
            System.out.println("Navigated to the URL!");

            Thread.sleep(3000);
            emailBox=getDriver().findElement(By.name("username"));
            passwordBox=getDriver().findElement(By.xpath("//*[@name='password']"));
            loginButton=getDriver().findElement(By.xpath("//div[text()='Log in']"));

            System.out.println("WebElements were located!!!");


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
                Thread.sleep(1000);//muhtemel firlatilabilecek hata ismi ->InterruptedException

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


        @Nested
        @DisplayName("Tests isEnable() isDisplayed() - example2")
        @Tag("NestedTest1_1")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class JavaInner_InnerClass
        {
            @BeforeEach
            void BeforeEach() throws InterruptedException {
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



        @AfterEach
        public void afterEach(TestInfo testInfo)
        {
            System.out.println("JavaInnerClass @AfterEach method" + testInfo.getTags());
        }


    }





    @AfterEach
    public void AfterEach()
    {
        System.out.println("Ana test classi, @AfterEach methodu ");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test classimizin @AfterAll methodudur");
        System.out.println("Tests are done!!!");
        getDriver().close();
    }













/*





    @Nested// Ana classimizdan Bagimsiz'dir
    @DisplayName("Tests isEnable() isDisplayed() - example1")
    @Tag("NestedTest1")
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class JavaInnerClass {

        WebElement emailBox,passwordBox,loginButton,warningMessage;

        @BeforeEach
        public void beforeEach() {
            System.out.println("JavaInnerClass, @BeforeEach methodu ");
        }

        @Test
        @Tag("isEnabled_button")
        @Order(1)
        public void _isEnabled() throws InterruptedException {
            getDriver().navigate().to("https://www.instagram.com/");
            System.out.println("Navigated to the URL!");

            emailBox=getDriver().findElement(By.name("username"));
            passwordBox=getDriver().findElement(By.xpath("//*[@name='password']"));
            loginButton=getDriver().findElement(By.xpath("//div[text()='Log in']"));

            System.out.println("WebElements were located!!!");


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
                Thread.sleep(1000);//muhtemel firlatilabilecek hata ismi ->InterruptedException

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

        @AfterEach
        public void afterEach(TestInfo testInfo)
        {
            System.out.println("JavaInnerClass @AfterEach method" + testInfo.getTags());
        }

        @Nested// Ana classimizdan Bagimsiz'dir
        @DisplayName("Tests isEnable() isDisplayed() - example2")
        @Tag("NestedTest1_1")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class JavaInner_InnerClass
        {
            @BeforeEach
            public void beforeEach()
            {
                System.out.println("JavaInner_InnerClass, @BeforeEach methodu");
                getDriver().navigate().to("https://courses.letskodeit.com/practice");
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

            @AfterEach
            public void afterEach(TestInfo testInfo)
            {
                System.out.println("JavaInner_InnerClass @AfterEach method" + testInfo.getTags());
            }


        }

    }

*/




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


