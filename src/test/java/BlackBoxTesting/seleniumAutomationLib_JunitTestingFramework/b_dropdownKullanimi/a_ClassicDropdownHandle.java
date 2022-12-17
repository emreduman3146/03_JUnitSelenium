package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_dropdownKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class a_ClassicDropdownHandle
{

    static Select select;//null
    static WebElement oldDropDown;
    List<WebElement> selectedOptions;


    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        getDriver().navigate().to("https://demoqa.com/select-menu");
        Thread.sleep(1000);
        System.out.println("Navigated to the URL!");

        //classicDropdownElementimiz
        oldDropDown=getDriver().findElement(By.xpath("//*[@id='oldSelectMenu']"));

        select = new Select(oldDropDown);
        //parantez icindeki parameter eolarak verecegimiz webelement <select> olmak zorunda


    }

    @Test
    public void _selectByVisibleText()
    {

        String testdata="White";


        select.selectByVisibleText(testdata);

        selectedOptions=select.getAllSelectedOptions();
        System.out.println("selectedOptions.size() = " + selectedOptions.size());

        //JAVA BILGISI: Collection data structurelarini/yapilarini yazdirmanin kisa yolu
        //selectedOptions.stream().forEach(System.out::println);


        //java bilgisi: foreach loop'u
        for(WebElement element:selectedOptions)
        {
            String actualData;
            System.out.println(actualData=element.getText());
            Assertions.assertEquals(testdata,actualData);
        }

    }

    @Test
    public void _selectByIndex()
    {
        int index=1;
        select.selectByIndex(index);

        index=5;
        select.selectByIndex(index);

        index=0;
        select.selectByIndex(index);
    }

    @Test
    public void _selectByValue()
    {

        //default olarak gozukecek olan degerdir.
        WebElement firstOption=select.getFirstSelectedOption();
        System.out.println("firstOption.getText() = " + firstOption.getText());

        String value="1";
        select.selectByValue(value);
        System.out.println("firstOption.getText() = " + select.getFirstSelectedOption().getText());


        value="5";
        select.selectByValue(value);
        System.out.println("firstOption.getText() = " + select.getFirstSelectedOption().getText());


        value="red";
        select.selectByValue(value);

    }

    @Test
    public void _dontUseThisApproach()
    {
        WebElement options=getDriver().findElement(By.xpath("//option[text()='Blue']"));
        options.click();

        options=getDriver().findElement(By.xpath("//option[text()='Volvo']"));
        options.click();

        //Multiple select'in ilkel yollarla yapilis sekli
        //Actions Classi ile olabilir.
        //Actions Class ile klavyeyi kullanabiliyoruz
        //CTRL BASILI TUT ve locatorini verdigim elemente click yap denebilir
    }


}
