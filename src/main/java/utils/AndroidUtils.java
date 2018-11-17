package utils;

import io.appium.java_client.AppiumDriver;

public class AndroidUtils {

    public static void pressBackButton(AppiumDriver driver) {
        driver.navigate().back();
    }

}
