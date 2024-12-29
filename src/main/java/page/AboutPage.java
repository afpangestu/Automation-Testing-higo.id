package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {
    WebDriver driver;
    WebDriverWait wait;

    // constructor
    public AboutPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By aboutHigoTxt = By.xpath("//h1[contains(text(),'HIGO')]");
    By descHigoTxt = By.xpath("//p[@class='z-10 text-sm duration-700 animate-in fade-in slide-in-from-bottom-6 @3xl/page:text-lg']");
    By imageAbout = By.xpath("//img[@alt='About HIGO'] | //img[@alt='Tentang HIGO']");
    By sixYearsTxt = By.xpath("//h2[contains(text(),'6 Tahun')] | //h2[contains(text(),'6 Years')]");
    By coreValueTxt = By.xpath("//h2[contains(text(),'Core values')] | //h2[contains(text(),'Core value')]");
    By grow2GetherTxt = By.xpath("//h2[contains(text(),'Grow')] | //h2[contains(text(),'Bertumbuh')]");
    By imageGrow = By.xpath("/html/body/main/section[4]/div/div/img");
    By btnBePartHigo = By.xpath("//a[@class='grid grid-flow-col items-center gap-x-3 place-self-center rounded-full bg-primary px-7 py-2 text-center text-base text-white hover:bg-[#0EB0C4]']");


    // methods
    public boolean getTitleAboutHigo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(aboutHigoTxt)).isDisplayed();
    }

    public boolean getDescHigo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descHigoTxt)).isDisplayed();
    }

    public boolean getImageAbout() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageAbout)).isDisplayed();
    }

    public boolean getSixYearsTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sixYearsTxt)).isDisplayed();
    }

    public boolean getCoreValueTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(coreValueTxt)).isDisplayed();
    }

    public boolean getGrowTxt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(grow2GetherTxt)).isDisplayed();
    }

    public boolean getImageGrow() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageGrow)).isDisplayed();
    }

    public void clickBtnBePartHigo() {
        wait.until(ExpectedConditions.elementToBeClickable(btnBePartHigo)).click();
    }
}
