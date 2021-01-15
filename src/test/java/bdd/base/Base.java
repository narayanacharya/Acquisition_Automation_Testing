package bdd.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static WebDriverWait wait;


    protected static void setup() {

        setProperty();
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        options.addArguments("--headless", "--no-sandbox", "--disable-gpu", "--disable-dev-shm-usage", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30) {
        };
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
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        wait.until(jsLoad);
    }

    public static void sleepForAWhile(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkTextExistsInDom(String text) {
        sleepForAWhile(400);
        return driver.getPageSource().contains(text);
    }

    public static void closeOut() {
      //  if (driver != null) driver.quit();
    }

}
