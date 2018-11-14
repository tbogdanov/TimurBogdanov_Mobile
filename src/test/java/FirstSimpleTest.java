import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    private String appPackageName = "com.example.android.contactmanager:id/";

    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareNative();
    }

    @Test
    /**
     * This simple test just click on button 'Add contact'
     */
    public void simplestTest(){
        By addBtn = By.id(appPackageName + "addContactButton");
        driver.findElement(addBtn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test
    public void simplestClassnameTest(){
        By addBtn = By.className("android.widget.Button");
        driver.findElement(addBtn).click();
    }

    @Test
    public void simplestXPathTest(){
        By showInvisibleCb = By.xpath("//android.widget.CheckBox[@content-desc=\"Show Invisible Contacts (Only)\"]");
        driver.findElement(showInvisibleCb).click();
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }
}
