package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.h_cookiesHandling;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.Date;
import java.util.Set;
import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class b_HepsiBurada_cookiesMethods
{
     public static void _getCookies_displayDetails()
    {
        Set<Cookie> cookiesSet=getDriver().manage().getCookies();
        int toplam=0;

        for (Cookie cookie:cookiesSet)
        {
            System.out.println("cookie.getName() = " + cookie.getName());
            System.out.println("cookie.getValue() = " + cookie.getValue());
            System.out.println("cookie.getDomain() = " + cookie.getDomain());
            System.out.println("cookie.getPath() = " + cookie.getPath());
            System.out.println("cookie.getExpiry() = " + cookie.getExpiry());
            System.out.println("---------------------------------------------");
            toplam++;
        }
        System.out.println("toplam = " + toplam);
    }

    @BeforeAll
    static void  setUp()
    {
        getDriver().get("https://www.hepsiburada.com/");
    }

    @Order(2)
    @Test
    void _getCookiesByName()
    {
        Cookie cookie=getDriver().manage().getCookieNamed("hbus_sessionId");

        System.out.println("cookie.getName() = " + cookie.getName());
        System.out.println("cookie.getValue() = " + cookie.getValue());
        System.out.println("cookie.getDomain() = " + cookie.getDomain());
        System.out.println("cookie.getPath() = " + cookie.getPath());
        System.out.println("cookie.getExpiry() = " + cookie.getExpiry());
        System.out.println("---------------------------------------------");
    }

    @Order(3)
    @Test
    void _addCookie()
    {
        //Instant Turkcesi "an" demektir
        //system gun tarig saatini alir
        Instant now = Instant.now();


        //3600 saniye=1 saat uzerine ekleme yapar
        Instant oneHourLater = now.plusSeconds(3600);

        //Instance Classinin objesini long primitive veri tipine cevirdik
        long millis = oneHourLater.toEpochMilli();
        System.out.println(millis);

        //long veri tipini kullanarak Data Objesi olusturduk
        Date date = new Date(millis);
        System.out.println(date);

        Cookie newCookie=new Cookie("QA","UITesting",".hepsiburada.com","/",date);


        getDriver().manage().addCookie(newCookie);
    }

    @Test
    @Order(4)
    void editCookies()
    {
        //ADD'ledigimiz COOKIE'yi BULDUK
        Cookie QA_cookie=getDriver().manage().getCookieNamed("QA");

        //YENI-BAGIMSIZ BIR COOKIE OLUSTURDUK - LOCALDE
        Cookie editted_QA_cookie=new Cookie(QA_cookie.getName(), "API Testing", QA_cookie.getDomain(),QA_cookie.getPath(),QA_cookie.getExpiry());

        //YENI COOKIE'yi ADDledik
        getDriver().manage().addCookie(editted_QA_cookie);

        Assert.assertEquals(
                editted_QA_cookie.getValue(),
                getDriver().manage().getCookieNamed(QA_cookie.getName()).getValue()
                //getDriver().manage().getCookieNamed("QA").getValue()
        );
    }

    @Order(5)
    @Test
    void _deleteCookieNamed()
    {
        Cookie benimCookie= getDriver().manage().getCookieNamed("QA");
        getDriver().manage().deleteCookie(benimCookie);
        Assert.assertNull(getDriver().manage().getCookieNamed(benimCookie.getName()));
    }


    @Order(6)
    @Test
    void _deleteCookie()
    {
        Cookie cookie=getDriver().manage().getCookieNamed("hbus_sessionId");
        getDriver().manage().deleteCookie(cookie);
    }

    @Order(7)
    @Test
    void _deleteAllCookie()
    {
        getDriver().manage().deleteAllCookies();
    }

    @Test
    @Order(8)
    void additionalAttributeOfCookies()
    {

            Cookie cookie = new Cookie.Builder("name1", "value1").sameSite("Strict").isSecure(true).isHttpOnly(false).build();
            Cookie cookie1 = new Cookie.Builder("name2", "value2").sameSite("Lax").build();
            getDriver().manage().addCookie(cookie);
            getDriver().manage().addCookie(cookie1);
            System.out.println(cookie.getSameSite());
            System.out.println(cookie1.getSameSite());

    }


    @AfterEach
    void checkAllCookies()
    {
        _getCookies_displayDetails();
        //getDriver().navigate().refresh();
    }

}
