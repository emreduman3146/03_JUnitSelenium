package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import org.checkerframework.checker.units.qual.C;

public class Polimorphism01_inheritance_castingTypes
{


    {

        //Wrapper Classes ne demektir, kac tane vardir, nasil kullanilir?

        // Java Type Casting
        int a=10;
        long b=a;//Widening Casting  otomatic casting

        long c=20;
        short d=(short)c;//Narrowing Casting

    }
    public static void main(String[] args) {

       //temel polimorphism
        GrandParent grandParent=new GrandParent();
        grandParent.method1();

        Parent parent=new Parent();
        parent.method2();

        GrandParent parent2=new Parent();
        parent2.method1();



        //casting

        GrandChild grandChild=new GrandChild();
        Child child=new Child();


        Child child2=grandChild;
        System.out.println(child2.c);



        //casting2
        GrandParent grandParent3=new GrandParent();

        Child child3=new Child();

        Child child4=(Child)grandParent3;
        System.out.println(child4.c);



        //casting3
        GrandParent parent3=new Parent();

        GrandParent grandChild3=new GrandChild();

        GrandChild grandChild4=(GrandChild) parent3;
        System.out.println(grandChild4.c);





    }





    static class GrandParent
    {
        int a=1;
        void method1()
        {
            System.out.println("method1");
        }

    }

    static class Parent extends GrandParent{

        int b=2;
        void method2()
        {
            System.out.println("method2");

        }


    }

    static class Child extends Parent{

        int c=3;

        void method3()
        {
            System.out.println("method3");
        }
    }

    static class GrandChild extends Child
    {
        int d=4;
        void method4()
        {
            System.out.println("method4");
        }

    }
}
