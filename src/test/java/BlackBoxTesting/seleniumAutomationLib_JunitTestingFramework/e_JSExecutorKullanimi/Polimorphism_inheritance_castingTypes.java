package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import org.checkerframework.checker.units.qual.C;

public class Polimorphism_inheritance_castingTypes
{


    void primitiveDataTypesCastingExamples()
    {
        //widening casting=automatic casting
        int i=10;
        long l=(int)i;

        //Narrowing casting
        short s=1;
        byte b=(byte) s;
    }


    public static void main(String[] args) {

        //TEMEL POLIMORPHISM
        GrandParent grandParent=new GrandParent();
        grandParent.method1();

        Parent parent=new Parent();
        parent.method2();

        //DECLARATION TYPE       INITIALIZING TYPE
        GrandParent parent1=new Parent();
        parent1.method1();



        //POLIMORPHISM-CASTING

        //example1
        GrandParent grandParent1=new GrandParent();
        Child child=new Child();


        Child child1=null;
        child1=(Child) grandParent1;




        //example2
        GrandChild grandChild=new GrandChild();

        Child child2=new Child();

        Child child3=null;
        child3=grandChild;


    }


    //STATIC INNER CLASS --  NON-STATIC/MEMBER INNER CLASS
    static class GrandParent
    {
        int a=1;
        void method1()
        {
            System.out.println(1);
        }
    }

    static class Parent extends GrandParent
    {
        int b=2;
        void method2()
        {
            System.out.println(2);
        }

    }


    static class Child extends Parent
    {
        int c=3;
        void method3()
        {
            System.out.println(3);
        }

    }

    static class GrandChild extends Child
    {
        int d=4;
        void method4()
        {
            System.out.println(4);
        }

    }
}
