package whiteBoxTesting.Application;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.suite.api.*;


@SelectPackages({"whiteBoxTesting.Application"})// "," koyarak 1'den fazla package ismi verilebilir
                                                //Run etmek istedigimiz @Test lerin packagelarini yazariz

//yukarida pathini veridgimiz package'in icinde sub-package'lar olabilir
//ve biz bu sub-packagelardan da bazilarini include, bazilarini exclude yapmak isteyebilirz
//o zaman asagidaki tagleri kullanip sub-package isimlerini parametre olarak verebiliriz
//bizim projemizde "whiteBoxTesting.Application"in icinde herhangi bir sub-package olmadigi icin parametre koymadik
//@IncludePackages("whiteBoxTesting.Application.TestSuiteIcinSubPackage")
//@ExcludePackages("whiteBoxTesting.Application.TestSuiteIcinSubPackage")



@SelectClasses( {d_EmployeeTest_PerClass.class} )//package pathini verdigim classlardan hangisi calsiitmak istiyorsam adini yazarim

//Yukaridaki @SelectClasses tagi bizden test class isimleri girmemeizi ister
//@IncludeClassNamePatterns tagi ise, girecegimiz parametre yi kolaylastirir
//mesela sonu ".....Testing" ile biten tum testclasslarini include etmek icin asagidaki kodu kullaniriz
//@IncludeClassNamePatterns({"^.*Test$"})

//bu tag ise basi "e" ile baslayan test classlarini exclude eder, bu classslardaki @Testler run edilmeyecek
@ExcludeClassNamePatterns({"^.*Test?$"})



//Classlarin icindeki @Test methodlarinin bazilari tag verebiliriz
//Tag vermemizin bir diger amaci o test methodlarini buradaki Suite classtan yonetebilmektir
//Asagidaki 2 tagi kullanrak istedigim tagleri run eder ya da run etmem
//@IncludeTags({"multiplyMethodu","addMethodu"})
//@ExcludeTags("")



@Suite//Bu tag sayesinde, bu suite class, pathini verdigimiz testleri yonetebilme kabiliyeti kazanir.
@SuiteDisplayName("A demo Test Suite")
public class JUnit5TestSuiteExample
{


    /*
    DEFAULT AYARLARINDA SONU "TEST" ILE BITEN CLASSLARI RUN EDER


    "YUKARIDAKI SARI TAGLER junit-platform-suite DEPENDENCY'DEN GELIR.\n" +
    "Sol panelde/folder structure'da sahip oldugumuz testleri yonetmemize yararlar.\n" +
    "Onlarca, yulerce @Test methodlarinin filtrelemesini yapariz");

     */

    @Test
    public void testSuiteClassininKendisineAitTestMethodu()
    {
        Assertions.assertTrue(true);
    }


}