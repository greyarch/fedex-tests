package fedex;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import fedex.webui.FedexDriver;
import fedex.pages.AccountPage;
import fedex.pages.HomePage;

public class Steps {
    FedexDriver driver = new FedexDriver();
    HomePage homePage;
    AccountPage accountPage;
    
    @Given("user is on the Home Page")
    public void userIsOnTheHomePage() {
        homePage = new HomePage(driver);
        homePage.go();
    }
    
    @When("user tries to log in")
    public void userTriesToLogin() {
        accountPage = new AccountPage(driver);
        accountPage.go();
    }

    @When("display tracking with ID {word}")
    public void displayTrackingWithID(String trackingId) {
        homePage.displayTrackingWithID(trackingId);
    }
    
    @Then("user gets to the Account Page")
    public void userGetsToTheAccountPage() {
        accountPage.waitForLoginBox();
    }
    
    @Then("tracking error is displayed")
    public void trackingErrorIsDisplayed() {
        homePage.waitForTrackingError();
    }
     
    @Then("the FedEx logo is visible")
    public void theFedExLogoIsVisible() {
        homePage.waitForFedexLogo();
    }
    
    @After()
    public void closeBrowser() throws Exception {
        driver.takeSnapshot("./test.png");
        driver.quit();
    }

}
