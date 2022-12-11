package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver
{
    static private WebDriver driver;
    private static Driver driverClassObje;

    //default constructor of the class
    private Driver() {
        driver= WebDriverManager.chromedriver().create();
    }


    //WebDriver driver'i return eder
    static public WebDriver getDriver()
    {
        if(driver == null)
            driverClassObje=new Driver();

        return driver;
    }
}
