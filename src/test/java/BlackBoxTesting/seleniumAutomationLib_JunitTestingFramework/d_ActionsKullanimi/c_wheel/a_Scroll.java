package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.d_ActionsKullanimi.d_wheel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_Scroll
{
    //SUANLIK SADECE CHROME BROWSERDA CALISIR

    static Actions actions;


    @BeforeAll
    static void setUp()
    {
        System.out.println("Selenium WebDriver'inin yetenegini Actions classi ile genisletelim");
        actions=new Actions(getDriver());


        //TRENDYOL URL'si vermem lazim
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
        actions.moveToElement(selectButton).click().build().perform();
    }


    @Test
    void _scrollToElement()
    {
        //parameter olarak verecegimiz webElemntinin oldugu yere gider
        //ASAGI KAYDIRIR
        WebElement aboutUS= getDriver().findElement(By.xpath("//h4[text()='About us']"));
        actions.scrollToElement(aboutUS).perform();

        //YUKARI KAYDIRMA OZELLIGI DE VAR
        WebElement erkekTab = getDriver().findElement(By.xpath("//a[text()='Erkek']"));
        actions.scrollToElement(erkekTab).perform();

    }

    @Test
    void _scrollByAmount()
    {

       // WEebelemntAdi.gerRect();// RectANGLE(DIKDORTGEN)

        //RAKAM POZITIF ISE ASAGI VE SAGA KAYDIRIR
        WebElement aboutUS= getDriver().findElement(By.xpath("//h4[text()='About us']"));

        Rectangle rectangle=aboutUS.getRect();

        int deltaY = rectangle.y;
        actions.scrollByAmount(0,deltaY).perform();


        //RAKAM NEGATIF ISE YUKARI VE SOLA KAYDIRMA
        WebElement erkekTab = getDriver().findElement(By.xpath("//a[text()='Erkek']"));
        deltaY= erkekTab.getRect().y;
        actions.scrollByAmount(0, -deltaY).perform();

    }


    @Test
    void _scrollFromOrigin()
    {

        //ASAGI KAYDIRIR
        WebElement aboutUS= getDriver().findElement(By.xpath("//h4[text()='About us']"));

        //ELIMDEKI ELEMENTIMI ORIJINLESTIRME ISLEMI
        WheelInput.ScrollOrigin originNoktasi = WheelInput.ScrollOrigin.fromElement(aboutUS);


        actions.scrollFromOrigin(originNoktasi, 100, -500).perform();


        //YUKARI KAYDIRMA OZELLIGI VAR
        WebElement oneCikanlar = getDriver().findElement(By.xpath("//span[text()='Öne Çıkanlar']"));
        WheelInput.ScrollOrigin scrollOrigin2 = WheelInput.ScrollOrigin.fromElement(oneCikanlar);

        actions.scrollFromOrigin(scrollOrigin2, 0, 0).perform();


    }


}
