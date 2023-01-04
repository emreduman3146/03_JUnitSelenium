package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.h_cookiesHandling;

import BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.launchBrowserAgain;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class d_loginByCookiesExample
{

    static Set<Cookie> loginCookie;

    @BeforeAll
    static void setUp()
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Test
    @Order(1)
    void login()
    {

        getDriver().navigate().to("http://demo.guru99.com/test/cookie/selenium_aut.php");


        // Input Email id and Password If you are already Register
        getDriver().findElement(By.name("username")).sendKeys("abc123");
        getDriver().findElement(By.name("password")).sendKeys("123xyz");
        getDriver().findElement(By.name("submit")).click();
    }

    @Test
    @Order(2)
    void getCookies_storeIn_aDataFile()
    {
        // create file named Cookies to store Login Information
        File file = new File("CookiesGURU.data");
        try
        {
            // Delete old file if exists
            file.delete();//eger boyle hali hazirda bir dosya varsa sil
            file.createNewFile();//CookiesGURU.data isimli file olustur
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information

            // loop for getting the cookie information
            for(Cookie ck : getDriver().manage().getCookies())
            {
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                Bwrite.newLine();
                System.out.println(ck);
            }
            Bwrite.close();
            fileWrite.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void getTheLoginCookie() throws InterruptedException {
        Thread.sleep(3000);
        loginCookie=getDriver().manage().getCookies();
        getDriver().close();

    }
    @Test
    @Order(4)
    void loginAgain_viaCookies_storedDataFile() throws InterruptedException {
        launchBrowserAgain().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        try{

            File file = new File("CookiesGURU.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        expiry = new Date(val);
                    }


                    Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    getDriver().manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        getDriver().get("https://demo.guru99.com/test/cookie/selenium_cookie.php");
        Thread.sleep(5000);
        getDriver().close();
    }

    @Test
    @Order(5)
    void closeDriverAndTryToLoginWithoutCookies()
    {
        launchBrowserAgain().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        getDriver().get("https://demo.guru99.com/test/cookie/selenium_cookie.php");
        getDriver().close();

    }

    @Test
    @Order(6)
    void loginAgain_viaCookies_storedDataFile2() throws InterruptedException {
        launchBrowserAgain().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        try{

            File file = new File("CookiesGURU.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    getDriver().manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        getDriver().get("https://demo.guru99.com/test/cookie/selenium_cookie.php");
        Thread.sleep(5000);
        getDriver().close();
    }

    @Test
    @Order(8)
    void loginWithSetCookies()
    {
        launchBrowserAgain().get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        for (Cookie cookie:loginCookie)
        {
            getDriver().manage().addCookie(cookie);
        }
        getDriver().get("https://demo.guru99.com/test/cookie/selenium_cookie.php");

    }


}
