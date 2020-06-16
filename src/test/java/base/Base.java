package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static WebDriverWait wait;


    protected static void setup() {

        setProperty();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,30){};
        waitForJSandJQueryToLoad();
    }

    private static void setProperty() {
        if (OS.contains("win")) System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        else System.setProperty("webdriver.chrome.driver", "bin/chromedriver-mac64");

    }

    private static void waitForJSandJQueryToLoad() {
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("js loaded");
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        wait.until(jsLoad);
    }


    protected static void closeOut(){
        driver.quit();
    }

}
