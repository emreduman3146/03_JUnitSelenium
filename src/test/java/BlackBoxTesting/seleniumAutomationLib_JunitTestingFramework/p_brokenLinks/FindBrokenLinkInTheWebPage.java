package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.p_brokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindBrokenLinkInTheWebPage
{
    static int brokenLinkCount=0;
    static String mainUrl = "https://www.youtube.com/";

    public static void main(String[] args) {
        startProgramToFindBrokenLinks(mainUrl);
    }

    private static void startProgramToFindBrokenLinks(String mainUrl) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));

        // Navigate to the website
        driver.get(mainUrl);

        // Get all the links on the page
        List<WebElement> links_webElements = driver.findElements(By.tagName("a"));
        System.out.println("Number of link in the webPage-> "+links_webElements.size());

        // List<String > links_String = links_webElements.stream().
        //                               map(e -> e.getAttribute("href")).
        //                                     collect(Collectors.toList());

        // links_String.forEach(System.out::println);


        List<String > links_String = links_webElements.stream().
                map(e -> e.getAttribute("href")).
                // filter(e-> e!=null).
                // filter(e-> !e.isEmpty()).
                // filter(e->e.startsWith(amazonMainUrl)).
                        collect(Collectors.toList());


        // System.out.println("links_String.size() = " + links_String.size());

        links_String.forEach(System.out::println);

        links_String.parallelStream().forEach(FindBrokenLinkInTheWebPage::checkIfThisLinkBroken);
        System.out.println("Broken Link count->"+brokenLinkCount);

    }


    private static void checkIfThisLinkBroken(String linkUrl)
    {

        try
        {
            URL url=new URL(linkUrl);

//Methods in the HttpURLConnection class will send HTTP requests and capture the HTTP response code.
// Therefore, the output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.setRequestMethod("HEAD");

//When the tester invokes the connect() method, the actual connection to the URL is established and the HTTP request is sent.
            httpURLConnection.connect();

//Use the getResponseCode() method to get the HTTP response code for the previously sent HTTP request.
            int responseCode = httpURLConnection.getResponseCode();

            // If the response code is not 200 (OK), then the link is broken
            if (responseCode >=400) {
                System.out.println("Broken link: " + url);
                brokenLinkCount++;
            }
        }
        catch (Exception e) {
            System.out.println(e+"-------"+linkUrl);
            brokenLinkCount++;

        }

    }
}

