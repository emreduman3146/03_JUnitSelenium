package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.a_seleniumBasicCommands2;

import org.junit.jupiter.api.Test;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.driver.Driver.*;

public class SeleniumBasicCommands2
{

    //JAVA BILGISI
    //static block sadece ve sadece kez calisir.
    //calismasi icin, SeleniumBasicCommands2 classinin calismasi gerekir
    //Bu block genelde ayarlar yapmak icin kullanilir
    static{
        getDriver().get("https://www.google.com");
    }

    public static void main(String[] args) {
        _getText();
        _getAttribute();
        _getCssValue();
    }

    @Test
    private static void _getCssValue() {
    }

    @Test
    private static void _getAttribute() {
    }

    @Test
    private static void _getText() {
    }





    /*junit
    getText() vs getAttribute() vs getCssValue()

isDisplayed(), isEnabled(), isSelected()

submit() getClass()

datehandle()

 //select-deselect
 dropdownHandle(text index value isMultiple, getOptions getFirstSelectedOptions)

waits timeouts

actions
        draganddrop contextClick, double click
        keyboards actions(chord basili tutma)
        build perform

cookies

fileupload download


     */

    /*
    testng
iframe
    screenShot, video
    zoom in out
    all types of pop-up
    all types-of alerts
    windowsHandle(s) switchTo() window()
    apache poi
    webtables
    testng.runnner
    testngReport
        parallel crossbrowser execution





     */
    /*
    cucumber
    POModel
    cucumber feature files
    parallel crossbrowser execution
    cucumber report pdf,extent,...
    configCache
    .properties

    log4j logging
    screenshot put a word
    webElement.properties
    driver
    hook
    util
    action
    step


     */

}
