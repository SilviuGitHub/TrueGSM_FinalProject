package trueGSMProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import trueGSMProject.POJO.RegistrationModel;
import trueGSMProject.data.RegistrationDataProvider;
import trueGSMProject.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "registrationJSONDataProvider", dataProviderClass = RegistrationDataProvider.class)
    public void registrationwithJSONasDataProvider(RegistrationModel registrationModel) {
        registerWithRegistrationModel(registrationModel);
    }

    protected void registerWithRegistrationModel(RegistrationModel registrationModel) {
        setUp();
        navigateToURL("/my-account/");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);
        registrationPage.registration(registrationModel.getAccount().getUsername());

        if (registrationPage.verifyRegistrationSuccessful("")) {
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(""));
        } else if (registrationPage.verifyRegistrationFailed(""))
            Assert.assertTrue(registrationPage.verifyRegistrationFailed(""));
    }
}
