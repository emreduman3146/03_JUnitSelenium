package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static whiteBoxTesting.Application.CalculatorProgram.add;
import static whiteBoxTesting.Application.CalculatorProgram.multiply;


//WHITEBOX TESTING DEVELOPER TARAFINDAN YAPILIR
    //KODLARI YAZAN KISININ DIREK KODLARIN DUZGUN CALISIP CALISMADIGINA BAMA ISLEMIDIR
//BLACKBOX TESTING QA TARAFINDAN YAPILAN TEST


public class a_CalculatorTest
{

    //nonstatik variable static methodtan direk cagrilamaz
    static a_CalculatorTest obje = new a_CalculatorTest();


    //main methodu @Test methodlarini yonetmek/run etmek icin kullanilmaz
    public static void main(String[] args) {

        //non-static method static method icinden obje olusturularak cagirilir.
        obje.addMethodumuTestEt();
    }

    @BeforeAll
    static void setUp_class()
    {
        System.out.println("Class calisinca ilk bu method calisir!!!");
    }

    @BeforeEach//her @Test'ten once calisan methodlardir. Bagimli methodlardir. Tek baslarina hicbir seye yaramazlar
    void setUp_method()
    {
        System.out.println("Her @TEST Annotation'dan once calisir!!!");
    }



/*
    //Bu testlere Unit testing denir
    //Developerlar kendi yazdiklari program icin bazi methodlar olusturular.
    //Nasilki biz QA'ler hazir methodlar yaziyorsak
    //Daha sonrasinda ise yazdiklari methodlarin cidden dogru calisip calismadiklarini test etmek zorundadirlar
    //Programlamanin en kucuk birimi olan methodlarin test edilmesine -> UNIT TESTING DENIR
    //Developerlar tarafinca yaoilir.
    //Kendi kodlarini gordukleri icin bu "UNIT TESTING" islemi "WHITE-BOX TESTING" kategorisinde bulunur
*/

/*
    //JAVA BILGISI
        //import BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.Application.CalculatorProgram; ile CalculatorProgram classina erisimin yolunu actik
        //"ClassAdi.staticMethodAdi" yoluyla da bu classtaki static methodlara erisebiliriz.

        //import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.Application.CalculatorProgram.*; ile de CalculatorProgram classinin icindeki tum static yapilara erisim yolunun actik.
        //"staticMethodAdi" yoluyla da bu classtaki static methodlara erisebiliriz.
*/

    //bu test methodu bir whiteboxtesting'dir
    //alt kategorisi unit testingtir
    //QA,biz, yapmayiz, developer yapmak zorundadir
    @Test//test methodlari static olmamali
    void addMethodumuTestEt()
    {
        System.out.println("CalculatorProgram.add(5,6,7) = " + add(5, 6, 7));
        //Testin Mantigi nedir?
            //testin mantigi nedir, bir kiyas yapmaliyiz.
            //testdata'miz olur ve bir sonuc,cikti bekleriz.
            //beklentimiz ile cikan sonuc aynimi diye bakariz

        //Dogrulamak-kiyas1
        //testdata->5,6,7
        //expectedResult:18
        //actualResult:18
        System.out.println(add(5,6,7)==18);//true
        Assertions.assertTrue(add(5,6,7)==18);//true ->pass oldu


        //kiyas2
        //testdata->5,6,8
        //expectedResult:19
        //actualResult:19
        System.out.println(add(5,6,7)==19);//false
        Assertions.assertTrue(add(5,6,8)==19);//false ->fail oldu
    }






    //bir developer olarak kedni yazdigimiz/arkadasimizin yazdigi method/unitleri
    //test ederken bir  positive scenario bir negative scenario yazmaliyiz
    //yazdigimiz bir method ya dogru calisir ya da yanlis calisir

    //kullanicidan 0-100 arasi bir int deger al
    //    ....-0-101-....
    @Test
    //WHITEBOXTESTING, BUNU QAciler bilmez
    //unit testing-> developerin yazdigi methodun calismasini test etmesi
    void add_positiveScenarioTest()
    {
        //java bilgisi-> static method ClassAdi.staticMethodAdi ile cagirilir
        //ya da static import edilerek direk kullanilir
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,5),15.000000);//java akilliydi int ve double'i kiyaslarken .0000 i kaldirir
        Assertions.assertEquals(add(1,2,3,4,-5),5);
    }

    @Test
    //display= gostermek
    @DisplayName("Adding all given numbers_ for negative scenario..........")
    protected void add_negativeScenarioTest()//testin fail etmesini istiyoruz demek degildir.
    {
        Assertions.assertNotEquals(add(1,2,3,4,5),16);//ILK PARAM ILE 2.param esit degilse pass olur
        Assertions.assertNotEquals(add(1,2,3,4,-5),15);
    }

    //Test yaparken her zaman PASS almaliyiz




    @Test
    @DisplayName("Multiply all given numbers_positive")
    public void multiply_positiveScenarioTest(TestInfo testInfo)
    {
        //java bilgisi-> interfacelerden direk obje olusturulmaz
        //polimorphism yapilarak interfacein child'dan obje olusturulabilir.
        //TestInfo testInfo = new ChildClassName();
        //JUnit frameworku testInfo variable'ini kendisi otomatik initialize eder
        //biz testInfo = new ChildClassIsmi(); yazarak initialize etmek zorunda kalmayiz
        //Suanlik sadece ve sadece methodun icinde kullanilir

        System.out.println("className = " + testInfo.getTestClass());//null pointerexception hatasi almiyoruz
        System.out.println("methodName = " + testInfo.getTestMethod());
        System.out.println("displayName = " + testInfo.getDisplayName());


        Assertions.assertEquals(CalculatorProgram.multiply(1,2,3,4,5),120);//eger actual result 120 ise bu kiyaslama pass olur
        Assertions.assertEquals(multiply(1,2,3,4,5,0),0);
    }



    @Test
    @DisplayName("Multiply all given numbers_negative")
    @Tag("UnitTest")//whiteBoxTesting 'in alt category si olan unitTest yaptigimizi resmilestirmek icin bu tagi koyariz
    //Developerlarin yapmak zorunda oldugu testler-> unitTesting<integrationTesting<systemSystem<userAcceptanceTesting
    public void multiply_negativeTest(TestInfo testInfo)
    {

        System.out.println("tags = " + testInfo.getTags());


        Assertions.assertNotEquals(multiply(1,2,3,4,5),150);// eger 2 params birbirine notEquals ise pass olur
        Assertions.assertNotEquals(multiply(1,2,3,4,5,0),120);

    }


    @AfterEach//her @Test'ten sonra calisan methodlardir. Bagimli methodlardir. Tek baslarina hicbir seye yaramazlar
    void tearDown_method()
    {
        System.out.println("Her @TEST Annotation'dan sonra calisir!!!");
    }

    @AfterAll
    //tumm classin icindeki ifadeler icin sadece 1 kez calisir
    //diyalimki 4 tane @test calistirdiniz
    // bu method sadece en sonda 1 kez calisir
    static void tearDown_class()
    {
        System.out.println("Class bitiminden once bu method calisir!!!");
    }



}