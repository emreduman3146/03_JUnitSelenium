package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.p_brokenLinks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BirListenBaskaBirListOlusturmak
{

    public static void main(String[] args) {
        javaStructuralProgramming();
    }

    public static void javaStructuralProgramming() {
        List<Integer> originalList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            originalList.add(i);
        }
        for (Integer i : originalList) {
            System.out.println(i);
        }

        List<Integer> newList = new ArrayList<>();
        for (Integer i : originalList) {
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

    public static void javaFunctionalProgramlamaIle()
    {
        List<Integer> originalList = IntStream.range(1, 6)
                .boxed()
                .collect(Collectors.toList());

        originalList.forEach(System.out::println);


        List<Integer> newList = originalList.stream().map(i -> i * i).collect(Collectors.toList());
        newList.forEach(System.out::println);


        List<Integer> newList1 = originalList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        newList1.forEach(System.out::println);


    }
}
