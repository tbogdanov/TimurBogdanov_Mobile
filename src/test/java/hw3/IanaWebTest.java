package hw3;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.iana.IanaSite;
import setup.Driver;

import static utils.SiteUtils.checkUrl;


public class IanaWebTest extends Driver {

    private IanaSite ianaSite;

    private IanaWebTest() {
        super();
    }

    @BeforeMethod(groups = {"web", "web-ios-farm"})
    public void preparePage() throws Exception {
        driver().get(SUT);
        ianaSite = new IanaSite(driver());
    }

    @Test(groups = {"web", "web-ios-farm"}, description = "iana.org web page test")
    public void webTest() throws Exception {
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        checkUrl(driver(), SUT);
        ianaSite.checkLogo();
        ianaSite.checkTextUnderLogo();
        ianaSite.checkDomainSectionTitle();
        ianaSite.checkTextInDomainSection();
        ianaSite.checkLinkInRootZoneManagement();
    }
}