package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonMethods {

    @FindBy(id="txtUsername")
    public WebElement userNameTextBox;

    @FindBy(id="txtPassword")
    WebElement passWordTextBox;

    @FindBy(id="btnLogin")
    WebElement loginBtn;

    // Page Factory Model

}
