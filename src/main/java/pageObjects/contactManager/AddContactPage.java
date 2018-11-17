package pageObjects.contactManager;

import enums.contactManager.TestContact;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static enums.contactManager.Strings.CONTACT_NAME;
import static enums.contactManager.Strings.CONTACT_PHONE;

public class AddContactPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "contactNameEditText")
    AndroidElement contactNameTextField;

    @AndroidFindBy(id = "contactPhoneEditText")
    AndroidElement contactPhoneTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Name\"]")
    AndroidElement contactNameTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Phone\"]")
    AndroidElement contactPhoneTitle;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactSaveButton")
    AndroidElement saveButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    AndroidElement alertTitle;

    public AddContactPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checkFieldTitles() {
        Assert.assertEquals(contactNameTitle.getText(), CONTACT_NAME.toString());
        Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.toString());
    }

    public void enterNamePhone(TestContact contact) {
        contactNameTextField.sendKeys(contact.getName());
        contactPhoneTextField.sendKeys(contact.getPhoneNumber());
    }

    public void checkNamePhoneFields(TestContact contact) {
        Assert.assertEquals(contactNameTextField.getText(), contact.getName());
        Assert.assertEquals(contactPhoneTextField.getText(), contact.getPhoneNumber());
    }

    public void clickSaveButton(){
        saveButton.click();
    }


}
