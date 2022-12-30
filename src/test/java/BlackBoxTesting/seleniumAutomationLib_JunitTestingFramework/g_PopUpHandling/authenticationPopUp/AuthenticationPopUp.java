package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.g_PopUpHandling.authenticationPopUp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class AuthenticationPopUp
{

    @Test
    void putCredentialsAutomatically_toSkipPopup()
    {

        var URL="https://the-internet.herokuapp.com";//local variable
        getDriver().get(URL);

        //Asagidaki linki locate et
        By locator=By.linkText("Basic Auth");
        var basicAuthenticationLink=getDriver().findElement(locator);

        //Linke Tikla
        basicAuthenticationLink.click();

        //gitmek istedigim sayfa oncesinde bana credential bilgilerimi
        //girmemi istiyor aksi halde istedigim linke gidemiyorum
        //tepeden cikan authentication_popUp'i ni inspect yapamiyorum
        //Bu durumla handle etmenin yolu ise asagidaki gibidir

        var currentURL=getDriver().getCurrentUrl();
        //https://the-internet.herokuapp.com/basic_auth

        var modifiedURL=currentURL.replace("//","//admin:admin@");

        System.out.println("modifiedURL = " + modifiedURL);
        //https://admin:admin@the-internet.herokuapp.com/basic_auth


        getDriver().navigate().to(modifiedURL);

    }


    //JAVA BILGISI:
    //JDK'nin icinden hazir gelen String Classinin
    //biz JAVACIlara sundugu hazir hizmetler/methodlar vardir
    //Bunlardan replace() methodunun kullandik.


    //Ihtiyac duyanlar String Class'i methodlarini tekrar edebilirler
    // KAYNAK -> https://www.w3schools.com/java/java_ref_string.asp

    /*
    JAVA JDK11 ile 'var' turuncu reserved keyword'u ile tanistik.
    JavaScript dilinde de oldugu gibi var ile declare edilen degiskenin tipi dynamictir.
    var keywordu ancak ve ancak method icerisinde local variable olustururken kullanilabilir.
    LOCAL VARIABLE= METHODUN KENDI VARIABLE'i
     */

}
