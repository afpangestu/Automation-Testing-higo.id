package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public ContactPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By contactTitleTxt = By.xpath("//h1[contains(text(),'HIGO')]");
    By contactEmailTxt = By.xpath("//p[normalize-space()='info@higo.id']");
    By contactPhoneTxt = By.xpath("//p[normalize-space()='(021) 5806860']");
    By contactAddressTxt = By.xpath("//p[@class='text-sm text-white'][contains(text(),'Jl. Panjang Raya')]");
    By inputFullName = By.xpath("//input[@name='fullName']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputPhone = By.xpath("//input[@name='phoneNumber']");
    By inputCompany = By.xpath("//input[@name='companyName']");
    By inputMessage = By.xpath("//textarea[@name='message']");
    By submitBtn = By.xpath("//button[normalize-space()='Submit']");
    By serviceHIGOspot = By.xpath("//option[normalize-space()='HIGOspot']");
    By serviceIDA = By.xpath("//option[normalize-space()='Integrated Digital Agency']");
    By serviceWA = By.xpath("//option[normalize-space()='WiFi Advertising']");
    By successMsg = By.xpath("//div[contains(text(),'Pesan Anda berhasil terkirim.')]");
    By errorMsg = By.xpath("//p[@class='text-xs text-red-500']");

    // methods
    public boolean getTitleContact() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactTitleTxt)).isDisplayed();
    }

    public boolean getEmailContact() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactEmailTxt)).isDisplayed();
    }

    public boolean getPhoneContact() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactPhoneTxt)).isDisplayed();
    }

    public boolean getAddressContact() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactAddressTxt)).isDisplayed();
    }

    public void setFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFullName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFullName)).sendKeys(fullName);
    }

    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail)).sendKeys(email);
    }

    public void setPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhone)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhone)).sendKeys(phone);
    }

    public void setCompany(String company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompany)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompany)).sendKeys(company);
    }

    public void setHIGOspot() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceHIGOspot)).click();
    }

    public void setIDA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceIDA)).click();
    }

    public void setWA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceWA)).click();
    }

    public void setMessage(String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMessage)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMessage)).sendKeys(msg);
    }

    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn)).click();
    }

    public boolean getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
    }

    public boolean getErrorMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
    }
}
