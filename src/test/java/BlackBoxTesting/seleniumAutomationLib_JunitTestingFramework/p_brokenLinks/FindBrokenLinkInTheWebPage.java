package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.p_brokenLinks;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindBrokenLinkInTheWebPage
{

    static int brokenLinkCount=0;
    static String mainUrl="https://www.walmart.com/";

    public static void main(String[] args) {

        startProgramToFindBrokenLinks(mainUrl);

    }

    private static void startProgramToFindBrokenLinks(String mainUrl) {

        //launching chrome
        WebDriver driver= WebDriverManager.chromedriver().avoidShutdownHook().create();

        //implicitly wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10L));

        //navigate to page
        driver.get(mainUrl);

        //get all links on the page
        List<WebElement> tumLinkOlanWebelementlerinOlduguListe= driver.findElements(By.tagName("a"));
        System.out.println("Tum link sayisi->"+tumLinkOlanWebelementlerinOlduguListe.size());

        List<String> string_List_of_links=tumLinkOlanWebelementlerinOlduguListe.
                                                                        parallelStream().
                                                                        map(e->e.getAttribute("href")).
                                                                        collect(Collectors.toList());

        string_List_of_links.parallelStream().forEach(System.out::println);

        string_List_of_links.parallelStream().forEach(FindBrokenLinkInTheWebPage::checkIfThisLinkBroken);

        System.out.println("Broken link sayisi-->"+brokenLinkCount);



    }

    private static void checkIfThisLinkBroken(String url)
    {
        try
        {
            URL linkURL=new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) linkURL.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();

            int responseCode_httpCode=httpURLConnection.getResponseCode();

            if(responseCode_httpCode>=400)
            {
                System.out.println("This Link is broken->>" +url);
                brokenLinkCount++;
            }

        }
        catch (Exception e)
        {

            System.out.println(e+"------"+ url);
            brokenLinkCount++;
        }
    }
}
