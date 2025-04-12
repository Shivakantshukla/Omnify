package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HotelBookingPage extends BasePage {

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }
    //closing the login popup page
    public void closeLoginPopup() {
        try {
            WebElement body = driver.findElement(By.tagName("body"));
            new Actions(driver).moveByOffset(10, 10).click().build().perform();
        } catch (Exception ignored) {}
    }

    public void clickHotelsTab() {
        click(By.xpath("//span[text()='Hotels']"));
        // going to hotel booking page
    }

    public void enterCity(String cityName) throws InterruptedException {
//        WebElement cityInput = driver.findElement(By.id("city"));
//        cityInput.click();
//        click(By.xpath("//input[@id='city']"));
//        WebElement inputField = driver.findElement(By.xpath("//input[@id=\"city\"]"));
//        inputField.sendKeys("Bangalore");
        // Click the city field first to activate the input
        WebElement cityContainer = driver.findElement(By.xpath("//input[@id=\"city\"]"));
        cityContainer.click();

        Thread.sleep(2000); // Wait for the input to become interactable

// Locate the actual input field and type "Bangalore"
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Where do you want to stay?']"));
        inputField.sendKeys("Bangalore");

        Thread.sleep(2000); // Wait for dropdown options to appear

// Select the first suggestion
//        WebElement firstSuggestion = driver.findElement(By.xpath("//p[contains(text(), 'Bangalore')]"));
//        firstSuggestion.click();
        click(By.xpath("//div[@class='searchedResult font16 darkText']"));

    }

    public void selectDates(String checkInLabel, String checkOutLabel) {
//        click(By.xpath("//input[@id='checkin']"));
        click(By.xpath("//div[@aria-label='" + checkInLabel + "']"));
        //accpet date as Thu Apr 17 2025 format
//        click(By.xpath("//input[@id='checkout']"));
        click(By.xpath("//div[@aria-label='" + checkOutLabel + "']"));
    }

    public void selectGuest(){
        //selecting prefilled guest count
        click(By.xpath("//button[@class='primaryBtn btnApplyNew pushRight capText']"));
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

//        List<WebElement> element = driver.findElements(By.xpath("//div[@class='flexOne makeFlex']"));
//        element.click();

    }

    public void clickBookNow() {
        click(By.xpath("//span[text()='BOOK THIS NOW']"));
    }

    // Simulate or locate a discount label
    public boolean verifyDiscountApplied() {
        try{
            //chceking if coupon is selected and discount is applied
            WebElement discountApplied = driver.findElement(By.xpath("//p[@class='font12 lineHight16']"));
            if(discountApplied.getText().contains("Congratulations! Discount of ")){
                return true;
            }else{
                return false;
            }
        }catch (NoSuchElementException e) {
            return false;
        }
    }


    public void applyCouponCode(String Code){
        WebElement enterCoupon = driver.findElement(By.xpath("//input[@placeholder='Have a Coupon Code']"));
        enterCoupon.sendKeys(Code);
        click(By.xpath("//a[@data-testid='applyCpnBtn']"));
    }
}
