package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.windowHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class e_ClosingAllWindows_InSame_ChromeDriverSession {


    @BeforeAll
    static void setUp()
    {

        getDriver().get("https://demoqa.com/browser-windows");

        getDriver().findElement(By.id("windowButton")).click();
        getDriver().findElement(By.id("messageWindowButton")).click();
        getDriver().findElement(By.id("tabButton")).click();


    }



    @Test
    void _notUseClose_useQuit()
    {

        //close() sadece bulundugu tab'i kapatir.
        //eger bir window'da sadece 1 tab aciksa window'u kapatir.
        //getDriver().close();

        //quit() ise chromeDriver() session'indaki tum acilan
        // parent/sibling/child windowlari/tableri kapatir
        System.out.println("-------------------------");
        getDriver().quit();

    }
}

