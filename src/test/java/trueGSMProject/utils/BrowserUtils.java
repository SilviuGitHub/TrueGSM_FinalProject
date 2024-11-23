package trueGSMProject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
    public static WebDriver getDriver(String browser) {
        return getDriver(browser, "local");
    }


    public static WebDriver getDriver(String browser, String environment) {
        switch (browser.toLowerCase()) {

            case "firefox": {
                return new FirefoxDriver();
            }
            case "chrome": {
                return new ChromeDriver();
            }
            case "edge": {
                return new EdgeDriver();
            }
            default: {
                return new ChromeDriver();
            }
        }
    }
}