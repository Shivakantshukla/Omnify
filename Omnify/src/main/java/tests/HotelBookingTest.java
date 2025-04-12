package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HotelBookingPage;

public class HotelBookingTest {

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
    public void bookHotelWithCouponTest() throws InterruptedException {
        bookingPage.closeLoginPopup();
        bookingPage.clickHotelsTab();
        Thread.sleep(3000);
        bookingPage.enterCity("New York");
        Thread.sleep(3000);
        bookingPage.selectDates("Sun Apr 20 2025", "Mon Apr 21 2025");
//        Thread.sleep(3000);
        bookingPage.selectGuest();
        bookingPage.clickSearch();
                Thread.sleep(6000);
        bookingPage.selectFirstHotel();
        bookingPage.clickBookNow();
        bookingPage.applyCouponCode("SUMMER25");
        // Simulate coupon applied check
        boolean discountApplied = bookingPage.verifyDiscountApplied();
        Assert.assertTrue(discountApplied, "Sorry! Promocode used is not applicable at the moment.");
    }



    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
