package whiteBoxTesting.Application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class g2_ConditionalTesting
{

    @Test
    @EnabledIf("customCondition")
    void enabled() {
        Assertions.assertTrue(true);
    }




    @Test
    @DisabledIf("customCondition")
    void disabled() {
        // ...
    }


    public boolean customCondition() {
        return true;
    }





    //Eger method baska package'taki baska bir classin icinden kullanilmak istenirse
    // @EnabledIf("packageName.ClassName#methodName") formati kullanilir



}
