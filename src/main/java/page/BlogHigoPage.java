package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogHigoPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public BlogHigoPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    // Artikel terbaru
    By latestArticle = By.xpath("/html/body/main/div/section/div/div[1]/ul/li/a/div[1]/img");
    By dateLatestArticle = By.xpath("//time[normalize-space()='21 Nov 2024']");
    By dateDetailLatestArticle = By.xpath("//time[@pubdate='pubdate']");

    // Category
    By categoryHIGOes = By.xpath("//button[normalize-space()='HIGOes Update']");
    By badgeHIGOes = By.xpath("/html/body/main/div/div/section/div/ul/li[1]/a/div[2]/header/div");
    By categoryLifestyle = By.xpath("//button[normalize-space()='Lifestyle']");
    By badgeLifestyle = By.xpath("/html/body/main/div/div/section/div/ul/li[1]/a/div[2]/header/div");

    // Category List
    By clickMoreArticle = By.xpath("//button[contains(text(),'Tampilkan lebih banyak')]");
    By newMoreArticle = By.xpath("//ul[@class='grid content-start gap-6 @3xl/list:gap-8 grid-flow-row']//li[@class='group/item grid @container/item'][6]");

    // Security Test
    By clickArticle = By.xpath("/html/body/main/div/div/section/div/ul/li[1]/a/div[1]/img");

    // Comment
    By commentName = By.xpath("//*[@placeholder='Tulis Nama Kamu'][@name='name']");
    By commentMsg = By.xpath("//*[@placeholder='Tulis Komentar Kamu'][@name='comment']");
    By commentSubmit = By.xpath("//*[@type='submit'][normalize-space()='Kirim']");

    //methods
    public void clickLatestArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(latestArticle)).click();
    }

    public void clickCategoryHIGOes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHIGOes)).click();
    }

    public void clickCategoryLifestyle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryLifestyle)).click();
    }

    public String getTxtCategoryHIGOes() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(badgeHIGOes)).getText();
    }

    public String getTxtCategoryLifestyle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(badgeLifestyle)).getText();
    }

    public void clickMoreArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickMoreArticle)).click();
    }

    public boolean getNewMoreArticle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newMoreArticle)).isDisplayed();
    }

    public String getDateLatestArticle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dateLatestArticle)).getText();
    }

    public String getDateDetailLatestArticle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dateDetailLatestArticle)).getText();
    }

    public void clickArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickArticle)).click();
    }

    public void setCommentName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentName)).sendKeys(name);
    }

    public void setCommentMsg(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentMsg)).sendKeys(comment);
    }

    public void clickSubmitComment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentSubmit)).click();
    }
}
