package AuthTest.Tests;

import AuthTest.ApplicationManager;
import AuthTest.Models.UserData;
import org.junit.Before;

public class TestBase {
    protected static ApplicationManager applicationManager;
    protected static UserData user = UserData.readFromFile("TestData/user.xml");
    protected static UserData validUser = UserData.readFromFile("TestData/user.xml");
    protected static UserData invalidUser = UserData.readFromFile("TestData/invalidUser.xml");
    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigation().OpenStartPage();
    }
}
