import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.ContactPage;
import provider.DataProviders;


public class ContactHigoTest {
    WebDriver driver;
    ContactPage contactPage;

    @BeforeClass(groups = {"unit", "smoke"})
    public void setup() throws InterruptedException {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.contact_us);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.contact_us);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void contactTitleTest() {
        contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.getTitleContact());
        System.out.println("==== Test Contact HIGO 'Heading' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void contactEmailTest() {
        contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.getEmailContact());
        System.out.println("==== Test Contact HIGO 'Email' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void contactPhoneTest() {
        contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.getPhoneContact());
        System.out.println("==== Test Contact HIGO 'Phone Number' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void contactAddressTest() {
        contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.getAddressContact());
        System.out.println("==== Test Contact HIGO 'Address' Success ====");
    }

    @Test(dataProvider = "contact_higo", dataProviderClass = DataProviders.class, groups = {"unit", "smoke"})
    public void contactFormTest(String name,
                           String email,
                           String phone,
                           String company,
                           String service,
                           String message,
                           String scenario) {
        contactPage = new ContactPage(driver);
        // input data
        contactPage.setFullName(name);
        contactPage.setEmail(email);
        contactPage.setPhone(phone);
        contactPage.setCompany(company);
        contactPage.setMessage(message);
        if (service.equals("ida")) {
            contactPage.setIDA();
        } else if (service.equals("wa")) {
            contactPage.setWA();
        }
        contactPage.clickSubmitBtn();
        switch (scenario) {
            case "wa", "ida", "blank" -> contactPage.getErrorMsg();
            case "success" -> {
                contactPage.getSuccessMsg();
                System.out.println("==== Test Contact HIGO 'Form Contact' Success ====");
            }
        }
    }

    @AfterClass(groups = {"unit", "smoke"})
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
