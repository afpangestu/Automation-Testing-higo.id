import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.AboutPage;

public class AboutHigoTest {
    WebDriver driver;
    AboutPage aboutPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.about_us);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.about_us);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void titleAboutTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getTitleAboutHigo());
        System.out.println("==== Test About HIGO 'Heading' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void descAboutTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getDescHigo());
        System.out.println("==== Test About HIGO 'Description About' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void imgAboutTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getImageAbout());
        System.out.println("==== Test About HIGO 'Image About' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void getSixYearsTxtTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getSixYearsTxt());
        System.out.println("==== Test About HIGO '6 years Heading' Success ====");
    }

    @Test(priority = 5, groups = {"unit", "smoke"})
    public void getCoreValueTxtTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getCoreValueTxt());
        System.out.println("==== Test About HIGO 'Core Value Heading' Success ====");
    }

    @Test(priority = 6, groups = {"unit", "smoke"})
    public void getGrowTxtTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getGrowTxt());
        System.out.println("==== Test About HIGO 'Grow Together Heading' Success ====");
    }

    @Test(priority = 7, groups = {"unit", "smoke"})
    public void getImageGrowTest() {
        aboutPage = new AboutPage(driver);
        Assert.assertTrue(aboutPage.getImageGrow());
        System.out.println("==== Test About HIGO 'Grow Together Image' Success ====");
    }

    @Test(priority = 8, groups = {"unit", "smoke"})
    public void clickBtnBePartHigoTest() throws InterruptedException {
        aboutPage = new AboutPage(driver);
        aboutPage.clickBtnBePartHigo();
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.higo_career);
        Thread.sleep(2000);
        System.out.println("==== Test About HIGO 'Click Button Be Part HIGO' Success ====");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
