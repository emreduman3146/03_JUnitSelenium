package whiteBoxTesting.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;


/**
 * Bu bir calculator class'idir
 * icinde 4 tane method icerir
 */
public class CalculatorProgram
{

    public static void main(String[] args) {

        System.out.println("add(1, 2, 3, 4, 5) = " + add(1, 2, 3, 4, 5,6));


        System.out.println("multiply(1,2,3,4,5) = " + multiply(1, 2, 3, 4, 5));

        //klasik toplama methodu
        int result=add(1,2);
        System.out.println("result = " + result);
    }

    //unit
    protected static int add(int sayi1, int sayi2)
    {
        return sayi1+sayi2;
    }

    //JAVA BILGISI-> Stream konusu, google'lama yapmak isteyenler icin
    //Stream List gibi davranir
    //varargs ifadesi parametede kullanilmistir
    //unit
    public static double add(double... operands) //double... operands = bir arraydir, 1,2,3,4,5,6 double larini tutan arraydir
    {
        //klasik java list konusu
        List<Double> doubleList=new ArrayList<>();
        doubleList.add(10.0);
        doubleList.add(20.0);


        //1-100 tum degerleri iceren bana list lazim
        return DoubleStream.of(operands).sum();//1-6'ya kadar toplar
    }

    //unit
    public static double multiply(double... operands)// Double[] array=[1,2,3,4];
    {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }



    //Parent'i Number olan tum classlar parametre olarak gonderilebilirler
    //Mesela-> Integer, Double, Long, Short, Byte tipinde veri kabul eder, Bu classlarin da parent'tidir
    protected boolean isEven(Number number)//even=cift sayi demek
    {
        //local variable, methodun variable i
        boolean result=true;

        if(number instanceof Integer && (int)(number)%2==0)
            return result;
        else if(number instanceof Double && (double)(number)%2==0)
            return result;
        else if(number instanceof Short && (double)(number)%2==0)
            return result;
        else if(number instanceof Long && (double)(number)%2==0)
            return result;
        else if(number instanceof Byte && (double)(number)%2==0)
            return result;
        else if(number instanceof Float && (double)(number)%2==0)
            return result;
        else
            return !result;//true false

    }


    public static int[] ebob_ekok_bulma(int n1, int n2)//6,8 2,24
    {
        int ebob,ekok,kalan,bolunen,bolen;

        if (n1>n2)
        {
            bolunen=n1;
            bolen=n2;
        }
        else
        {
            bolunen=n2;
            bolen=n1;
        }
        kalan=bolunen%bolen;
        while(kalan!=0)
        {
            bolunen=bolen;
            bolen=kalan;
            kalan=bolunen%bolen;
        }
        ebob = bolen;
        ekok = n1*n2/ebob;

        //System.out.println(n1+" ve "+n2+" bu sayıların EBOB'u = "+ebob);
        //System.out.println(n1+" ve "+n2+" bu sayıların EKOK'u = "+ekok);

        int[] ebob_ekok_sonuclari={ebob,ekok};//ebob:2   ekok:24
        return ebob_ekok_sonuclari;



    }

}