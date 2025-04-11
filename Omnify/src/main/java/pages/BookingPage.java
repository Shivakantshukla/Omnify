package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {
    WebDriver driver;

    // Locators (replace with actual ones)
    private By locationInput = By.id("location");
    private By checkInDate = By.id("checkin");
    private By checkOutDate = By.id("checkout");
    private By searchButton = By.id("searchBtn");

    private By firstHotel = By.cssSelector(".hotel-list .hotel:first-child .select-btn");

    private By couponField = By.id("coupon");
    private By applyCouponBtn = By.id("applyCoupon");
    private By discountAmount = By.id("discount");
    private By finalAmount = By.id("finalPrice");

    private By checkoutButton = By.id("checkout");

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchHotels(String location, String checkIn, String checkOut) {
        driver.findElement(locationInput).sendKeys(location);
        driver.findElement(checkInDate).sendKeys(checkIn);
        driver.findElement(checkOutDate).sendKeys(checkOut);
        driver.findElement(searchButton).click();
    }

    public void selectFirstHotel() {
        driver.findElement(firstHotel).click();
    }

    public void applyCoupon(String couponCode) {
        driver.findElement(couponField).sendKeys(couponCode);
        driver.findElement(applyCouponBtn).click();
    }

    public String getDiscountText() {
        return driver.findElement(discountAmount).getText();
    }

    public String getFinalPrice() {
        return driver.findElement(finalAmount).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
