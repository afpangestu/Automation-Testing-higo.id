package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterPage {

    WebDriver driver;
    WebDriverWait wait;
    static String valueAddress;

    // constructor
    public FooterPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By higoLogo = By.xpath("//div[@class='col-span-1 grid gap-y-4']//*[name()='svg']");
    By companyText = By.xpath("//span[@class='text-base']");
    By addressText = By.xpath("/html/body/footer/div/div/div[1]/div[1]/p/text()[1]");
    By emailText = By.xpath("//a[contains(text(),'E: info@higo.id')]");
    By phoneText = By.xpath("//a[contains(text(),'P: (021) 5806860')]");
    By copyrightTxt = By.xpath("//*[contains(text(),'©')]");
    By iso27001 = By.xpath("//img[@alt='ISO 27001']");
    By iso27701 = By.xpath("//img[@alt='ISO 27701']");
    By allLink = By.xpath("//a[@class='font-anek-malayalam text-white']");
    By wifiAdvertising = By.xpath("//a[contains(text(),'WiFi Advertising')]");
    By higoSpot = By.xpath("//a[contains(text(),'HIGOspot')]");
    By ida = By.xpath("//a[contains(text(),'Integrated Digital Agency')]");
    By aboutHigo = By.xpath("//a[contains(text(),'Tentang HIGO')] | //a[contains(text(),'About HIGO')]");
    By career = By.xpath("//a[normalize-space()='Karir'] | //a[normalize-space()='Career']");
    By terms = By.xpath("//a[normalize-space()='Terms & Conditions']");
    By privacy = By.xpath("//a[normalize-space()='Privacy & Policy']");
    By blog = By.xpath("//a[contains(text(),'Blog')]");


    // methods
    public boolean getHigoLogo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(higoLogo)).isDisplayed();
    }

    public String getCompanyTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companyText)).getText();
    }

    public String getAddressTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addressText)).getText();
    }

    public String getEmailText() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailText)).getText();
    }

    public String getEmailLinkText() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailText)).getDomAttribute("href");
    }

    public String getPhoneText() {
        return wait.until(ExpectedConditions.elementToBeClickable(phoneText)).getText();
    }

    public String getPhoneLinkText() {
        return wait.until(ExpectedConditions.elementToBeClickable(phoneText)).getDomAttribute("href");
    }

    public String getCopyrightText() {
        return wait.until(ExpectedConditions.elementToBeClickable(copyrightTxt)).getText();
    }

    public boolean getISO27001() {
        return wait.until(ExpectedConditions.elementToBeClickable(iso27001)).isDisplayed();
    }

    public boolean getISO27701() {
        return wait.until(ExpectedConditions.elementToBeClickable(iso27701)).isDisplayed();
    }

    public boolean getAllLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(allLink)).isDisplayed();
    }

    public void clickWifiAdver() {
        wait.until(ExpectedConditions.elementToBeClickable(wifiAdvertising)).click();
    }

    public void clickHigoSpot() {
        wait.until(ExpectedConditions.elementToBeClickable(higoSpot)).click();
    }

    public void clickIda() {
        wait.until(ExpectedConditions.elementToBeClickable(ida)).click();
    }

    public void clickAboutHigo() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutHigo)).click();
    }

    public void clickCareer() {
        wait.until(ExpectedConditions.elementToBeClickable(career)).click();
    }

    public void clickBlog() {
        wait.until(ExpectedConditions.elementToBeClickable(blog)).click();
    }

    public void clickTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
    }

    public void clickPrivacy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacy)).click();
    }

}
