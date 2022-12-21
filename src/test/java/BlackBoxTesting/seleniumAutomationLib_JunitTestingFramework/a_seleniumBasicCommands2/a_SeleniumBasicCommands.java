package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2;

import BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

//BU 2 TAG ALLURE DEPENDENCY'DEN GELIR
//ALLURE REPORT OLUSTURURKEN, ana baslik, alt baslik gibi aciklamalari yonetebiliyoruz bu tagler sayesinde
//Terminale-> mvn clean test allure:report -Dtest=SeleniumBasicCommands2 yazin+enter tikla
//mvn allure:serve yaz + enter tikla


@Link("https://www.emreduman,com")
@Severity(SeverityLevel.NORMAL)
@Epic("Selenium'daki temel methodlari ogrenmeye devam ediyoruz")
@Feature("BlackBoxTesting yapiyoruz")
public class a_SeleniumBasicCommands
{

    //JAVA BILGISI
    //static block sadece ve sadece kez calisir.
    //calismasi icin, SeleniumBasicCommands2 classinin calismasi gerekir
    //Bu block genelde ayarlar yapmak icin kullanilir
    static {
        getDriver().get("https://www.google.com");
        Allure.step("STEP1->Navigated to Chrome ");

    }



    static WebElement signInButton;

    @BeforeAll
    public static void webElementSetup() {
        signInButton = getDriver().findElement(By.xpath("//a[contains(@href,\"https://accounts\")]"));
       // System.out.println("signInButton.getAttribute(\"id\") = " + signInButton.getAttribute("id"));
    }



    @ParameterizedTest
    @ValueSource(strings = {"Sign in"})
    @Tag("getText")//Test suite'te calistirilabilsin diye

    @Story("webElement01.getText(); kullanimi")//allure report icin aciklama
    @Description("webElement01.getText(); diyerek html tagin text'ini return ederiz")//allure report icin aciklama

    //Maven bilgi: mvn clean test allure:report -Dtest=SeleniumBasicCommands2#_getText test    ile bu methodu terminalde calistir
    //JUnit bilgi: @Test methodu private, static olamaz
    public void _getText(String expectedText) {
        //WebElement signInButton=getDriver().findElement(By.xpath("//a[contains(@href,\"https://accounts\")]"));
        String actualText = signInButton.getText();
        System.out.println(actualText);
        Assertions.assertEquals(expectedText, actualText);
        Allure.step("STEP2->signInButton Text is asserted");

    }





    @ParameterizedTest
    @Issue("123")
    @Step("Step-allure")
    @TmsLink("test1")
    @Story("webElement01.getAttribute('attributeName'); kullanimi")
    @Description("webElement01.getAttribute(); diyerek html tagin attribute'ini return ederiz")
    @Tag("getAttribute")
    @CsvSource(value = {
            "class,gb_7 gb_8 gb_de gb_dd",
            "target,_top",
            "href,https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/&ec=GAZAmgQ",
            "id,''",//bu elementin id si yoktur geriye "" bos deger dondurur
            "text,Sign in",
            "olmayanAttribute,null"

    },nullValues = {"null"}//4 karakterli null String kelimesinin turuncu null olarak algilanmasini saglar
    )
    protected void _getAttribute(String attributeName,String attributeValue) {
        String actualValue = signInButton.getAttribute(attributeName);
        Assertions.assertEquals(attributeValue, actualValue);
    }







    @Test
    public void _getCssValue()
    {
        String buttonTextRengi= signInButton.getCssValue("color");
        String buttonBackgroundRengi= signInButton.getCssValue("background");
        System.out.println(buttonTextRengi);
        System.out.println(buttonBackgroundRengi);


        Assertions.assertEquals(buttonTextRengi,"rgba(255, 255, 255, 1)");


        //HTML BILGISI
        //redgreenbluea(255, 255, 255, 1) = beyaz renk demektir


    }

    @AfterAll
    static void tearDown()
    {
        getDriver().close();
    }



}



















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


