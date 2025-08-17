package TestNgConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

    //ex for this is - Homepage validation is depends on the login method
    //if the login method is successful then only we can validate the homepage

    //here i am failing login method so rest of the methods are not running

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

    @Test(dependsOnMethods = "login")
    public void logout()
    {
        System.out.println("Logout method");
    }
}
