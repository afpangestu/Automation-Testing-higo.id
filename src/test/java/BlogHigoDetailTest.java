import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BlogHigoPage;
import provider.DataProviders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlogHigoDetailTest {
    WebDriver driver;
    BlogHigoPage blogHigo;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.articleUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.articleUrl);
    }

    @Test(priority = 1, dataProvider = "normal_comment", dataProviderClass = DataProviders.class, groups = {"unit", "smoke"})
    public void blogCommentTest(String name, String comment) throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        // check current total comment
        System.out.println("(BEFORE) Total Comment = " + getCurrentTotalComment());
        // start commenting article
        int newTotalComment = getCurrentTotalComment() + 10; // 10 is total datatest from excel file
        blogHigo.setCommentName(name);
        Thread.sleep(500);
        blogHigo.setCommentMsg(comment);
        Thread.sleep(500);
        blogHigo.clickSubmitComment();
        Thread.sleep(500);
        System.out.println("(AFTER) Total Comment = " + newTotalComment);
        Assert.assertEquals(getCurrentTotalComment(), newTotalComment);
        System.out.println("==== Test Blog HIGO 'Comment' Success ====");
    }

    public int getCurrentTotalComment() {
        blogHigo = new BlogHigoPage(driver);
        String comment = blogHigo.getTotalComment();
        String[] split = comment.split(" ");
        String currentTotal = split[0];
        return Integer.parseInt(currentTotal);
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void getCurrentTime() {
        blogHigo = new BlogHigoPage(driver);
        String dateComment = blogHigo.getDateTimeComment();

        String[] split = dateComment.split("today at ");
        String currentTotal = split[1];

        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        String dateLocal = dateFormat.format(new Date());
        System.out.println("Current time Comment : "+currentTotal);
        System.out.println("Current Local time : "+dateLocal);
        Assert.assertEquals(currentTotal, dateLocal);
        System.out.println("==== Test Blog HIGO 'Date Comment' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void blogLikeCommentTest() throws InterruptedException {
        blogHigo = new BlogHigoPage(driver);
        int total = 0;
        int totalHitLike = 6;
        int currentTotal = Integer.parseInt(blogHigo.getTotalLikeComment());
        for (int i=0; i<totalHitLike; i++) { // it will like-dislike
            blogHigo.clickLikeComment();
            Thread.sleep(1000);
            total = currentTotal + totalHitLike;
        }
        int updateTotal = Integer.parseInt(blogHigo.getTotalLikeComment());
        System.out.println("==== Assert Total Like 'Before' Refresh Browser ====");
        Assert.assertEquals(updateTotal, total - totalHitLike/2);

        System.out.println("==== Assert Total Like 'After' Refresh Browser ====");
        driver.navigate().refresh();
        int afterTotal = Integer.parseInt(blogHigo.getTotalLikeComment());
        Assert.assertEquals(afterTotal, currentTotal);
    }

    @AfterClass(groups = {"unit", "smoke"})
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
