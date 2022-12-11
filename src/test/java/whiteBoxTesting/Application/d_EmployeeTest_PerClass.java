package whiteBoxTesting.Application;

import org.junit.jupiter.api.*;
import whiteBoxTesting.Application.OOP_Program.EmployeeException;
import whiteBoxTesting.Application.OOP_Program.Employee_Entity;
import whiteBoxTesting.Application.OOP_Program.Employee_Service;

import java.util.ArrayList;
import java.util.List;

@Tag("UnitTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Disabled("Skipped All unit test till Jan 01, 2022")
@TestMethodOrder(MethodOrderer.MethodName.class)//alphabetic siraya gore



public class d_EmployeeTest_PerClass
{
    static List<Employee_Entity> empList;
    static Employee_Entity emp01;
    static Employee_Service employee_service;
    static Employee_Entity employee_entity;

    static int sayi1=1;
    int sayi2=10;

    //test classimizin constructori
    public d_EmployeeTest_PerClass()
    {
        System.out.println("Default Constructor calisiyor");
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }
    @BeforeAll//bu method static olmalidir, yoksa error aliriz
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    void setUp(TestInfo testInfo)
    {
        System.out.println(testInfo.getTags()+" execution started!");
        System.out.println(sayi1++);
        System.out.println(sayi2++);

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

        System.out.println(testInfo.getDisplayName()+" started!");
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }


    @Test
    void employeeAddTest(TestInfo testInfo)
    {

        employee_service.addEmployee(emp01);
        Assertions.assertNotEquals(employee_entity.getEmpList().size(),0);
        Assertions.assertEquals(employee_entity.getEmpList().size(),1);
        Assertions.assertEquals(employee_entity.getEmpList().get(0).getSalary(),300000.0);
        Assertions.assertFalse(employee_entity.getEmpList().get(0).getSalary()==400000.0);
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }

    @Test
    @Disabled("Skipped this test till the developer fix the bug")
    void employeeRemoveTest()
    {
        int initialEmpSize=+employee_entity.getEmpList().size();
        employee_service.removeEmployee(emp01);
        Assertions.assertTrue(--initialEmpSize==employee_entity.getEmpList().size());
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }

    @Test
    @Disabled("Skipped this test till the developer fix the bug")
    void employeeRemoveByIdTest()
    {
        Employee_Entity testEmployee=new Employee_Entity(2,"SDET",120000.0);
        employee_service.addEmployee(testEmployee);
        System.out.println(employee_entity.getEmpList());


        Assertions.assertThrows(EmployeeException.class,()->employee_service.removeEmployeeByID(3));
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }


    @AfterEach
    void afterTest(TestInfo testInfo)
    {
        System.out.println(testInfo.getDisplayName()+" finished!");
        System.out.println(sayi1++);
        System.out.println(sayi2++);

    }

    @AfterAll
    void tearDown(TestInfo testInfo)
    {
        System.out.println(testInfo.getTags()+" execution completed!");
        System.out.println(sayi1++);
        System.out.println(sayi2++);
    }


}
