package BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.g_PopUpHandling.pushNotification;

import org.junit.jupiter.api.Test;

import static BlackBoxTesting.seleniumAutomationLib_JunitTestingFramework.z_driver.Driver.getDriver;

public class PushPopUpHandling
{

    @Test
    void urlyeGiderGitmez_TepedenInenPopUptan_KurtulmaninKisaYolu()
    {
        getDriver().get("https://www.justdial.com/com");
    }

}
