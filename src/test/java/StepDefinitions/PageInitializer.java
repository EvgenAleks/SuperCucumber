package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;
import com.beust.ah.A;

public class PageInitializer {

    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;


    public static void initalizePageObjects() {

        login = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }
}

// This class will manage the object creation of different page Objects in our Framework.
// Instead of calling the page objects again and again, this class will take good care of that step