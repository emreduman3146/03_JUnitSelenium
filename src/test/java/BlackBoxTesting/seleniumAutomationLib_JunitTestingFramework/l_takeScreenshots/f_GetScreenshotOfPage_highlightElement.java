package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;


public class f_GetScreenshotOfPage_highlightElement
{

    private static WebDriver driver;

    @BeforeAll
    static void setUp() throws InterruptedException {
        //LAUNCH BROWSER
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //URL'YE NAVIGATE ET
        driver.get("https://youtube.com");

    }


    @Test
    public void elementScreenShot()  {

        // LOGO'NUN LOCATE EDILMESI
        WebElement logo = driver.findElement(By.xpath("//div[@id='start']"));

        //SELENIUM-JAVA'NIN JS'YI KULLANMASINI SAGLAYAN CLASSTIR
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", logo);

        //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU ALmaktan gorevli olan objeyi olustur.
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;

        //ALINAN SS'NIN FILE'FORMATINA DONUSTURULMESI
        File ekranGoruntusuDosyasi = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //YENI BAGIMSIZ ICI BOS BIR PNG FILE' OLUSTURDUK VERDIGIMIZ PATH'TE
        File kaydedilecekDosyaninPath = new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/highlight_Element.png");


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
