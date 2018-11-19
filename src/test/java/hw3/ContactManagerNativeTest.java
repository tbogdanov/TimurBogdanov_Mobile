package hw3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.contactManager.AddContactPage;
import pageObjects.contactManager.MainPage;
import setup.Driver;

import static enums.contactManager.TestContact.VASILIY_PUPKIN;
import static utils.AndroidUtils.pressBackButton;


public class ContactManagerNativeTest extends Driver {

    private MainPage mainPage;
    private AddContactPage addContactPage;

    protected ContactManagerNativeTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true, groups = {"native", "native-android-farm", "native-android-farm-autolaunch"})
    public void preparePages() throws Exception {
            mainPage = new MainPage(driver());
            addContactPage = new AddContactPage(driver());
    }

    @Test(groups = {"native", "native-android-farm", "native-android-farm-autolaunch"}, description = "Add Contact Page Test")
    public void AddContactPageTest() throws Exception {
        mainPage.tapAddContact();
        addContactPage.checkFieldTitles();
        addContactPage.enterNamePhone(VASILIY_PUPKIN);
        pressBackButton(driver());
        addContactPage.checkNamePhoneFields(VASILIY_PUPKIN);
        addContactPage.clickSaveButton();
    }


}