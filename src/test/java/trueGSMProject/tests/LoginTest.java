package trueGSMProject.tests;

import trueGSMProject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//                   username, password
                {"silviugirbacea@gmail.com", "Parolacurs98@&"},

        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String username, String password) {
        getBrowser();
        getBaseURL();

        navigateToURL("/my-account/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("Login Successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username));

    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin2(String username, String password) {
        getBrowser();
        getBaseURL();

        navigateToURL("/my-account/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("Login Failed");
        Assert.assertFalse(loginPage.verifyLoginFailed(password));
    }
}