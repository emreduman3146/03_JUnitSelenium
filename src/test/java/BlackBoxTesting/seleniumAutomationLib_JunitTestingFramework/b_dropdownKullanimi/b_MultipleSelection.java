package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.b_dropdownKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class b_MultipleSelection
{

    static Select select;
    static WebElement multiSelectDropdown;
    List<WebElement> selectedOptions;


    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        getDriver().navigate().to("https://demoqa.com/select-menu");
        Thread.sleep(1000);
        System.out.println("Navigated to the URL!");

        multiSelectDropdown=getDriver().findElement(By.xpath("//*[@id='cars']"));
        select = new Select(multiSelectDropdown);

    }


    @Test
    public void _isMultiple_deselect()
    {

        if(select.isMultiple())
        {

            //Selecting multiple options by index
            select.selectByIndex(0);
            select.selectByIndex(1);
            select.selectByIndex(2);
            select.deselectByIndex(1);
            select.deselectAll();

            //Or selecting by values
            select.selectByValue("volvo");
            select.selectByValue("audi");
            select.deselectByValue("audi");

            //Or selecting by visible text
            select.selectByVisibleText("Volvo");
            select.selectByVisibleText("Opel");
            select.deselectByVisibleText("Opel");
        }
        else
            System.out.println("This dropdown is not proper to do multiple selection!!!");


    }

    @Test
    public void _getOptions()
    {
        //Get list of web elements
        selectedOptions = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown'daki tum optionlar yazdir:");

        for(WebElement options: selectedOptions)
            System.out.println(options.getText());

        System.out.println("==================================");


        //List'i tek tek siraya diz
        //tek tek elemanlari gez
        //ugradigin elementlerin uzerinde islem yap
        //islemler bittikten sonra elementleri tekrardan tek tek gez
        // ugradigini yazdir
        selectedOptions.stream().map(WebElement::getText).forEach(System.out::println);
    }



}
