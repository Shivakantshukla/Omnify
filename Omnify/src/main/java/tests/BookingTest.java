//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import pages.BookingPage;
//
//public class BookingTest {
//
//    WebDriver driver;
//    BookingPage bookingPage;
//
//    @BeforeClass
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://your-hotel-app.com"); // Replace with actual app URL
//        bookingPage = new BookingPage(driver);
//    }
//
//
//    @Test
//    public void testHotelBookingWithCoupon() {
//        bookingPage.searchHotels("New York", "2025-04-10", "2025-04-15");
//
//        bookingPage.selectFirstHotel();
//
//        bookingPage.applyCoupon("SUMMER25");
//
//        String discount = bookingPage.getDiscountText();
//        String finalPrice = bookingPage.getFinalPrice();
//
//        System.out.println("Discount: " + discount);
//        System.out.println("Final Price: " + finalPrice);
//
//        Assert.assertTrue(discount.contains("25") || discount.length() > 0, "Discount not applied");
//
//        bookingPage.proceedToCheckout();
//
//        // Do NOT complete payment
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//}
