package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;


public class Driver extends TestProperties {

    /**
     * Initialize a driver with test properties
     */
    protected static AppiumDriver driverSingle;
    protected static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * @throws Exception
     */
    protected void prepareDriver(String propertyFileName) throws Exception {

        currentProps = loadPropsFromFile(propertyFileName);

        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : String.format("https://%s", t_sut);
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("device_name");

        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch(TEST_PLATFORM){
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                //capabilities.setCapability("autoDismissAlerts", true);
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default: throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if(AUT != null && SUT == null){
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if(SUT != null && AUT == null){
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        }else{
            throw new Exception("Unclear type of mobile app");
        }

        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }

        if (waitSingle == null) {
            prepareWait();
        }
    }

    protected void prepareWait() throws Exception {
        waitSingle = new WebDriverWait(driver(), 10);
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null)
            prepareDriver(lastLoadedPropsFile);
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        if (waitSingle == null)
            prepareWait();
        return waitSingle;
    }

}
