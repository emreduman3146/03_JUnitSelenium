package whiteBoxTesting.Application.OOP_Program;

public class Employee_Service
{

    Employee_Entity employee_entity=new Employee_Entity();

    public void addEmployee(Employee_Entity emp) {
        employee_entity.getEmpList().add(emp);
    }

    public void removeEmployee(Employee_Entity emp)
    {
        //algortmasi, bana verilen objeyi direk atarim
        employee_entity.getEmpList().remove(emp);
    }

    public void removeEmployeeByID(int id)
    {
       //for each loop'u
        //elimizdeki employeeleri barindiran listi tek tek sirayla gezen loop

        for(Employee_Entity emp: employee_entity.getEmpList())
        {
            if(emp.getId()==id) //1==1 ise true
            {
                //id'si 1 olan emp'yi(objeyi) litin icinden remove et
                employee_entity.getEmpList().remove(emp);
                return;//loop'u kir , methodu direk bitir, satir 28den sonra hic bir sey calismasin
            }
        }


        //loop yardimiyla listemdeki tum emp(objeleri) gezdim id'si 1 olana denk gelmedim
        //id'si 1 olan yoksa nasil bunu listeden sileyim ki?
        //o zaman hata firlat
        throw new EmployeeException("No employee available with this id!");

    }

    public void removeEmployeeByName(String name)
    {
        //for each loop'u
        //elimizdeki employeeleri barindiran listi tek tek sirayla gezen loop

        for(Employee_Entity emp: employee_entity.getEmpList())
        {
            if(emp.getName().equals(name)) //1==1 ise true
            {
                //id'si 1 olan emp'yi(objeyi) litin icinden remove et
                employee_entity.getEmpList().remove(emp);
                return;//loop'u kir , methodu direk bitir, satir 28den sonra hic bir sey calismasin
            }
        }


        //loop yardimiyla listemdeki tum emp(objeleri) gezdim id'si 1 olana denk gelmedim
        //id'si 1 olan yoksa nasil bunu listeden sileyim ki?
        //o zaman hata firlat
        throw new EmployeeException("No employee available with this id!");

    }
}
