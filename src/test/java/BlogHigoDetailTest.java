import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BlogHigoPage;
import provider.DataProviders;

public class BlogHigoDetailTest {
    WebDriver driver;
    BlogHigoPage blogHigo;

    @BeforeClass
    public void setup() {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.articleUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.articleUrl);
    }

    @Test(priority = 1, dataProvider = "XSS_test", dataProviderClass = DataProviders.class)
    public void blogCommentTest(String payload) {
        blogHigo = new BlogHigoPage(driver);
        // start commenting article
        blogHigo.setCommentName("test " + payload);
        blogHigo.setCommentMsg(payload);
        blogHigo.clickSubmitComment();
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
