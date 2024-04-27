package AuthTest.Services;

import AuthTest.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelpBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;
    public HelpBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }
}
