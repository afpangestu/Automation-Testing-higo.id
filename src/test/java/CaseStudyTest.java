import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CaseStudyPage;
import util.Util;

public class CaseStudyTest {
    WebDriver driver;
    CaseStudyPage caseStudy;
    Util util;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() throws InterruptedException {
        // open browser and url
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(BaseUrl.case_study);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.case_study);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void clickAllTest() {
        util = new Util(driver);
        caseStudy = new CaseStudyPage(driver);
        caseStudy.clickAll();
        Assert.assertTrue(caseStudy.getAllCategory());
        System.out.println("==== Test Case Study 'All Category' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void clickWifiAdvertCategoryTest() {
        caseStudy = new CaseStudyPage(driver);
        caseStudy.clickWifi();
        Assert.assertTrue(caseStudy.getWifiAdvertCategory());
        System.out.println("==== Test Case Study 'WiFi Advertising Category' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void clickAbbottItemTest() {
        caseStudy = new CaseStudyPage(driver);
        caseStudy.clickAbbottItem();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.case_study_abbott);
        driver.navigate().back();
        System.out.println("==== Test Case Study 'Abbott Item' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void clickHigoSpotCategoryTest() {
        caseStudy = new CaseStudyPage(driver);
        caseStudy.clickHIGOspot();
        Assert.assertTrue(caseStudy.getHigoSpotCategory());
        System.out.println("==== Test Case Study 'HIGOspot Category' Success ====");
    }

    @Test(priority = 5, groups = {"unit", "smoke"})
    public void clickDevonItemTest() {
        caseStudy = new CaseStudyPage(driver);
        caseStudy.clickDevonItem();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.case_study_devon);
        driver.navigate().back();
        System.out.println("==== Test Case Study 'Devon Item' Success ====");
    }

    @AfterClass(groups = {"unit", "smoke"})
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
