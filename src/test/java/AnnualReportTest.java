import config.BaseUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AnnualReportPage;

public class AnnualReportTest {
    WebDriver driver;
    AnnualReportPage annual;

    @DataProvider(name = "formdownload")
    // data user
    public Object[][] getData() {
        return new Object[][] {
                {"","","","","","","blank"},
                {"test1","aji1","thisisemail","62841331313","HIGOtechtest","SQA","wrong email"},
                {"test2","aji2","test@abc.jkt","62841","HIGOtechtest","SQA","wrong phone"},
                {"test3","aji3","test@abc.cms","62841331313","HIGOtechtest","SQA","success"},
        };
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        // open browser and url
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(BaseUrl.digital_reports);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.digital_reports);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void annualTitleTest() {
        annual = new AnnualReportPage(driver);
        Assert.assertTrue(annual.getAnnualTxt());
        System.out.println("==== Test Annual Report 'Heading' Success ====");
    }

    @Test(priority = 2)
    public void annualDescTest() {
        annual = new AnnualReportPage(driver);
        Assert.assertTrue(annual.getDescAnnualTxt());
        System.out.println("==== Test Annual Report 'Description' Success ====");
    }

    @Test(priority = 3)
    public void annualImageTest() {
        annual = new AnnualReportPage(driver);
        Assert.assertTrue(annual.getImageAnnual());
        System.out.println("==== Test Annual Report 'Image' Success ====");
    }

    @Test(priority = 4)
    public void annualAllLinkTest() {
        annual = new AnnualReportPage(driver);
        Assert.assertTrue(annual.getAllLinkTxt());
        System.out.println("==== Test Annual Report 'All Link Text' Success ====");
    }

    @Test(priority = 5)
    public void annualAllReferenceTest() {
        annual = new AnnualReportPage(driver);
        Assert.assertTrue(annual.getAllReference());
        System.out.println("==== Test Annual Report 'All References' Success ====");
    }

    @Test(priority = 6, dataProvider = "formdownload")
    public void annualFormDownloadTest(String firstName,
                                       String lastName,
                                       String email,
                                       String phoneNumber,
                                       String company,
                                       String jobTitle,
                                       String scenario) throws InterruptedException {
        annual = new AnnualReportPage(driver);
        // send key into form input
        annual.setFirstName(firstName);
        annual.setLastName(lastName);
        annual.setEmail(email);
        annual.setPhoneNumber(phoneNumber);
        annual.setCompanyName(company);
        annual.setJobTitle(jobTitle);
        // click download btn
        annual.clickBtnDownload();
        Thread.sleep(3000);
        // validate
        switch (scenario) {
            case "blank" -> {
                Assert.assertTrue(annual.getErrorMsg());
                annual.clearAllInput();
                System.out.println("==== Test Download Annual Report 'Blank Input' Success ====");
            }
            case "wrong email" -> {
                Assert.assertTrue(annual.getErrorMsg());
                annual.clearAllInput();
                System.out.println("==== Test Download Annual Report 'Wrong Email' Success ====");
            }
            case "wrong phone" -> {
                Assert.assertTrue(annual.getErrorMsg());
                annual.clearAllInput();
                System.out.println("==== Test Download Annual Report 'Wrong Phone Number' Success ====");
            }
            case "success" -> {
                annual.clearAllInput();
                System.out.println("==== Test Download Annual Report 'Valid Data' Success ====");
            }
        }
    }
}
