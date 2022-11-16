package fedex.webui;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class FedexDriver extends ChromeDriver {
    public WebDriverWait wait;
    
    private static ChromeOptions driverOptions() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        options.addArguments("--no-sandbox");
        return options;
    }

    public FedexDriver() {
        super(FedexDriver.driverOptions());
        manage().window().maximize();
        wait = new WebDriverWait(this, 10);
    }

    public void waitFor(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement find(By locator) {
        return findElement(locator);
    }

    public void safeClick(By locator) {
        this.waitFor(locator);
        this.find(locator).click();
    }

    public void takeSnapshot(String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) this);

        // Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination

        File DestFile = new File(fileWithPath);

        // Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}
