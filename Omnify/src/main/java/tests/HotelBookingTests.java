package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HotelBookingPage;

public class HotelBookingTests {

    WebDriver driver;
    HotelBookingPage bookingPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        bookingPage = new HotelBookingPage(driver);
    }

    @Test
    public void bookHotelWithCouponTest() {
        bookingPage.closeLoginPopup();
        bookingPage.clickHotelsTab();
        bookingPage.enterCity("New York");
        bookingPage.selectDates("Thu Apr 10 2025", "Tue Apr 15 2025");
        bookingPage.clickSearch();
        bookingPage.selectFirstHotel();
        bookingPage.clickBookNow();

        // Simulate coupon applied check
        boolean discountApplied = bookingPage.verifyDiscountApplied();
        Assert.assertTrue(discountApplied, "Discount not applied or not visible.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
