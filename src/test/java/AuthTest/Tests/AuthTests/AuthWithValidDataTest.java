package AuthTest.Tests.AuthTests;

import AuthTest.Models.UserData;
import AuthTest.Tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class AuthWithValidDataTest extends TestBase {
    @Test
    public void authWithValidData() {
        applicationManager.getLogin().Logout();
        applicationManager.getNavigation().OpenStartPage();
        applicationManager.getLogin().Login(validUser);
        UserData loggedUser = applicationManager.getLogin().getLoggedUser();
        Assert.assertEquals(loggedUser.getUsername().toLowerCase(), validUser.getUsername().toLowerCase());
    }
}
