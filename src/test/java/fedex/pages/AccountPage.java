package fedex.pages;

import org.openqa.selenium.By;

import fedex.webui.FedexDriver;

public class AccountPage  {
    FedexDriver driver;

    public AccountPage(FedexDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.safeClick(By.xpath("//span[text()='Sign Up/Log In ']"));
        driver.safeClick(By.partialLinkText("Log In"));
        driver.waitFor(By.xpath("//h1[text()=' Enter your user ID and password to log in ']"));
    }

    public void waitForLoginBox() {
        driver.find(By.id("userId"));
        driver.find(By.id("password"));
        driver.find(By.id("login-btn"));
    }
}
