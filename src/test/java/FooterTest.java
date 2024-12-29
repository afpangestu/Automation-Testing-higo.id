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
    public void footerHigoLogoTest() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getHigoLogo());
        System.out.println("==== Test Footer 'HIGO LOGO' Success ====");
    }

    @Test(priority = 2)
    public void footerCompanyTextTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getCompanyTxt(), StringValue.footerTxtCompany);
        System.out.println("==== Test Footer 'Company Text' Success ====");
    }

    @Test(priority = 3)
    public void footerAddressTextTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getAddressTxt(), StringValue.footerTxtAddress1);
        System.out.println("==== Test Footer 'Company Text' Success ====");
    }

    @Test(priority = 4)
    public void footerEmailTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getEmailText(), StringValue.footerTxtEmail);
        Assert.assertEquals(footerPage.getEmailLinkText(), StringValue.footerLinkTxtEmail);
        System.out.println("==== Test Footer 'Email Contact' Success ====");
    }

    @Test(priority = 5)
    public void footerPhoneTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getPhoneText(), StringValue.footerTxtPhone);
        Assert.assertEquals(footerPage.getPhoneLinkText(), StringValue.footerLinkTxtPhone);
        System.out.println("==== Test Footer 'Phone Contact' Success ====");
    }

    @Test(priority = 6)
    public void footerCopyrightTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getCopyrightText(), StringValue.footerTxtCopyright);
        System.out.println("==== Test Footer 'Copyright' Success ====");
    }

    @Test(priority = 7)
    public void footerISO27001Test() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getISO27001());
        System.out.println("==== Test Footer 'ISO 27001' Success ====");
    }

    @Test(priority = 8)
    public void footerISO27701Test() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getISO27701());
        System.out.println("==== Test Footer 'ISO 27701' Success ====");
    }

    @Test(priority = 9)
    public void footerGetAllLinkTest() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getAllLink());
        System.out.println("==== Test Footer 'Get All Link' Success ====");
    }

    @Test(priority = 10)
    public void footerWifiTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickWifiAdver();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_wifi);
        System.out.println("==== Test Footer 'Click WiFi Advertising' Success ====");
    }

    @Test(priority = 11)
    public void footerHigoSpotTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickHigoSpot();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_higospot);
        System.out.println("==== Test Footer 'Click HIGOspot' Success ====");
    }

    @Test(priority = 12)
    public void footerIdaTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickIda();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_ida);
        System.out.println("==== Test Footer 'Click Integrated Digital Agency' Success ====");
    }

    @Test(priority = 13)
    public void footerAboutHigoTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickAboutHigo();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.about_us);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 14)
    public void footerCareerTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickCareer();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_career);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 15)
    public void footerTermsTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickTerms();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_terms);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 15)
    public void footerPrivacyTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickPrivacy();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_privacy);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
