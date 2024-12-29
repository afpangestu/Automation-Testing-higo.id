package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Util;

import java.time.Duration;
import java.util.TreeMap;

public class CaseStudyPage {
    WebDriver driver;
    WebDriverWait wait;
    Util util;

    // constructor
    public CaseStudyPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By tabWifi = By.xpath("//li[contains(text(),'WiFi Advertising')]");
    By tabHIGOspot = By.xpath("//li[contains(text(),'HIGOspot')]");
    By tabAll = By.xpath("//li[contains(text(),'All')]");
    By higoSpotList = By.xpath("//div[normalize-space()='HIGOspot']");
    By wifiAdvertList = By.xpath("//div[normalize-space()='WiFi Advertising']");
    By devonItem = By.xpath("//img[@alt='Devon']");
    By abbottItem = By.xpath("//img[@alt='Abbott']");


    // methods
    public void clickAll() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabAll)).click();
    }

    public void clickWifi() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabWifi)).click();
    }

    public void clickHIGOspot() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabHIGOspot)).click();
    }

    public boolean getAllCategory() {
        boolean status = false;
        boolean wifiAdvert = wait.until(ExpectedConditions.visibilityOfElementLocated(wifiAdvertList)).isDisplayed();
        boolean higiSpot = wait.until(ExpectedConditions.visibilityOfElementLocated(higoSpotList)).isDisplayed();
        if (wifiAdvert && higiSpot) { status = true; }
        return status;
    }

    public boolean getWifiAdvertCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wifiAdvertList)).isDisplayed();
    }

    public boolean getHigoSpotCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(higoSpotList)).isDisplayed();
    }

    public void clickDevonItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(devonItem)).click();
    }

    public void clickAbbottItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(abbottItem)).click();
    }
}
