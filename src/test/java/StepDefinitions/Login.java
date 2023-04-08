package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Login extends CommonMethods {

//    @Given("open the browser and launch HRMS application")
//    public void open_the_browser_and_launch_hrms_application() {
//
//        openBrowserAndLaunchApplication();
//    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
        WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(userNameTextBox, ConfigReader.getPropertyValue("username"));
        WebElement passWordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(passWordTextBox, ConfigReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() {
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        doClick(loginBtn);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }

//    @Then("close the browser")
//    public void close_the_browser() {
//
//        closeBrowser();
//    }
}
