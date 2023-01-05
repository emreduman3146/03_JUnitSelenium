package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots.aShotDependency;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class b_SSofFullPage
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
    void getScreenShot01() throws IOException {

        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/AShotFull_youtubeHomePage.png"));

        /*
            shootingStrategy() metodu, takeScreenshot() metodundan önce çağrılır ve
            ekran görüntüsünün nasıl alınacağını belirtir.
            Bu örnekte, viewportPasting() stratejisi kullanılır. Bu strateji, görüntülenen web sayfasının görüntüsünü alır ve
            tek bir resim olarak yapıştırır.
             viewportPasting() metoduna verilen 1000 argümanı, scrolling down yapilirken 1'er saniye ara ile yap
         */

    }
}
