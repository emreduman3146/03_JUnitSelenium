package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.l_takeScreenshots.pdfOkumaYazma_ile_SsleriKaydetme;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.io.FileOutputStream;


public class TakeScreenshots_and_PutInPDF
{

    private static WebDriver driver;

    @BeforeAll
    static void setUp()
    {
        //LAUNCH BROWSER
        driver= WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //URL'YE NAVIGATE ET
        driver.get("https://youtube.com");
    }

    @Test
    void getScreenShot01(){

        try
        {
            //BULUNDUGUN SAYFANIN EKRAN GORUNTUSUNU AL
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;

            //ALINAN SS'NIN BYTE FORMATINA DONUSTURULMESI GEREKIYOR
            byte[] ekranGoruntusuDosyasi = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            byte[] ekranGoruntusuDosyasi2 = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            byte[] ekranGoruntusuDosyasi3 = takesScreenshot.getScreenshotAs(OutputType.BYTES);


            //ITEXT DEPENEDCY'DEN GELIYOR- bir pdf documenti, path icerigi falan hic belli
            Document document = new Document();

            String path="src/test/java/BlackBoxTesting/seleniumAutomationLib_JunitTestingFramework/l_takeScreenshots/pdfOkumaYazma_ile_SsleriKaydetme/ekranGoruntusu.pdf";

            //BYTE TIPINDEKI DATA WRITE EDILMESINI SAGLAR
            FileOutputStream fos = new FileOutputStream(path);

            PdfWriter writer = PdfWriter.getInstance(document, fos);

            //PDF'I YAZMAK ICIN ACMALIYIZ
            writer.open();
            document.open();


            //ELIMIZDEKI BYTE DATA'YI IMAGE FORMATINA DONUSTURUR
            Image image = Image.getInstance(ekranGoruntusuDosyasi);
            Image image2 = Image.getInstance(ekranGoruntusuDosyasi2);
            Image image3 = Image.getInstance(ekranGoruntusuDosyasi3);

            //IMAGE'IN PDF ICINE YERLESTIRILMEDEN ONCE BOYUT AYARLARININ YAPILMASI
            image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            image2.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);
            image3.scaleToFit(PageSize.A4.getWidth()/3, PageSize.A4.getHeight()/3);


            //IMAGE'I PDF'E EKLE
            document.add(new Paragraph("BU BENIM ILK EKRAN GORUNTUM IN PDF\n\n"));
            document.add(image);
            document.add(new Paragraph("BU BENIM IKINCI EKRAN GORUNTUM IN PDF\n\n"));
            document.add(image2);
            document.add(new Paragraph("BU BENIM UCUNCU EKRAN GORUNTUM IN PDF\n\n"));
            document.add(image3);

            //PDF'E BIR CUMLE YAZ

            //PDF'I KAPAT
            document.close();
            writer.close();


        }
        catch (Exception exception){
            exception.printStackTrace();
        }


    }

    /*
    Bazen Selenium testlerini çalıştırırken, yakalanan ekran görüntüsünü bir PDF dosyasında saklamamız gerekebilir.
    Ancak Selenium bu işlemi gerçekleştirmez, bu yüzden Java dilinde bulunan kütüphanelerden yardım almak zorundayız.
    Bu nedenle, ekran görüntüsünü bytes[] dizisi olarak saklayacağız ve iText yardımcı sınıflarına geçireceğiz.
     */
}