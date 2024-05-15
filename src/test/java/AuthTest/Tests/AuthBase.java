package AuthTest.Tests;

import org.junit.Before;

public class AuthBase extends TestBase {
    @Before
    public void setUp() {
        applicationManager.getLogin().Login(user);
    }
}
