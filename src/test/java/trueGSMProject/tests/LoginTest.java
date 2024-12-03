package trueGSMProject.tests;

import org.testng.Assert;
import trueGSMProject.POJO.LoginModel;
import trueGSMProject.data.LoginDataProvider;
import trueGSMProject.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginSQLDataProvider", dataProviderClass = LoginDataProvider.class)
    public void loginWithSQLAsDataSource(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }


    protected void loginWithLoginModel(LoginModel loginModel) {
        setUp();
        navigateToURL("/my-account/");

        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginModel);
        loginPage.login(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword());

        if (loginPage.verifyLoginSuccessful("")) {
            Assert.assertTrue(loginPage.verifyLoginSuccessful(""));
        } else if (loginPage.verifyLoginFailed(""))
            Assert.assertTrue(loginPage.verifyLoginFailed(""));
    }
}