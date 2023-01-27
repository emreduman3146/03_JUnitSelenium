package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import java.util.ArrayList;

public class AutoBoxing_UnBoxing_WrapperClass {

    {

        //Boxing ne demektir
        //AutoBoxing, unboxing kavramlari nedir?
        Integer i1=1;
        Long l1= 2L;

//unboxing
        Integer i=new Integer(50);
        int z=i;

        System.out.println(z);


        // Autoboxing of character
        Character gfg = 'a';

        // Auto-unboxing of Character
        char ch = gfg;



        // Creating an empty Arraylist of integer type
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Adding the int primitives type values
        // using add() method
        // Autoboxing
        al.add(1);
        al.add(2);
        al.add(24);

    }
}
