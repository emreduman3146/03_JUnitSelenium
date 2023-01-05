package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots.aShotDependency;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class a_SSofPage {

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
    void getScreenShot01() throws IOException {


        //BULUNDUGUN SAYFANIN gozumuzle gozuken yerin EKRAN GORUNTUSUNU AL
        Screenshot screenshot = new AShot().takeScreenshot(driver);

        //ALINAN SS'NIN bir file'in icine konulmasi
        ImageIO.write(screenshot.getImage(),"PNG",new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/AShotPage_youtubeHomePage.png"));


    }

}
