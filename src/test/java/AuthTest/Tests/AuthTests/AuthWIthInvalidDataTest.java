package AuthTest.Tests.AuthTests;

import AuthTest.Models.UserData;
import AuthTest.Tests.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

public class AuthWIthInvalidDataTest extends TestBase {
    @Test(expected = TimeoutException.class)
    public void authWithValidData() {
        applicationManager.getLogin().Logout();
        applicationManager.getNavigation().OpenStartPage();
        applicationManager.getLogin().Login(invalidUser);
        UserData loggedUser = applicationManager.getLogin().getLoggedUser();
        Assert.assertNotEquals(loggedUser.getUsername().toLowerCase(), invalidUser.getUsername().toLowerCase());
    }
}
