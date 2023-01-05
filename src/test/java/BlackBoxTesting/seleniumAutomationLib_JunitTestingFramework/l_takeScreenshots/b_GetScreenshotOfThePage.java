package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class b_GetScreenshotOfThePage
{

    private static WebDriver driver;

    @BeforeAll
    static void setUp()
    {
        //LAUNCH BROWSER
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //URL'YE NAVIGATE ET
        driver.get("https://youtube.com");
    }

    @Test
    void getScreenShot01()
    {

        //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU AL
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;

        //ALINAN SS'NIN FILE'FORMATINA DONUSTURULMESI
        File ekranGoruntusuDosyasi = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //YENI BAGIMSIZ ICI BOS BIR PNG FILE' OLUSTURDUK VERDIGIMIZ PATH'TE
        File kaydedilecekDosyaninPath = new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/youtubeHomePage2.png");


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
}
