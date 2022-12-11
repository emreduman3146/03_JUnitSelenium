package whiteBoxTesting.Application;


import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.WebElement;

//Bir java dili kullanan yazilimci olarak her zaman class olustururuz.
//Peki bir classsin icinde neler vardir
//constructor methodlar
//normal methodlar
//variablelar
//default block
//static block
public class d_JavaBilgisi
{

    //variable
    //COMPILE EDILEN CLASSTA VARIABLE'LAR CLASSIN FIELD'DIR, HER DAIM CALISIR
    static int sayi=10;
    WebElement element;

    //static block
    //Sadece 1 kez calisir
    //STATIC BLOCK HER DAIM EN BASTA 1 KEZ CALISIR
    static
    {
        System.out.println("static block");
    }

    //default block
    //new ile her yeni obje olusturuldugunda calisir
    //constructor'dan daha once calistirilir
    {
        System.out.println("default block");
    }


    //constructor
    //new JavaBilgisi() constructor methodu calisinca bu method calisir
    public d_JavaBilgisi()
    {
        System.out.println("Default Constructor");
    }

    static void staticMethod()
    {
        System.out.println("static method");
    }



    public static void main(String[] args) {

        //1. kullanim
        //System.out.println("Main method");

        //2. kullanim
        //d_JavaBilgisi nesne01=new d_JavaBilgisi();
        //d_JavaBilgisi nesne02=new d_JavaBilgisi();
        //d_JavaBilgisi nesne03=new d_JavaBilgisi();


        //3. kullanim
        //System.out.println(d_JavaBilgisi.sayi);

       //4. kullanim
        //classAdi.staticMethodAdI
        //d_JavaBilgisi.staticMethod();

    }


}
