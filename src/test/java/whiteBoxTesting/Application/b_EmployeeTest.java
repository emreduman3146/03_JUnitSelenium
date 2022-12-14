package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import whiteBoxTesting.Application.OOP_Program.Employee_Entity;
import whiteBoxTesting.Application.OOP_Program.Employee_Service;
import java.util.ArrayList;
import java.util.List;

@Tag("UnitTest")
@DisplayName("Employee_Service Classi methodlari test ediliyor")

//@TestMethodOrder(MethodOrderer.MethodName.class)//alphabetic siraya gore
//@TestMethodOrder(MethodOrderer.Random.class)//bu defaulttur yazmasak da olur. tamamen random sirayla testler calisir
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class b_EmployeeTest
{
    static List<Employee_Entity> empList;//null
    static Employee_Entity emp01;//null
    static Employee_Service employee_service;//null - not initialized
    static Employee_Entity employee_entity;//null

    @BeforeAll//bu method static olmalidir, cunku sadece1 kez calisir class ozgudur
    static void setUp(TestInfo testInfo)
    {
        System.out.println(testInfo.getTags()+" execution started!");

        //gerekli objeler initialize ediliyor
        //nu classlara erisip onlarin icindeki variable/methodlari kullanmak icin/ test etmek iccin
        employee_entity =new Employee_Entity();
        employee_service=new Employee_Service();

        //Bir tane bos employeeList'imiz var
        empList = new ArrayList<>();

        //Bir tane bos employeeList'imiz var
        emp01=new Employee_Entity(1,"Test Developer",300000.0);


        employee_entity.setEmpList(empList);
        Assertions.assertTrue(employee_entity.getEmpList().isEmpty());

        System.out.println("Test preconditions/onsartlar/on gereklilikler are done/yapildi!!!");
    }

    @BeforeEach
    void setUp_list(TestInfo testInfo)
    {
        //bildiri mesaji yazdirmisiz
        System.out.println(testInfo.getDisplayName()+" started!");
    }


    //developer olarak yazdigim oop programda bazi metholar vardi
    //bu methodlarin/unitlerin algorithmasinin test edilmesine sira geldi
    //addEmployee methodunuu testi yapiliyor
    @Test
    @DisplayName("Add employee to the list")
    @Order(1)
    void employeeAddTest(TestInfo testInfo)
    {


        employee_service.addEmployee(emp01);//ahmet iscisi listeye eklendi. listenin icindeki eleman sayii 0'dan 1 'e cikti

      //sira geldi istedigim methodun assert edilmesine/kiyaslanmasina/dogrulanmasina geldi
        //4 tane assertion iminz var, eger 1 tanesi bile fail verirse @Test fail olur

        Assertions.assertNotEquals(employee_entity.getEmpList().size(),0);
        Assertions.assertEquals(employee_entity.getEmpList().size(),1);


        Assertions.assertTrue(employee_entity.getEmpList().get(0).getSalary()==300000.0);
        Assertions.assertFalse(employee_entity.getEmpList().get(0).getSalary()==400000.0);//pass
    }

    @Test
    @DisplayName("Remove employee to the list")
    @Order(2)
    void employeeRemoveTest()
    {

        employee_service.removeEmployee(emp01);

        //beklentim su, elimdeki employeelistin bos olmasi lazim
        //elimdeki liste bos ise/isEmpty() ise true doner, bos degilse false doner
        Assertions.assertTrue(empList.isEmpty());
    }



    @AfterEach
    void afterTest(TestInfo testInfo)
    {
        System.out.println(testInfo.getDisplayName()+" finished!");

    }

    @AfterAll
    static void tearDown(TestInfo testInfo)
    {
        System.out.println(testInfo.getTags()+" execution completed!");
    }


}
