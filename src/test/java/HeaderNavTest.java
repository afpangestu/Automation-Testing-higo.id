import config.BaseUrl;
import config.StringValue;
import page.HeaderNavPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class HeaderNavTest {

    WebDriver driver;
    HeaderNavPage headerNav;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() throws InterruptedException {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.baseUrl);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void navHigoLogoTest() {
        headerNav = new HeaderNavPage(driver);
        headerNav.getHigoLogo();
        headerNav.clickHigoLogo();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_logo);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtHIGO);
        System.out.println("==== Test Header Navigation 'HIGO LOGO' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void navAboutUsTest() {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickAboutUs();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.about_us);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtAboutUs);
        System.out.println("==== Test Header Navigation 'ABOUT' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void navServiceHigoTest() throws InterruptedException {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickHigoServices();
        headerNav.clickServiceWA();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_wifi);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtWA);
        headerNav.clickServiceHIGOspot();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_higospot);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtHIGOspot);
        headerNav.clickServiceIDA();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_services_ida);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtIDA);
        System.out.println("==== Test Header Navigation 'HIGO Services' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void navCaseStudyTest() {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickCaseStudy();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.case_study);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtCaseStudy);
        System.out.println("==== Test Header Navigation 'CASE STUDY' Success ====");
    }

    @Test(priority = 5, groups = {"unit", "smoke"})
    public void navDigitalReportsTest() {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickDigitalReport();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.digital_reports);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtDigitalReport);
        System.out.println("==== Test Header Navigation 'Digital Report' Success ====");
    }

    @Test(priority = 6, groups = {"unit", "smoke"})
    public void navContactUsTest() {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickContactUs();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.contact_us);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtContactUs);
        System.out.println("==== Test Header Navigation 'Contact Us' Success ====");
    }

    @Test(priority = 7, groups = {"unit", "smoke"})
    public void navBlogHIGO() throws InterruptedException {
        headerNav = new HeaderNavPage(driver);
        headerNav.clickBlog();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.blog);
        Assert.assertEquals(driver.getTitle(), StringValue.titleTxtBlog);
        // close current tab (blog.higo.id)
        driver.close();
        // move to first tab (higo.id)
        driver.switchTo().window(tabs.get(0));
        System.out.println("==== Test Header Navigation 'CASE STUDY' Success ====");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
