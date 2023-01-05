package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class a_GetScreenshotOfThePage
{

    private static WebDriver driver;//null

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

        //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU ALMAK ICIN ILK OLARAK takesScreeenShots objesi olusturmaliyiz
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;

        //ALINAN SS'NIN FILE'FORMATINA DONUSTURULMESI
        File ekranGoruntusuDosyasi = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //ELIMIZDEKI FILE'I KAYDETMEK ICIN BIR PATH KULLANMALIYIZ
        //ekranGoruntusuDosyasi.renameTo(new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/youtubeHomePage.png"));
        ekranGoruntusuDosyasi.renameTo(new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/youtubeHomePage2.jpeg"));

        //new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/screenshot.png")
        //BU KOD ILE BU PATH'TE ICI BOS BIR PNG FILE OLUSTURURUZ

        //ekranGoruntusuDosyasi.renameTo()
        //BU KOD ILE DE "ekranGoruntusuDosyasi" BU OBJECTIN ICINDE TUTALAN GORUNTUYU KOPYALARIZ VEYENI PATH'E KOPYASINI KAYDEDERIZ.

    }
}
