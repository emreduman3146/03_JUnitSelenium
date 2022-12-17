package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.b_dropdownKullanimi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class c_DivDropdownHandle
{

    static Select select;
    static WebElement divDropDown;

    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        getDriver().navigate().to("https://demoqa.com/select-menu");
        Thread.sleep(1000);
        System.out.println("Navigated to the URL!");

        //InvalidSelectorException
        //Cunku bu dropdown <select> degil
        //divDropDown =getDriver().findElement(By.xpath("( //div[@class=' css-tlfecz-indicatorContainer'])[2]"));
        //select = new Select(divDropDown);

    }




    @Test
    public void _divLikeDropDown()
    {

        //Sonradan olusan dropdown'a tiklayamazsin
        //NoSuchElementException
        //getDriver().findElement(By.id("react-select-3-option-0-1")).click();


        //select.selectByIndex(4);


        WebElement dropDownButton=getDriver().findElement(By.xpath("( //div[@class=' css-tlfecz-indicatorContainer'])[2]"));
        dropDownButton.click();

        if (getDriver().findElement(By.xpath(" //div[@class=' css-26l3qy-menu']")).isDisplayed())
        {
            getDriver().findElement(By.xpath("//*[.='Mrs.']")).click();
        }


    }


    @Test
    public void _divLikeDropDown_multipleSelection()
    {


        WebElement dropDownButton=getDriver().findElement(By.xpath("( //div[@class=' css-tlfecz-indicatorContainer'])[3]"));
        dropDownButton.click();

        WebElement menu = getDriver().findElement(By.xpath(" //div[@class=' css-26l3qy-menu']"));
        if (menu.isDisplayed())
        {
            /*
            getDriver().findElement(By.xpath("//div[.='Green']")).click();
            getDriver().findElement(By.xpath("//div[.='Blue']")).click();
            getDriver().findElement(By.xpath("//div[.='Black']")).click();
            getDriver().findElement(By.xpath("//div[.='Red']")).click();
            */

            List<WebElement> allOptions = getDriver().findElements(By.xpath("//div[contains(@id,'react-select-4-option-')]"));
            allOptions.stream().forEach(WebElement::click);
        }


    }


}
