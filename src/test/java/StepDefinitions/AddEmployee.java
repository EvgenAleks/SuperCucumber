package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        doClick(pimTab);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmpBtn = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        doClick(addEmpBtn);
    }

    @When("user enters firstname and middle name and lastname")
    public void user_enters_firstname_and_middle_name_and_lastname() {
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        sendText(firstNameTextBox, ConfigReader.getPropertyValue("firstname"));
        WebElement middleNameTextBox = driver.findElement(By.xpath("//input[@id='middleName']"));
        sendText(middleNameTextBox, ConfigReader.getPropertyValue("middlename"));
        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText(lastNameTextBox, ConfigReader.getPropertyValue("lastname"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

        WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
        doClick(saveBtn);
    }
}
