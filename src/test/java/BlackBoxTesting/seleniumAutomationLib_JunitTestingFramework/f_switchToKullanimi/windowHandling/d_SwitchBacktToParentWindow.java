package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.windowHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class d_SwitchBacktToParentWindow {


    static WebElement newWindow;

    @BeforeAll
    static void setUp()
    {

        getDriver().get("https://demoqa.com/browser-windows");

        newWindow=getDriver().findElement(By.id("windowButton"));
        newWindow.click();


    }



    @Test
    void _switchTo_window_with_iterator()
    {


        //ANA WINDOW'UN BILGISINI TUTAR
        String MainWindow = getDriver().getWindowHandle();
        System.out.println("ANA WINDOW'UM= " + MainWindow);

        //CHILD WINDOWLARIN BILGISINI SET'TE TUTAR
        Set<String> s1 = getDriver().getWindowHandles();
        System.out.println("CHILD WINDOWS\n" + s1);


        Iterator<String> i1 = s1.iterator();


        while (i1.hasNext())
        {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                getDriver().switchTo().window(ChildWindow);
                WebElement text = getDriver().findElement(By.id("sampleHeading"));
                System.out.println("text = " + text);

                getDriver().close();
                System.out.println("Child window closed");
            }
        }

        //PARENT WINDOW'A SWITCH BACK YAPIYORUZ
        getDriver().switchTo().window(MainWindow);
        System.out.println("newWindow.getText() = " + newWindow.getText());
    }


}

