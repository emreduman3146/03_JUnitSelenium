package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.p_brokenLinks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class BirListenBaskaBirListOlusturmak
{

    public static void main(String[] args) {
      //  javaStructuralProgramming();
        javaFunctionalProgrammingIle();
    }


    public static void javaStructuralProgramming()
    {


        List<Integer> originalList = new ArrayList<>();

        //NORMAL FOR LOOP
        for (int i = 1; i <= 5; i++) {
            originalList.add(i);
        }

        //FOR EACH LOOP
        for (Integer i : originalList) {
            System.out.println(i);
        }

        //yeni bir liste olusturmak
        List<Integer> newList = new ArrayList<>();
        for (Integer i : originalList)
        {
            newList.add(i * i);
        }

        for (Integer i : newList) {
            System.out.println(i);
        }


        List<Integer> newList1 = new ArrayList<>();

        for (Integer i : originalList) {
            if (i % 2 == 0) {
                newList1.add(i);
            }
        }
        for (Integer i : newList1) {
            System.out.println(i);
        }

    }

    private static void javaFunctionalProgrammingIle()
    {
        //JAVA STREAM KONUSU
        //Stream ifadesini List'e donusturelim
       List<Integer> integerList= IntStream.range(1,6).boxed().collect(Collectors.toList());
        integerList.forEach(element->System.out.println(element));


        //Elimizdeki varolan bir listten yeni bir liste olusturmak
        List<Integer> newList=integerList.stream().map(i->i*i).collect(Collectors.toList());
        newList.forEach(System.out::println);



        //Elimizdeki varolan bir listten yeni bir liste olusturmak
        List<Integer> newList2=integerList.stream().filter(i->i%2==0).collect(Collectors.toList());
        newList2.forEach(System.out::println);

    }



    //FunctionalProgramlamayi kullanirlar, String hazir classini kullanmak
    //Functional programlama yazma, Kendi Functional classimi kullanmak


}
