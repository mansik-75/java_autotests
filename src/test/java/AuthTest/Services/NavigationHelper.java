package AuthTest.Services;

import AuthTest.ApplicationManager;
import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelpBase {
    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }
    public void OpenStartPage() {
        driver.get("https://letterboxd.com/");
        driver.manage().window().setSize(new Dimension(1006, 828));
    }
    public void OpenPage(String page) {
        driver.get(page);
    }
}
