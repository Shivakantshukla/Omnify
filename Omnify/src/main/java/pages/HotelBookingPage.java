package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HotelBookingPage extends BasePage {

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }

    public void closeLoginPopup() {
        try {
            WebElement body = driver.findElement(By.tagName("body"));
            new Actions(driver).moveByOffset(10, 10).click().build().perform();
        } catch (Exception ignored) {}
    }

    public void clickHotelsTab() {
        click(By.xpath("//span[text()='Hotels']"));
    }

    public void enterCity(String cityName) {
        click(By.id("city"));
        click(By.xpath("//p[contains(text(),'" + cityName + "')]"));
    }

    public void selectDates(String checkInLabel, String checkOutLabel) {
        click(By.xpath("//div[@aria-label='" + checkInLabel + "']"));
        click(By.xpath("//div[@aria-label='" + checkOutLabel + "']"));
    }

    public void clickSearch() {
        click(By.xpath("//button[text()='Search']"));
    }

    public void selectFirstHotel() {
        waitForVisible(By.cssSelector("div.makeFlex"));
        click(By.cssSelector("div.makeFlex a"));

        // Switch to new tab
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        waitForVisible(By.tagName("body"));
    }

    public void clickBookNow() {
        click(By.xpath("//span[text()='BOOK THIS NOW']"));
    }

    // Simulate or locate a discount label
    public boolean verifyDiscountApplied() {
        try {
            WebElement discountLabel = driver.findElement(By.xpath("//*[contains(text(), 'discount') or contains(text(), 'OFF')]"));
            return discountLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
