package AuthTest.Tests.AuthTests;

import AuthTest.Models.UserData;
import AuthTest.Tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest extends TestBase {
    @Test
    public void auth() {
        applicationManager.getLogin().Login(user);
        UserData loggedUser = applicationManager.getLogin().getLoggedUser();
        Assert.assertEquals(loggedUser.getUsername().toLowerCase(), user.getUsername().toLowerCase());
    }
}
