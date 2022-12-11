package whiteBoxTesting.Application.OOP_Program;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProgram
{
    static Employee_Entity employee_entity=new Employee_Entity();
    static Employee_Service employee_service=new Employee_Service();
    public static List<Employee_Entity> empList=new ArrayList<>();//ahmet,ayse,mehmeti listeye koyabilmek icin liste olusturmusum


    //programimizin kendisi bu
    public static void main(String[] args)
    {

        //listemizi heap bellekte olustur
        employee_entity.setEmpList(empList);

        //heap bellekte bir employee pbjei olustur + bu objenin reference'ini listin icine koy
        employee_service.addEmployee(new Employee_Entity(1,"Elon Musk",100000.0));


        //Employee_entity classindaki encapsulation mantigina olusturdugum getter-setter;lar vardi
        //bunlardan 1 tanesi getEmpList() idi
        //ve elimizdeki tum employeeleri toString methodu sayesinde consolde gozumuzle gorebiliyoruz
        System.out.println("employee_service.getEmpList() = " + employee_entity.getEmpList());


        System.out.println("======================================================");
        
        Employee_Entity employee2=new Employee_Entity(4,"QA Engineer",200000.0);
        employee_service.addEmployee(employee2);
        System.out.println("employee_service.getEmpList() = " + employee_entity.getEmpList());
        //sout(listAdi);


        System.out.println("======================================================");


        //heap bellekteki liste gider
        //tum objeleri tek tek gezer
        //id:1 olan objeyi bulur
        //listin icinden cikarir
        employee_service.removeEmployeeByID(1);




    }
}
