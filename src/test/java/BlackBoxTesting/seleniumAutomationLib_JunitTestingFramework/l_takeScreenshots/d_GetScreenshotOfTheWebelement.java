package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class d_GetScreenshotOfTheWebelement
{

    private static WebDriver driver;
    //private WebElement header;
    //, firstTabInTheHeader, firstRecommendedVideo;

    @BeforeAll
    static void setUp() throws InterruptedException {
        //LAUNCH BROWSER
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //URL'YE NAVIGATE ET
        driver.get("https://youtube.com");

    }


    @Test
    public void elementScreenShot() throws IOException {

        // LOGO'NUN LOCATE EDILMESI
        WebElement logo = driver.findElement(By.xpath("//div[@id='start']"));

        //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU ALmaktan sorumlu objeyi olusturalim
        TakesScreenshot takesScreenshot = (TakesScreenshot)logo ;

        //ALINAN SS'NIN FILE'FORMATINA DONUSTURULMESI
        File ekranGoruntusuDosyasi = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //YENI BAGIMSIZ ICI BOS BIR PNG FILE' OLUSTURDUK VERDIGIMIZ PATH'TE
        File kaydedilecekDosyaninPath = new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/classicElementTakenSS.png");


        try
        {
            //'ekranGoruntusuDosyasi' FILE'INI KOPYALAYIP  'kaydedilecekDosyaninPath' FILE'ININ ICINE PASTE EDIYORUZ
            FileUtils.copyFile(ekranGoruntusuDosyasi, kaydedilecekDosyaninPath);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        //TRY-CATCH KULLANMAK IYIDIR, CUNKU ELLE YAZDIGIMIZ YESIL STRING PATH YANLIS YAZILMISSA
        //FILENOTFOUND HATASI ALABILIRIZ

    }


    @Test
    public void elementScreenShot2() throws IOException {

        //LOGO'NUN LOCATE EDILMESI
        //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU AL
        //ALINAN SS'NIN FILE'FORMATINA DONUSTURULMESI

        try
        {
            FileUtils.copyFile(((TakesScreenshot)driver.findElement(By.xpath("//div[@id='start']"))).getScreenshotAs(OutputType.FILE), new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/tekSatirCode_classicElementTakenSS.png"));
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

        //TRY-CATCH KULLANMAK IYIDIR, CUNKU ELLE YAZDIGIMIZ YESIL STRING PATH YANLIS YAZILMISSA
        //FILENOTFOUND HATASI ALABILIRIZ

    }

}
