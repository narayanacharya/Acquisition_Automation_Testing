package bdd.pages.Dashboard;

import bdd.base.Base;
import bdd.common.CommonTask;
import bdd.helper.FileProcess;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dashboard extends Base {

    static String baseUrl = System.getProperty("baseUrl");
    static String logoutXpath = "//*[@id=\"root\"]/div[1]/header/div/button";
    static String loginXpath = "//*[@id=\"root\"]/div[1]/header/div/a";

    public static void openUrl() {
        System.out.println("the base url is " + baseUrl);
        if (baseUrl == null) {
            baseUrl = "https://workspace-mgmt.np.speedprep.simoncomputing.com";
        }
        if (driver == null) {
            setup();
        }

        if (driver.getCurrentUrl().equals("data:,")) {
            driver.get(baseUrl);
        }

    }

    public static JsonObject getJsonData(String credentials) {
        JsonObject jsonObject = new FileProcess().getDataFromFile("src/test/resources/data.json");
        return jsonObject.get(credentials).getAsJsonObject();

    }

    public static void login(String credentials, boolean isForPasswordChanged) {
        JsonObject cred = getJsonData(credentials);
        Dashboard.openUrl();
        checkAndLogoutIfAlreadyLoggedIn();
        sleepForAWhile(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[1]/div/input")).sendKeys(cred.get("username").getAsString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).click();
        if (isForPasswordChanged) {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).sendKeys(cred.get("newpassword").getAsString());
        } else {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).sendKeys(cred.get("password").getAsString());

        }
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/button")).click();

    }

    private static void checkAndLogoutIfAlreadyLoggedIn() {
        boolean isPresent = isElementPresent(By.xpath("//*[@id=\"root\"]/div[1]/header/div/a"), "Login");
        if (!isPresent) {
            driver.findElement(By.xpath(logoutXpath)).click();
            sleepForAWhile(500);
        }
    }

    public static void logout() {

    }

    public static boolean isElementPresent(By element, String tocompare) {
        CommonTask.waitWithCondition(wait, "visibilityOfElement", element);
        sleepForAWhile(2000);
        WebElement webElement = driver.findElement(element);

        if (tocompare != null) {
            System.out.println("compare text is " + webElement.getText());
            System.out.println("need to compare  " + tocompare);
            return webElement.getText().equals(tocompare);
        }
        return webElement != null;
    }


    public static void signupNewAccount(String credentials) {

        checkAndLogoutIfAlreadyLoggedIn();
        JsonObject cred = getJsonData(credentials);
        driver.findElement(By.xpath(loginXpath)).click();
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[1]/div/input")).sendKeys(cred.get("firstname").getAsString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[2]/div/input")).sendKeys(cred.get("lastname").getAsString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[3]/div/input")).sendKeys(cred.get("username").getAsString());
        driver.findElement(By.id("password-outlined-Password")).sendKeys(cred.get("password").getAsString());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/button")).click();

    }

    public static boolean signupAccount() {
        sleepForAWhile(300);
        if (checkTextExistsInDom("A user with this email already exists.")) {
            return true;
        } else if (checkTextExistsInDom("Registered successfully; please login.")) {
            return true;

        } else {
            return false;
        }
    }


    public static boolean changePassword() {


        driver.findElement(By.xpath("//div[@id='root']/div/header/div/a[2]/span")).click();
        driver.findElement(By.id("password-outlined-Old password")).sendKeys("Changepassword123@");
        driver.findElement(By.id("password-outlined-New password")).sendKeys("Changepassword1234@");
        driver.findElement(By.id("password-outlined-Confirm new password")).sendKeys("Changepassword1234@");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/button")).click();
        sleepForAWhile(500);
        System.out.println("is present" + checkTextExistsInDom("Password reset successfully"));
        return checkTextExistsInDom("Password reset successfully");

    }

    //TODO use users delete as common from Users class and remove from here
    public static void clearAllCreatedAccount() {
        ClickUser("Testing");
        DeleteUser();
        ClickUser("Test for change password");
        DeleteUser();


    }

    public static void ClickUser(String name) {
        sleepForAWhile(3000);
        driver.findElement(By.xpath("//*[@id='user']/span[1]")).click();
        sleepForAWhile(3000);
        driver.findElement(By.xpath("//*[text()='" + name + "']")).click();

    }

    public static void DeleteUser() {
        sleepForAWhile(3000);
        driver.findElement(By.xpath("//*[@id='handle-delete']")).click();
        driver.findElement(By.xpath("//*[@id='confirm-delete']")).click();

    }
}
