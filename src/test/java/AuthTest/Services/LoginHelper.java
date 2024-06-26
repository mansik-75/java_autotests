package AuthTest.Services;

import AuthTest.ApplicationManager;
import AuthTest.Models.UserData;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper extends HelpBase {
    private Boolean logged = false;
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }
    public void Login(UserData user) {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getUsername())) {
                return;
            }
        }
        this.logged = true;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sign-in-menu .label"))).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".button-green")).click();
        if (!getLoggedUser().getUsername().toLowerCase().equals(user.getUsername())) {
            Login(user);
        }
    }
    public void Logout() {
        if (!isLoggedIn()) {
            return;
        }
        this.logged = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/section/div[1]/div/nav/ul/li[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sign-out\"]"))).click();
    }
    public UserData getLoggedUser() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/h1/a"))).getText();
            return new UserData(username, "passwd");
        } catch (Exception e) {
            return new UserData("", "");
        }
    }
    public Boolean isLoggedIn() {
        return this.logged;
    };
    public Boolean isLoggedIn(String username) {
        UserData user = getLoggedUser();
        this.logged = user.getUsername().equalsIgnoreCase(username);
        return this.logged;
    };
}
