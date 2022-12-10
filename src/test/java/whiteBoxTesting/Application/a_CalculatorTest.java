package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;



//WHITEBOX TESTING DEVELOPER TARAFINDAN YAPILIR
    //KODLARI YAZAN KISININ DIREK KODLARIN DUZGUN CALISIP CALISMADIGINA BAMA ISLEMIDIR
//BLACKBOX TESTING QA TARAFINDAN YAPILAN TEST
public class a_CalculatorTest
{

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
        System.out.println("CalculatorProgram.add(5,6,7) = " + CalculatorProgram.add(5, 6, 7));
        //Testin Mantigi nedir?
            //testin mantigi nedir, bir kiyas yapmaliyiz.
            //testdata'miz olur ve bir sonuc,cikti bekleriz.
            //beklentimiz ile cikan sonuc aynimi diye bakariz

        //Dogrulamak-kiyas1
        //testdata->5,6,7
        //expectedResult:18
        //actualResult:18
        System.out.println(CalculatorProgram.add(5,6,7)==18);//true
        Assertions.assertTrue(CalculatorProgram.add(5,6,7)==18);//pass oldu


        //kiyas2
        //testdata->5,6,8
        //expectedResult:19
        //actualResult:19
        System.out.println(CalculatorProgram.add(5,6,7)==19);//false
        Assertions.assertTrue(CalculatorProgram.add(5,6,8)==19);//fail oldu
    }






    @Test
    //WHITEBOXTESTING, BUNU QAciler bilmez
    //unit testing-> developerin yazdigi methodun calismasini test etmesi
    void add_positiveTest()
    {
        System.out.println("");
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,5),15);
        Assertions.assertEquals(CalculatorProgram.add(1,2,3,4,-5),5);
    }

    @Test
    @DisplayName("Adding all given numbers_negative")
    protected void add_negativeTest()
    {
        Assertions.assertNotEquals(CalculatorProgram.add(1,2,3,4,5),14);
        Assertions.assertNotEquals(CalculatorProgram.add(1,2,3,4,-5),15);
    }

    @Test
    @DisplayName("Multiply all given numbers_positive")
    public void multiply_positiveTest(TestInfo testInfo)
    {
        System.out.println("className = " + testInfo.getTestClass());
        System.out.println("methodName = " + testInfo.getTestMethod());
        System.out.println("displayName = " + testInfo.getDisplayName());


        Assertions.assertEquals(CalculatorProgram.multiply(1,2,3,4,5),120);
        Assertions.assertEquals(CalculatorProgram.multiply(1,2,3,4,5,0),0);
    }



    @Test
    @DisplayName("Multiply all given numbers_negative")
    @Tag("UnitTest")
    public void multiply_negativeTest(TestInfo testInfo)
    {
        System.out.println("tags = " + testInfo.getTags());


        Assertions.assertNotEquals(CalculatorProgram.multiply(1,2,3,4,5),150);
        Assertions.assertNotEquals(CalculatorProgram.multiply(1,2,3,4,5,0),120);

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