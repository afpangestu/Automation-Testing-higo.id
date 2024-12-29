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
}
