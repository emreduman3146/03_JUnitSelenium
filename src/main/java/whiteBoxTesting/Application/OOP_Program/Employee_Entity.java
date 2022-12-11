package whiteBoxTesting.Application.OOP_Program;

import java.util.ArrayList;
import java.util.List;

public class Employee_Entity
{

    //Employee class'inin 3 field- instance variable
    //bu bilgiler classin objesine ozgudur
    //her objenin bilgileri kendisine ozgudur
    private int id;


    private String name;
    private double salary;

    //1 field class variable
    //bu degisken class'a ozgudur.
    //Tum objeler bu degiskeni kullanir/erisir/degistirebilir.
    //Tum objeler, classin ortak mali olan bu static degiskeni kullanbilir
    private static List<Employee_Entity> empList;


    public Employee_Entity() {

    }

    public Employee_Entity(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public List<Employee_Entity> getEmpList() {
        return empList;//private empList
    }

    public String getName() {
        return name;
    }

    public void setEmpList(List<Employee_Entity> empList) {
        this.empList = empList;
    }


    @Override
    public String toString() {
        return "Employee_Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee_Entity ahmet =new Employee_Entity(1,"ahmet",100000);
        System.out.println(ahmet);


        //java bilgisi
        //eger olusturdugum objenin icindeki fieldlari duzgun bir sekilde consolda gormek istersek
        //toString methodunu objesini olusturdugum classin icine override edip olusturmaliyim

    }

}

