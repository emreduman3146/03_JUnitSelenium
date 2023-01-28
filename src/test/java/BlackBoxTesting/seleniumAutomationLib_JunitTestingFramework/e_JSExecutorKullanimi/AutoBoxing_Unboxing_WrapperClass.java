package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.e_JSExecutorKullanimi;

import com.beust.ah.A;

import java.util.ArrayList;

public class AutoBoxing_Unboxing_WrapperClass
{
    public static void main(String[] args) {



        //BOXING NE DEMEKTIR
        int int0=1;//stack bellekte
        Integer int1=new Integer(1);//stack+heap bellekte
        Integer int2= 1;//stack+heap bellekte


        //AUTOBOXING
        Long l1=10L;

        //UNBOXING
        Double d1=new Double(10.0);
        double d2=d1;



        //ORNEK YAPIYORUZ
        //10 KUTULU BIR ARRAY HEAP BELLEKTE YER KAPLADI
        ArrayList<Integer> sayiListesi=new ArrayList<>();

        for(int i=0; i<15;i++)
        {
            sayiListesi.add(i);
        }

        System.out.println(sayiListesi);


    }


}
