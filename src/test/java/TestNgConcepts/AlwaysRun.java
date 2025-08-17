package TestNgConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlwaysRun {

    @Test
    public void login()
    {
        Assert.assertFalse(true);
        System.out.println("Login to app");
    }

    @Test(dependsOnMethods = "login")
    public void homePageValidation()
    {
        System.out.println("Homepage validation");
    }

    @Test(dependsOnMethods = "login",alwaysRun = true)
    public void logout()
    {
        System.out.println("Logout method");//even though logout method depends on login we made this always run so it is running
    }
}
