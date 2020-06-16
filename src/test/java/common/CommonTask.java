package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonTask {

    public static void navigateTo(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public static void waitWithCondition(WebDriverWait wait, String type, By by) {
        switch (type) {
            case "elementClickable":
                wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
            case "presenceOfElement":
                wait.until(ExpectedConditions.presenceOfElementLocated(by));
                break;

            case "visibilityOfElement":
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
        }
    }

    public static void windowScroll(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(" + x + "," + "y" + ")";
        js.executeScript("window.scrollBy(0,-100)");
    }


}
