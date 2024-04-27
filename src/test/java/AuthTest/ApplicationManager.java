package AuthTest;

import AuthTest.Services.Destructor;
import AuthTest.Services.LoginHelper;
import AuthTest.Services.NavigationHelper;
import AuthTest.Services.ReviewHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    public Map<String, Object> vars;
    JavascriptExecutor js;
    public FirefoxOptions options;
    public NavigationHelper navigation;
    public ReviewHelper review;
    public LoginHelper login;
    private static ApplicationManager instance = new ApplicationManager();
    private ApplicationManager() {
        options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navigation = new NavigationHelper(this);
        review = new ReviewHelper(this);
        login = new LoginHelper(this);

        Destructor.addManagerDestructor(this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
    public NavigationHelper getNavigation() {
        return this.navigation;
    }
    public ReviewHelper getReview() {
        return this.review;
    }
    public LoginHelper getLogin() {
        return this.login;
    }
    public void stop() {
        driver.quit();
    }
    public static ApplicationManager getInstance() {
        return instance;
    }
}
