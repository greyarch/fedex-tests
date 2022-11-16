package fedex.pages;

import org.openqa.selenium.By;

import fedex.webui.FedexDriver;

public class HomePage  {
    FedexDriver driver;

    public HomePage(FedexDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.get("https://www.fedex.com/en-gb/home.html");
        driver.safeClick(By.xpath("//span[text()='English']"));
        driver.safeClick(By.cssSelector("button.is-save-all"));
        driver.waitFor(By.cssSelector("div.fxg-main-content"));
    }

    public void displayTrackingWithID(String trackingId) {
        driver.find(By.id("trackingnumber")).sendKeys(trackingId);
        driver.safeClick(By.id("btnSingleTrack"));
    }

    public void waitForTrackingError() {
        driver.waitFor(By.xpath(
                "//div[contains(., 'Unfortunately we are unable to retrieve your tracking results at this time. Please try again later.')]"));
    }

    public void waitForFedexLogo() {
        driver.waitFor(By.cssSelector("img.fxg-header__logo"));
    }
}
