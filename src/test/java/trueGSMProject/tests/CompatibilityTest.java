package trueGSMProject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CompatibilityTest {

    @Test
    public void test01_GoogleChrome() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://truegsm.ro/");
        System.out.println("The page opened successfully in Chrome");

        driver.close();
    }


    @Test
    public void test02_MozillaFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://truegsm.ro/");
        System.out.println("The page opened successfully in Firefox");

        driver.close();
    }

    @Test
    public void test03_MicrosoftEdge() {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://truegsm.ro/");
        System.out.println("The page opened successfully in Edge");

        driver.close();
    }
}