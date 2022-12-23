package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.f_switchToKullanimi.windowHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class c_MultipleWindows {


    @BeforeAll
    static void setUp()
    {

        getDriver().get("https://demoqa.com/browser-windows");

        getDriver().findElement(By.id("windowButton")).click();
        getDriver().findElement(By.id("messageWindowButton")).click();


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
                getDriver().close();//QUIT: BIR SESSIONDAKI TUM TABLERI/WINDOWLARI KAPATIR
                System.out.println("Child window closed");
            }
        }
    }


}

