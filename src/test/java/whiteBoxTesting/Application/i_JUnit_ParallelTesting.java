package whiteBoxTesting.Application;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


@Execution(ExecutionMode.CONCURRENT)//es zamanli calistirma modu
public class i_JUnit_ParallelTesting
{
    //Birden fazla @Test methodunun ayni anda run edilmesi olayina paralell testing denir
    //Normalde sirayla run edilirler. Biri biter digeri baslar.
    //Paralel testingte ise ayni anda run edilmeye baslarlar.


    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }


}

