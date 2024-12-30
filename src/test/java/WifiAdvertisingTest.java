import config.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.WifiAdvertisingPage;
import util.Util;

public class WifiAdvertisingTest {
    WebDriver driver;
    WifiAdvertisingPage wifi;
    Util util;

    @BeforeClass
    public void setup() throws InterruptedException {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl.higo_services_wifi);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.higo_services_wifi);
        driver.switchTo().activeElement().click();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = {"unit", "smoke"})
    public void titleWifiAdvertTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getTitleServiceWifi());
        System.out.println("==== Test WiFi Advertising 'Heading' Success ====");
    }

    @Test(priority = 2, groups = {"unit", "smoke"})
    public void descWifiAdvertTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getDescWifi());
        System.out.println("==== Test WiFi Advertising 'Description Wifi Advertising' Success ====");
    }

    @Test(priority = 3, groups = {"unit", "smoke"})
    public void imgWifiAdvertTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getImageWifi());
        System.out.println("==== Test WiFi Advertising 'Image Wifi Advertising' Success ====");
    }

    @Test(priority = 4, groups = {"unit", "smoke"})
    public void footprintTxtTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getFootprintTxt());
        System.out.println("==== Test WiFi Advertising 'Footprint Heading' Success ====");
    }

    @Test(priority = 5, groups = {"unit", "smoke"})
    public void footprintListTest() {
        wifi = new WifiAdvertisingPage(driver);
        util = new Util(driver);
        int totalItem = util.getTotalItem("//li[@class='relative grid aspect-square p-4 @xl/section:size-48']");
        Assert.assertTrue(totalItem > 0);
        System.out.println("Total item: " + totalItem);
        Assert.assertTrue(wifi.getFootprintList());
        System.out.println("==== Test WiFi Advertising 'Footprint List' Success ====");
    }

    @Test(priority = 6, groups = {"unit", "smoke"})
    public void userApproachTxtTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getUserApproachTxt());
        System.out.println("==== Test WiFi Advertising 'Approach Heading' Success ====");
    }

    @Test(priority = 7, groups = {"unit", "smoke"})
    public void userApproachListTest() {
        wifi = new WifiAdvertisingPage(driver);
        util = new Util(driver);
        int totalItem = util.getTotalItem("//body//main//article");
        Assert.assertTrue(totalItem > 0);
        System.out.println("Total item: " + totalItem);
        Assert.assertTrue(wifi.getUserApproachList());
        System.out.println("==== Test WiFi Advertising 'Approach List' Success ====");
    }

    @Test(priority = 8, groups = {"unit", "smoke"})
    public void benefitsTxtTest() {
        wifi = new WifiAdvertisingPage(driver);
        Assert.assertTrue(wifi.getBenefitsTxt());
        System.out.println("==== Test WiFi Advertising 'Benefit Heading' Success ====");
    }

    @Test(priority = 9, groups = {"unit", "smoke"})
    public void benefitsListTest() {
        wifi = new WifiAdvertisingPage(driver);
        int totalItem = util.getTotalItem("//div[@class='grid gap-y-14 py-16 grid-popout @2xl/page:py-40 @3xl/page:py-32']//ul//li");
        Assert.assertTrue(totalItem > 0);
        System.out.println("Total item: " + totalItem);
        Assert.assertTrue(wifi.getBenefitsList());
        System.out.println("==== Test WiFi Advertising 'Benefit List' Success ====");
    }

    @Test(priority = 10, groups = {"unit", "smoke"})
    public void clickBtnAdvertiseNowTest() throws InterruptedException {
        wifi = new WifiAdvertisingPage(driver);
        wifi.clickBtnAdvertiseNow();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl.contact_us_wifi);
        System.out.println("==== Test WiFi Advertising 'Click Button Advertise Now' Success ====");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
