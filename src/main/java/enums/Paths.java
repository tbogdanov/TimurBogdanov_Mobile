package enums;

public enum Paths {
    MAIN_RESOURCES_PATH("/src/main/resources"),
    TEST_RESOURCES_PATH("/src/test/resources"),
    NATIVE_TEST_PROPERTY("native-android.properties"),
    WEB_TEST_PROPERTY("web-android.properties"),
    DEFAULT_TEST_PROPERTY("native-android.properties"),
    NATIVE_ANDROID_FARM_PROPERTY("native-android-farm.properties"),
    NATIVE_ANDROID_FARM_AUTOLAUNCH("native-android-farm-autolaunch.properties"),
    WEB_IOS_FARM_PROPERTY("web-ios-farm.properties");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
