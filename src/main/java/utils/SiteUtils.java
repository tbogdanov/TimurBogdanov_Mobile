package utils;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class SiteUtils {

    public static void checkUrl(AppiumDriver driver, String sut) {
        Assert.assertEquals(driver.getCurrentUrl(), sut + "/");
    }

}