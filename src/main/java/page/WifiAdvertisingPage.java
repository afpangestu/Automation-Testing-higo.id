package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WifiAdvertisingPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public WifiAdvertisingPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By serviceWifiTxt = By.xpath("//h1[contains(text(),'Advertising')]");
    By descWifiTxt = By.xpath("//p[@class='z-10 text-sm text-white duration-700 animate-in fade-in slide-in-from-bottom-12 @2xl/page:text-lg']");
    By imageWifi = By.xpath("//img[@alt='WiFi Advertising']");
    By footprintTxt = By.xpath("//h2[contains(text(),'Footprint')]");
    By footprintList = By.xpath("//li[@class='relative grid aspect-square p-4 @xl/section:size-48']");
    By userApproachTxt = By.xpath("//h2[contains(text(),'personal')]");
    By userApproachList = By.xpath("//body//main//article");
    By benefitsTxt = By.xpath("//h2[contains(text(),'Benefit')] | //h2[contains(text(),'Keuntungan')]");
    By benefitsList = By.xpath("//div[@class='grid gap-y-14 py-16 grid-popout @2xl/page:py-40 @3xl/page:py-32']//ul//li");
    By btnAdvertiseNow = By.xpath("//span[@class='font-sans font-medium text-sm text-blue-700 transition-colors duration-300 group-hover/button:text-white']");

    // methods
    public boolean getTitleServiceWifi() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serviceWifiTxt)).isDisplayed();
    }

    public boolean getDescWifi() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descWifiTxt)).isDisplayed();
    }

    public boolean getImageWifi() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageWifi)).isDisplayed();
    }

    public boolean getFootprintTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footprintTxt)).isDisplayed();
    }

    public boolean getFootprintList() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(footprintList)).isDisplayed();
    }

    public boolean getUserApproachTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userApproachTxt)).isDisplayed();
    }

    public boolean getUserApproachList() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userApproachList)).isDisplayed();
    }

    public boolean getBenefitsTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(benefitsTxt)).isDisplayed();
    }

    public boolean getBenefitsList() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(benefitsList)).isDisplayed();
    }

    public void clickBtnAdvertiseNow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAdvertiseNow)).click();
    }
}
