package pageObjects.iana;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static enums.iana.Strings.*;

public class IanaSite {

    private AppiumDriver driver;

    @FindBy(css = "body > div > header > h1")
    private WebElement logo;

    @FindBy(css = "#intro > p")
    private WebElement textUnderLogo;

    @FindBy(css = "#home-panel-domains > h2 > a")
    private WebElement domainSectionTitle;

    @FindBy(css = "#home-panel-domains > p")
    private WebElement textInDomainSection;

    @FindBy(css = "#home-panel-domains > ul > li:nth-child(1) > a")
    private WebElement rootZoneManagement;

    public IanaSite(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void checkLogo() {
        Assert.assertTrue(logo.isDisplayed());
    }

    public void checkTextUnderLogo() {
        Assert.assertEquals(textUnderLogo.getText(), TEXT_UNDER_LOGO.toString());
    }

    public void checkDomainSectionTitle() {
        Assert.assertTrue(domainSectionTitle.isDisplayed());
        Assert.assertEquals(domainSectionTitle.getText(), DOMAIN_NAMES.toString());
    }

    public void checkTextInDomainSection() {
        Assert.assertTrue(textInDomainSection.isDisplayed());
        Assert.assertEquals(textInDomainSection.getText(), DOMAIN_SECTION_TEXT.toString());
    }

    public void checkLinkInRootZoneManagement() {
        Assert.assertTrue(rootZoneManagement.isDisplayed());
        Assert.assertEquals(rootZoneManagement.getAttribute("href"), ROOT_ZONE_MANAGEMENT_URL.toString());
    }

}
