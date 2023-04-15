package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Login extends CommonMethods {

//    @Given("open the browser and launch HRMS application")
//    public void open_the_browser_and_launch_hrms_application() {
//
//        openBrowserAndLaunchApplication();
//    }

    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {

        LoginPage login = new LoginPage();

//        WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.userNameTextBox, ConfigReader.getPropertyValue("username"));
//        WebElement passWordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passWordTextBox, ConfigReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() {

        LoginPage login = new LoginPage();

//        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        doClick(login.loginBtn);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {

        LoginPage login = new LoginPage();

//        WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.userNameTextBox, username);
//        WebElement passWordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passWordTextBox, password);
    }

//    @Then("close the browser")
//    public void close_the_browser() {
//
//        closeBrowser();
//    }

    @When("user enters valid username and password and verifies login")
    public void user_enters_valid_username_and_password_and_verifies_login(DataTable dataTable) {

        LoginPage login = new LoginPage();

        List<Map<String, String>> userCredentials = dataTable.asMaps();
        for (Map<String, String> userCreds : userCredentials) {
            String username = userCreds.get("username");
            String password = userCreds.get("password");
            WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
            sendText(userNameTextBox, username);
            WebElement passWordTextBox = driver.findElement(By.id("txtPassword"));
            sendText(passWordTextBox, password);

//            WebElement loginBtn = driver.findElement(By.id("btnLogin"));
            doClick(login.loginBtn);

//            WebElement welcomeIcon = driver.findElement(By.id("welcome"));
            doClick(login.welcomeIcon);

//            WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
            doClick(login.logoutLink);
        }
    }
}
