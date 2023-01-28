package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSE_UtilMethods
{
    public static String getCurrentURL(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return window.location.href;");
    }

    public static void maximizeWindow(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.moveTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript("window.resizeTo(window.screen.availWidth, window.screen.availHeight);");
    }

    public static void refreshPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("location.reload();");
    }


    public static void clickOnElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void setInputValue(WebDriver driver, WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value',arguments[1]);", element, value);
    }

    public static String getElementText(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].text;", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void removeHighlightFromElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
    }


    public static String getElementAttribute(WebDriver driver, WebElement element, String attribute) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute(arguments[1]);", element, attribute);
    }


    public static void setElementAttribute(WebDriver driver, WebElement element, String attribute, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attribute, value);
    }


    public static void hoverOverElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("var evt = new MouseEvent('mouseover', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(evt);", element);
    }


    public static void simulateKeyPress(WebDriver driver, String key) {
        ((JavascriptExecutor) driver).executeScript(
                "var evt = document.createEvent('Events'); evt.initEvent('keydown', true, true); evt.keyCode = " + key + "; document.dispatchEvent(evt);");
    }


    public static boolean isElementDisabled(WebDriver driver, WebElement element) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].disabled;", element);
    }


    public static void removeElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", element);
    }


    public static Point getElementCoordinates(WebDriver driver, WebElement element) {
        return (Point) ((JavascriptExecutor) driver).executeScript("return arguments[0].getBoundingClientRect();", element);
    }

    public static void changeElementBackgroundColor(WebDriver driver, WebElement element, String color) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '" + color + "';", element);
    }


    public static void waitForElementPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d ->
        {
            Boolean isPresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].isDisplayed();", element);
            return isPresent;
        });
    }


    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> {
            Boolean isClickable = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].isEnabled();", element);
            return isClickable;
        });
    }

    public static void waitForElementInvisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> {
            Boolean isInvisible = (Boolean) ((JavascriptExecutor) driver).executeScript("return !arguments[0].isDisplayed();", element);
            return isInvisible;
        });
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d ->
        {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete'");
            return isPageLoaded;

        });
    }


    public static void clickAndWaitForElementPresent(WebDriver driver, WebElement clickElement, WebElement waitElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> {
            Boolean isPresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].isDisplayed();", waitElement);
            return isPresent;
        });
    }


    public static void clickAndWaitForElementClickable(WebDriver driver, WebElement clickElement, WebElement waitElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> {
            Boolean isClickable = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].isEnabled();", waitElement);
            return isClickable;
        });
    }


    public static void clickAndWaitForElementInvisible(WebDriver driver, WebElement clickElement, WebElement waitElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) d -> {
            Boolean isInvisible = (Boolean) ((JavascriptExecutor) driver).executeScript("return !arguments[0].isDisplayed();", waitElement);
            return isInvisible;
        });
    }


    public static void clickOnElementById(WebDriver driver, String id) {
        ((JavascriptExecutor) driver).executeScript("document.getElementById('" + id + "').click();");
    }


    public static void clickOnElementByXpath(WebDriver driver, String xpath) {
        ((JavascriptExecutor) driver).executeScript("document.evaluate(\"" + xpath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
    }


    public static void clickOnElementByCoordinates(WebDriver driver, WebElement element) {
        Point coordinates = (Point) ((JavascriptExecutor) driver).executeScript("return arguments[0].getBoundingClientRect();", element);
        ((JavascriptExecutor) driver).executeScript("document.elementFromPoint(" + coordinates.getX() + "," + coordinates.getY() + ").click();");
    }

}
