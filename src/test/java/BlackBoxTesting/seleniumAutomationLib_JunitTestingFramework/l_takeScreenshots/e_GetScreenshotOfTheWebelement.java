package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Issue;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class e_GetScreenshotOfTheWebelement
{

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        //LAUNCH BROWSER
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //URL'YE NAVIGATE ET
        driver.get("https://youtube.com");

    }


    @Test
    public void elementScreenShot() throws IOException {

        // Locate the web element
        WebElement logo = driver.findElement(By.xpath("//div[@id='start']"));

        // capture screenshot with getScreenshotAs() of the WebElement class
        File f = logo.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(f, new File("src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/selenium4_element.png"));


    }
    //SELENIUM 4 ILE GELEN YENI KISA YOL


}
