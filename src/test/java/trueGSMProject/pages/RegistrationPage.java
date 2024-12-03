package trueGSMProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/button[3]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[3]/a")
    private WebElement registrationForm;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/button")
    private WebElement registrationButton;

    @FindBy(id = "reg_email")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"post-11\"]/div/div[1]/ul/li")
    private WebElement errorMessageElement;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void registration(String email) {
        System.out.println("Waiting for registration page to load");
        waitUntilElementVisible(acceptCookies);
        this.acceptCookies();
        this.registrationForm();
        this.emailInput(email);
        this.submit();
    }

    public void acceptCookies() {
        waitUntilElementVisible(acceptCookies);
        System.out.println("Accept Cookies");
        acceptCookies.click();
    }


    public void registrationForm() {
        waitUntilElementVisible(registrationForm);
        System.out.println("Click on the registration form button");
        registrationForm.click();
    }

    public void emailInput(String email) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email:" + email);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        System.out.println("Click on the INREGISTRARE button");
        registrationButton.click();
    }


    public boolean verifyRegistrationSuccessful(String email) {
        try{
        String xpath = "//*[@id=\"post-11\"]/div/div/div[2]/p[1]";
        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return true;
        } catch (TimeoutException e) {
            System.out.println("Element not visible within timeout, continuing...");
        }
        return false;
    }

    public boolean verifyRegistrationFailed(String errorMessage) {
        try{
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}

