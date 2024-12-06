package trueGSMProject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends BasePage {

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/button[3]")
    private WebElement acceptCookies;

    @FindBy(xpath = "/html/body/div[5]/header/div/div/div/div/div[3]/div[4]/a/span[1]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[10]/form/input[1]")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[5]/div/main/div/div[2]/div[1]/nav/span[5]")
    private WebElement searchResults;

    @FindBy(xpath = "/html/body/div[5]/div/main/div/div[3]/div")
    private WebElement errorMessageElement;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search(String searchInput) {
        System.out.println("Waiting for page to load");
        waitUntilElementVisible(acceptCookies);
        this.acceptCookies();
        this.searchButton();
        this.searchInput(searchInput);
        Actions actions = new Actions(driver);
        actions = actions.keyDown(Keys.ENTER);
        actions.keyUp(Keys.ENTER);
        actions.build().perform();
        System.out.println("Press Enter key after searchInput");
    }

    public void acceptCookies() {
        waitUntilElementVisible(acceptCookies);
        System.out.println("Accept Cookies");
        acceptCookies.click();
    }


    public void searchButton() {
        waitUntilElementVisible(searchButton);
        System.out.println("Click on the search button");
        searchButton.click();
    }

    public void searchInput(String searchData) {
        waitUntilElementVisible(searchInput);
        System.out.println("Search for a product:" + searchData);
        searchInput.clear();
        searchInput.sendKeys(searchData);
    }

    public boolean verifySearhResultsInvalid(String searchinvalid) {
        try{
            waitUntilElementVisible(errorMessageElement);
            System.out.println("Search results invalid: " + errorMessageElement.getText());
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not visible within timeout, continuing...");
        }
        return false;
    }

    public boolean verifySearchResultsValid(String searchvalid) {
        try{
            String xpath = "/html/body/div[5]/div/main/div/div[2]/div[1]/nav/span[5]";
            WebElement searchMessage = waitUntilElementVisible(By.xpath(xpath));
            System.out.println("Search results valid: " + searchMessage.getText());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}
