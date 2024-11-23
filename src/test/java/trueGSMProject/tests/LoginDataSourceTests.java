package trueGSMProject.tests;

import trueGSMProject.ObjectModels.LoginModel;
import trueGSMProject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDataSourceTests extends BaseTest {

    @Test(dataProvider = "loginJsonDataProvider", dataProviderClass = DataProviders.LoginDataProvider.class)
    public void loginWithJsonAsDataSource(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }

    @Test(dataProvider = "loginCSVDataProvider", dataProviderClass = DataProviders.LoginDataProvider.class)
    public void loginWithCSVAsDataSource(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }

    @Test(dataProvider = "loginSQLDataProvider", dataProviderClass = DataProviders.LoginDataProvider.class)
    public void loginWithSQLAsDataSource(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }


    protected void loginWithLoginModel(LoginModel loginModel) {
        setUp();
        navigateToURL("/my-account/");

        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginModel);
        loginPage.login(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword());

        if (loginModel.getLoginErr().isEmpty()) {
            System.out.println("Verify login successful");
            Assert.assertTrue(loginPage.verifyLoginSuccessful(loginModel.getAccount().getUsername()));
        } else {
            System.out.println("Verify login failed with message: " + loginModel.getLoginErr());
            Assert.assertTrue(loginPage.verifyLoginFailed(loginModel.getLoginErr()));
        }
    }
}
