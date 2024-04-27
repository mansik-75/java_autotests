package AuthTest.Tests;

import AuthTest.Models.UserData;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest extends TestBase {
    @Test
    public void auth() {
        applicationManager.getNavigation().OpenStartPage();
        applicationManager.getLogin().Login(user);
        UserData loggedUser = applicationManager.getLogin().getLoggedUser();
        Assert.assertEquals(loggedUser.getUsername().toLowerCase(), user.getUsername().toLowerCase());
        applicationManager.getLogin().Logout();
    }
}
