import config.BaseUrl;
import config.StringValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BlogHigoPage;

public class BlogHigoTest {
    WebDriver driver;
    BlogHigoPage blogHigo;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() throws InterruptedException {
        // open browser and url
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.blog);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.blog);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void blogLatestArticleTest() throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickLatestArticle();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.latestArticleUrl);
        Assert.assertEquals(driver.getTitle(), StringValue.latestArticleTxt);
        Assert.assertEquals(blogHigo.getDateDetailLatestArticle(), blogHigo.getDateLatestArticle());
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("==== Test Blog 'Latest Article' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void blogCategoryTest() throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickCategoryHIGOes();
        Thread.sleep(1000);
        Assert.assertEquals(blogHigo.getTxtCategoryHIGOes(), "HIGOes Update");
        blogHigo.clickCategoryLifestyle();
        Thread.sleep(1000);
        Assert.assertEquals(blogHigo.getTxtCategoryLifestyle(), "Lifestyle");
        System.out.println("==== Test Blog 'Category Article' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void blogMoreArticleTest() throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickMoreArticle();
        Thread.sleep(1000);
        Assert.assertTrue(blogHigo.getNewMoreArticle());
        System.out.println("==== Test Blog 'More Article' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void blogCommentTest() throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickArticle();
        Thread.sleep(2000);
        blogHigo.setCommentName("test");
        blogHigo.setCommentMsg("test");
        blogHigo.clickSubmitComment();
    }

    @AfterClass(groups = {"unit", "smoke"})
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
