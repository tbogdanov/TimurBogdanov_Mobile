package hw3;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.Driver;

import static enums.Paths.*;

public class Hooks extends Driver {

    protected Hooks() {
        super();
    }

    @BeforeSuite(groups = {"native"})
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE_TEST_PROPERTY.toString());
        Reporter.log("Driver prepared for NATIVE tests");
    }

    @BeforeSuite(groups = {"native-android-farm"})
    public void setUpNativeAndroidFarm() throws Exception {
        prepareDriver(NATIVE_ANDROID_FARM_PROPERTY.toString());
        Reporter.log("Driver prepared for Native Android Farm tests");
    }

    @BeforeSuite(groups = {"native-android-farm-autolaunch"})
    public void setUpNativeAndroidFarmAutoLaunch() throws Exception {
        prepareDriver(NATIVE_ANDROID_FARM_AUTOLAUNCH.toString());
        Reporter.log("Driver prepared for Native Android Farm tests (w/ Autolaunch)");
    }

    @BeforeSuite(groups = {"web"})
    public void setUpWeb() throws Exception {
        prepareDriver(WEB_TEST_PROPERTY.toString());
        Reporter.log("Driver prepared for WEB tests");
    }

    @BeforeSuite(groups = {"web-ios-farm"})
    public void setUpWebIosFarm() throws Exception {
        prepareDriver(WEB_IOS_FARM_PROPERTY.toString());
        Reporter.log("Driver prepared for Web iOS Farm tests");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        driver().quit();
        Reporter.log("Driver closed");
    }
}
