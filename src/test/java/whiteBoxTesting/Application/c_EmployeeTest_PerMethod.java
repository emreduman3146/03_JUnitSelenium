package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;
import whiteBoxTesting.Application.OOP_Program.EmployeeException;
import whiteBoxTesting.Application.OOP_Program.Employee_Entity;
import whiteBoxTesting.Application.OOP_Program.Employee_Service;

import java.util.ArrayList;
import java.util.List;

@Tag("UnitTest")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)//bu bir kaliptir
//yukardaki ifade default'tur. Yani yukardaki ifadeyi yazmasak da test classimiz ayni mantikta calisir

@Disabled("Developer bug'i fix etti, QA olan ben disabled ettim methodlarin da calismasini istiyorum artik.")
//bu classin icindeki @Test lerin hepsi disabled olsun gibi dusunmus olabilrisin ama bu mantikta calismaz
//calisma mantigi-> disabled edilmis tum methodlar calismaya devam eder



@TestMethodOrder(MethodOrderer.MethodName.class)//alphabetic siraya gore
//eger testlerin sirayla calismasi adina herhangi bir tag kullanmaz isek @Test methodlari tamamen random/kafasina gore bir siraya gore calsiir
public class c_EmployeeTest_PerMethod


{
    static List<Employee_Entity> empList;
    static Employee_Entity emp01;
    static Employee_Service employee_service;
    static Employee_Entity employee_entity;

    static int sayi1=1;
    int sayi2=10;


    //test classimizin construcr methodu da her @Test methodundan once 1 kez calisir.
    //Ayni @BeforeEach methodunun calistigi gibi
    public c_EmployeeTest_PerMethod()
    {
        System.out.println("Default Constructor calisiyor");
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }

    @BeforeAll//bu method static olmalidir, yoksa error aliriz
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static void setUp(TestInfo testInfo)
    {

        System.out.println(testInfo.getTags()+" execution started!");

        //gerekli objeler initialize ediliyor
        employee_entity =new Employee_Entity();
        employee_service=new Employee_Service();

        //Bir tane bos employeeList'imiz var
        empList = new ArrayList<>();

        //Bir tane bos employeeList'imiz var
        emp01=new Employee_Entity(1,"Test Developer",300000.0);


        employee_entity.setEmpList(empList);
        Assertions.assertTrue(employee_entity.getEmpList().isEmpty());

        System.out.println("Test preconditions are done!!!");
    }

    @BeforeEach
    void setUp_list(TestInfo testInfo)
    {
        System.out.println(sayi1++);
        System.out.println(sayi2++);

        System.out.println(testInfo.getDisplayName()+" started!");
    }



    @Test
    void employeeAddTest(TestInfo testInfo)
    {
        System.out.println(sayi1++);
        System.out.println(sayi2++);

        employee_service.addEmployee(emp01);
        Assertions.assertNotEquals(employee_entity.getEmpList().size(),0);
        Assertions.assertEquals(employee_entity.getEmpList().size(),1);
        Assertions.assertEquals(employee_entity.getEmpList().get(0).getSalary(),300000.0);
        Assertions.assertFalse(employee_entity.getEmpList().get(0).getSalary()==400000.0);
    }


    @Test
    @Disabled("Skipped/es gecildi this test till the developer fix/tamir etmek the bug")//!!!
    //WebDeveloper siteyi develop ederken bir sey iyanlis yazmis. ve bunu duzeltmek adina 2 gun istemis
    void employeeRemoveTest()
    {

        System.out.println(sayi1++);
        System.out.println(sayi2++);
        int initialEmpSize=+employee_entity.getEmpList().size();
        employee_service.removeEmployee(emp01);
        Assertions.assertTrue(--initialEmpSize==employee_entity.getEmpList().size());
    }

    @Test
    //@Disabled("Skipped this test till the developer fix the bug")
    void employeeRemoveByIdTest()
    {

        System.out.println(sayi1++);
        System.out.println(sayi2++);
        Employee_Entity testEmployee=new Employee_Entity(2,"SDET",120000.0);
        employee_service.addEmployee(testEmployee);
        System.out.println(employee_entity.getEmpList());


        Assertions.assertThrows(EmployeeException.class,()->employee_service.removeEmployeeByID(3));
    }







    @AfterEach
    void afterTest(TestInfo testInfo)
    {
        System.out.println(sayi1++);
        System.out.println(sayi2++);
        System.out.println(testInfo.getDisplayName()+" finished!");

    }

    @AfterAll
    static void tearDown(TestInfo testInfo)
    {
        System.out.println(testInfo.getTags()+" execution completed!");
    }


}
