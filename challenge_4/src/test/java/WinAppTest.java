import io.appium.java_client.windows.WindowsDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class WinAppTest {

    @Test
    public void completeNotepageTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        capabilities.setCapability("platformName","Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        WindowsDriver calculatorApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        calculatorApp.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        calculatorApp.findElementByName("One").click();
        calculatorApp.findElementByName("Plus").click();
        calculatorApp.findElementByName("One").click();
        calculatorApp.findElementByName("Equals").click();

        String result = calculatorApp.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is", "").trim();
        assertEquals("2", result);
    }

}
