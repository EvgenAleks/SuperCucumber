package StepDefinitions;

import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;

    public static void initalizePageObjects() {

        login = new LoginPage();
    }
}

// This class will manage the object creation of different page Objects in our Framework.
// Instead of calling the page objects again and again, this class will take good care of that step