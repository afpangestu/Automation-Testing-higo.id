package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnnualReportPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public AnnualReportPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By annualTxt = By.xpath("//h1[contains(text(),'HIGO')]");
    By descAnnualTxt = By.xpath("//p[contains(text(),'Gen Z & Milenial')]");
    By btnDownloadReport = By.xpath("//button[contains(text(), 'Download Full Report')]");
    By btnDownload = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[3]/button[1] | //button[@type='submit'][contains(text(),'Download')]");
    By imageAnnual = By.xpath("//img[@class='aspect-[135/152] w-full object-contain object-center duration-500 animate-in fade-in slide-in-from-bottom-6 @3xl/section:px-20']");
    By allLinkTxt = By.xpath("//a[@class='underline underline-offset-4']");
    By reference = By.xpath("//ol//li[@class='text-primary']");
    By formDialog = By.xpath("//p[contains(text(),'Get Your Copy')]");
    By inputFirstName = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[1]/input | //input[@name='firstName']");
    By inputLastName = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[2]/input | //input[@name='lastName']");
    By inputEmail = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[3]/input | //input[@name='email']");
    By inputPhoneNumber = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[4]/input | //input[@name='phone']");
    By inputCompanyName = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[5]/input | //input[@name='company']");
    By inputJobTitle = By.xpath("//*[@id='radix-:Rec6fnjbta:']/form/div[2]/div[6]/input | //input[@name='jobTitle']");
    By errorInputMessage = By.xpath("//p[@class='text-xs text-red-500']");

    // methods
    public boolean getAnnualTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(annualTxt)).isDisplayed();
    }

    public boolean getDescAnnualTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descAnnualTxt)).isDisplayed();
    }

    public void clickBtnDownloadReport() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDownloadReport)).click();
    }

    public void clickBtnDownload() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDownload)).click();
    }

    public boolean getImageAnnual() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageAnnual)).isDisplayed();
    }

    public boolean getAllLinkTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allLinkTxt)).isDisplayed();
    }

    public boolean getAllReference() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reference)).isDisplayed();
    }

    public void setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFirstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFirstName)).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).sendKeys(lastName);
    }

    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail)).sendKeys(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber)).sendKeys(phoneNumber);
    }

    public void setCompanyName(String companyName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompanyName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompanyName)).sendKeys(companyName);
    }

    public void setJobTitle(String jobTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputJobTitle)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputJobTitle)).sendKeys(jobTitle);
    }

    public boolean getFormDialog() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formDialog)).isDisplayed();
    }

    public boolean getErrorMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorInputMessage)).isDisplayed();
    }

    public void clearAllInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFirstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompanyName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputJobTitle)).clear();
    }
}
