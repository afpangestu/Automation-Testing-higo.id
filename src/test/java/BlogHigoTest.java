import config.BaseUrl;
import config.StringValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.navigate().back();
        System.out.println("==== Test Blog 'Latest Article' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void blogCategoryTest() {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickCategoryHIGOes();
        Assert.assertEquals(blogHigo.getTxtCategoryHIGOes(), "HIGOes Update");
        blogHigo.clickCategoryLifestyle();
        Assert.assertEquals(blogHigo.getTxtCategoryLifestyle(), "Lifestyle");
        System.out.println("==== Test Blog 'Category Article' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void blogMoreArticleTest() {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickMoreArticle();
        Assert.assertTrue(blogHigo.getNewMoreArticle());
        System.out.println("==== Test Blog 'More Article' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void blogCommentTest() {
        blogHigo = new BlogHigoPage(driver);
        blogHigo.clickArticle();
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
