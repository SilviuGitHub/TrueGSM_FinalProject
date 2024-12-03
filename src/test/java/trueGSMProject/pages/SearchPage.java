package trueGSMProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;

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
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Press Enter key after searchInput");
        System.out.println(searchResults.getText() + " " + errorMessageElement.getText());
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

}
