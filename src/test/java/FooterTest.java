import config.BaseUrl;
import config.StringValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.FooterPage;

public class FooterTest {
    WebDriver driver;
    FooterPage footerPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.baseUrl);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void footerHigoLogo() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getHigoLogo());
        System.out.println("==== Test Footer 'HIGO LOGO' Success ====");
    }

    @Test(priority = 2)
    public void footerCompanyText() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getCompanyTxt(), StringValue.footerTxtCompany);
        System.out.println("==== Test Footer 'Company Text' Success ====");
    }

    @Test(priority = 3)
    public void footerAddressText() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getAddressTxt(), StringValue.footerTxtAddress1);
        System.out.println("==== Test Footer 'Company Text' Success ====");
    }

    @Test(priority = 4)
    public void footerEmail() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getEmailText(), StringValue.footerTxtEmail);
        Assert.assertEquals(footerPage.getEmailLinkText(), StringValue.footerLinkTxtEmail);
        System.out.println("==== Test Footer 'Email Contact' Success ====");
    }

    @Test(priority = 5)
    public void footerPhone() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getPhoneText(), StringValue.footerTxtPhone);
        Assert.assertEquals(footerPage.getPhoneLinkText(), StringValue.footerLinkTxtPhone);
        System.out.println("==== Test Footer 'Phone Contact' Success ====");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
