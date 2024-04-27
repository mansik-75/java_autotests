package AuthTest.Tests;

import AuthTest.ApplicationManager;
import AuthTest.Models.UserData;
import org.junit.Before;

public class TestBase {
    protected static ApplicationManager applicationManager;
    protected static UserData user = new UserData("janis_775", "7CL'>bsk:?fqU^7");
    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
