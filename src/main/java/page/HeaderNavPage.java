package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderNavPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public HeaderNavPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By higoLogo = By.xpath("//a[@aria-label='HIGO']//*[name()='svg']");
    By aboutUs = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'Tentang HIGO')]");
    By caseStudy = By.xpath("//label[@for='navigation-case-study']");
    By higoServices = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/label[1]/div[1]/span[1]");
    By serviceWA = By.xpath("//span[contains(text(),'WiFi Advertising')]");
    By serviceHIGOspot = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'HIGOspot')]");
    By serviceIDA = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'Integrated Digital Agency')]");
    By digitalReport = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'Digital Reports')]");
    By contactUs = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'Hubungi HIGO')] | //span[contains(text(),'Contact HIGO')]");

    // methods
    public void clickHigoLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(higoLogo)).click();
    }

    public void getHigoLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(higoLogo)).isDisplayed();
    }

    public void clickAboutUs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUs)).click();
    }

    public void clickCaseStudy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(caseStudy)).click();
    }

    public void clickHigoServices() {
        wait.until(ExpectedConditions.presenceOfElementLocated(higoServices)).click();
    }

    public void clickServiceWA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceWA)).click();
    }

    public void clickServiceHIGOspot() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceHIGOspot)).click();
    }

    public void clickServiceIDA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceIDA)).click();
    }

    public void clickDigitalReport() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(digitalReport)).click();
    }

    public void clickContactUs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs)).click();
    }
}
