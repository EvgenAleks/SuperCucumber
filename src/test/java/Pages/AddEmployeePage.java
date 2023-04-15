package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement pimTab;
}
