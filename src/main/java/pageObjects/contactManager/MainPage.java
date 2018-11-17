package pageObjects.contactManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "addContactButton")
    AndroidElement addContactButton;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tapAddContact() {
        addContactButton.click();
    }

}
