package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//MANTIK
//Bir suru classimin var ve hepsi driver'i kullanmak istiyor.
//O zaman bir tane ortak driver olusturan class yazalim
//ve ne zaman ihtiyac duyarsak o classtan driver'i cagiralim
public class Driver
{
    //JAVA OOP ENCAPSULATION KONUSU
    static private WebDriver driver;//null, baska hicbir classtan bu objeme ellenemez
    static Driver driverClassObje;


    //default constructor of the class
    //java bilgisi private:access modifier
    private Driver() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--disable-notifications"//bildirim almak ister misin pop-up'ini otomatik kapatir
                );
        driver= WebDriverManager.chromedriver().avoidShutdownHook().capabilities(options).create();
    }



    //WebDriver driver'i return eden, bu gorevi ustlenen bir getter methodu yazayim
    static public WebDriver getDriver()
    {
        if(driver == null)
            driverClassObje=new Driver();

        return driver;
    }


    //WebDriver driver'i return eden, bu gorevi ustlenen bir getter methodu yazayim
    static public WebDriver launchBrowserAgain()
    {
        driverClassObje=new Driver();
        return driver;
    }







    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}
