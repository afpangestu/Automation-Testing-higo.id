import config.BaseUrl;
import config.StringValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.FooterPage;

import java.util.ArrayList;

public class FooterTest {
    WebDriver driver;
    FooterPage footerPage;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() throws InterruptedException {
        // open browser and url
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(BaseUrl.baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.baseUrl);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void footerHigoLogoTest() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getHigoLogo());
        System.out.println("==== Test Footer 'HIGO LOGO' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void footerCompanyTextTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getCompanyTxt(), StringValue.footerTxtCompany);
        System.out.println("==== Test Footer 'Company Text' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void footerAddressTextTest() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getAddressTxt());
        System.out.println("==== Test Footer 'Address Text' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void footerEmailTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getEmailText(), StringValue.footerTxtEmail);
        Assert.assertEquals(footerPage.getEmailLinkText(), StringValue.footerLinkTxtEmail);
        System.out.println("==== Test Footer 'Email Contact' Success ====");
    }

    @Test(priority = 5, groups = {"unit", "smoke"})
    public void footerPhoneTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getPhoneText(), StringValue.footerTxtPhone);
        Assert.assertEquals(footerPage.getPhoneLinkText(), StringValue.footerLinkTxtPhone);
        System.out.println("==== Test Footer 'Phone Contact' Success ====");
    }

    @Test(priority = 6, groups = {"unit", "smoke"})
    public void footerXTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickXBtn();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_x);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Footer 'X Button' Success ====");
    }

    @Test(priority = 7, groups = {"unit", "smoke"})
    public void footerLinkedInTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickLinkedinBtn();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_linkedin);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Footer 'LinkedIn Button' Success ====");
    }

    @Test(priority = 8, groups = {"unit", "smoke"})
    public void footerFacebookTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickfacebookBtn();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_facebook);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Footer 'Facebook Button' Success ====");
    }

    @Test(priority = 9, groups = {"unit", "smoke"})
    public void footerInstagramTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickInstagramBtn();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_instagram);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Footer 'Instagram Button' Success ====");
    }

    @Test(priority = 10, groups = {"unit", "smoke"})
    public void footerCopyrightTest() {
        footerPage = new FooterPage(driver);
        Assert.assertEquals(footerPage.getCopyrightText(), StringValue.footerTxtCopyright);
        System.out.println("==== Test Footer 'Copyright' Success ====");
    }

    @Test(priority = 11, groups = {"unit", "smoke"})
    public void footerISO27001Test() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getISO27001());
        System.out.println("==== Test Footer 'ISO 27001' Success ====");
    }

    @Test(priority = 12, groups = {"unit", "smoke"})
    public void footerISO27701Test() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getISO27701());
        System.out.println("==== Test Footer 'ISO 27701' Success ====");
    }

    @Test(priority = 13, groups = {"unit", "smoke"})
    public void footerGetAllLinkTest() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue(footerPage.getAllLink());
        System.out.println("==== Test Footer 'Get All Link' Success ====");
    }

    @Test(priority = 14, groups = {"unit", "smoke"})
    public void footerWifiTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickWifiAdver();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_wifi);
        System.out.println("==== Test Footer 'Click WiFi Advertising' Success ====");
    }

    @Test(priority = 15, groups = {"unit", "smoke"})
    public void footerHigoSpotTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickHigoSpot();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_higospot);
        System.out.println("==== Test Footer 'Click HIGOspot' Success ====");
    }

    @Test(priority = 16, groups = {"unit", "smoke"})
    public void footerIdaTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickIda();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_ida);
        System.out.println("==== Test Footer 'Click Integrated Digital Agency' Success ====");
    }

    @Test(priority = 17, groups = {"unit", "smoke"})
    public void footerAboutHigoTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickAboutHigo();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.about_us);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 18, groups = {"unit", "smoke"})
    public void footerCareerTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickCareer();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_career);
        driver.navigate().back();
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 19, groups = {"unit", "smoke"})
    public void footerTermsTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickTerms();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_terms);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 20, groups = {"unit", "smoke"})
    public void footerPrivacyTest() throws InterruptedException {
        footerPage = new FooterPage(driver);
        footerPage.clickPrivacy();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_privacy);
        System.out.println("==== Test Footer 'Click About HIGO' Success ====");
    }

    @Test(priority = 21, groups = {"unit", "smoke"})
    public void footerBlogTest() {
        footerPage = new FooterPage(driver);
        footerPage.clickBlog();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.blog);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Footer 'Click Blog HIGO' Success ====");
    }

    @AfterClass(groups = {"unit", "smoke"})
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
