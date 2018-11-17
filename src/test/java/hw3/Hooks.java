package hw3;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.Driver;

import static enums.Paths.NATIVE_TEST_PROPERTY;
import static enums.Paths.WEB_TEST_PROPERTY;

public class Hooks extends Driver {

    protected Hooks() {
        super();
    }

    @BeforeSuite(groups = {"native"})
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE_TEST_PROPERTY.toString());
        System.out.println("Driver prepared for NATIVE tests");
    }

    @BeforeSuite(groups = {"web"})
    public void setUpWeb() throws Exception {
        prepareDriver(WEB_TEST_PROPERTY.toString());
        System.out.println("Driver prepared for WEB tests");
    }

    @AfterSuite(groups = {"native", "web"})
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
