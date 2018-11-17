package enums;

public enum Paths {
    MAIN_RESOURCES_PATH("/src/main/resources"),
    TEST_RESOURCES_PATH("/src/test/resources"),
    NATIVE_TEST_PROPERTY("nativetest.properties"),
    WEB_TEST_PROPERTY("webtest.properties"),
    DEFAULT_TEST_PROPERTY("nativetest.properties");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
