package trueGSMProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/button[3]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"post-11\"]/div/div/div[2]/p[1]/strong[1]")
    private WebElement loginOK;

    @FindBy(xpath = "//*[@id=\"post-11\"]/div/div[1]/ul/li")
    private WebElement errorMessageElement;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(acceptCookies);
        this.acceptCookies();
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }

    public void acceptCookies() {
        waitUntilElementVisible(acceptCookies);
        System.out.println("Accept Cookies");
        acceptCookies.click();
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(usernameInput);
        System.out.println("Enter username:" + username);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password:" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        System.out.println("Click on LOG IN button");
        loginButton.click();

    }

    public boolean verifyLoginSuccessful(String username) {
        try {
            String xpath = "//*[@id=\"post-11\"]/div/div/div[2]/p[1]/strong[1]";
            WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
            System.out.println("Welcome message displayed: Buna," + welcomeMessage.getText());
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not visible within timeout, continuing...");
        }
        return false;
    }
    public boolean verifyLoginFailed(String error) {
           try {
               waitUntilElementVisible(errorMessageElement);
               System.out.println("Error message displayed: " + errorMessageElement.getText());
               return true;
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
    }}

