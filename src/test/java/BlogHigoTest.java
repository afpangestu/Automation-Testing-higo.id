import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HeaderNavPage;

public class BlogHigoTest {
    WebDriver driver;
    HeaderNavPage headerNav;

    @BeforeClass
    public void setup() {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.blog);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.blog);
    }

    @Test
    public void HigoLogo() throws InterruptedException {
        headerNav = new HeaderNavPage(driver);
        headerNav.getHigoLogo();
        Thread.sleep(3000);
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
