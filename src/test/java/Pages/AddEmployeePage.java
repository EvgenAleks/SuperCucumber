package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement pimTab;

    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement addEmpBtn;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='middleName']")
    public WebElement middleNameTextBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveBtn;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
