package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
//        driver.findElement(By.id("menu_pim_viewPimModule")).click();
//        WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        doClick(addEmployeePage.pimTab);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
//        WebElement addEmpBtn = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        doClick(addEmployeePage.addEmpBtn);
    }

    @When("user enters firstname and middle name and lastname")
    public void user_enters_firstname_and_middle_name_and_lastname() {
//        driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
//        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        sendText(addEmployeePage.firstNameTextBox, ConfigReader.getPropertyValue("firstname"));
//        driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
//        WebElement middleNameTextBox = driver.findElement(By.xpath("//input[@id='middleName']"));
        sendText(addEmployeePage.middleNameTextBox, ConfigReader.getPropertyValue("middlename"));
//        driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));
//        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText(addEmployeePage.lastNameTextBox, ConfigReader.getPropertyValue("lastname"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

//        WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
        doClick(addEmployeePage.saveBtn);
    }
}
