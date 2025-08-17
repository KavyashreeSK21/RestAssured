package org.kavya.AssertionInRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ByUsingTestng {

    //In testng we have 2 types of assertions
    //1.Hard Assertion- If assertion fails then it will stop the execution
   // Assert.assertEquals();
    //2.Soft assertion - If assertion fail then also it continue the execution
   // SoftAssert sa=new SoftAssert();
   // sa.assertEquals();
    //sa.assertAll();

    //hard assert

//    @Test
//    public void hardAssertDemo()
//    {
//        System.out.println("Start the execution");
//        Assert.assertFalse(true);
//        System.out.println("End of program");
//    }


    @Test
    public void softAssertDemo()
    {
        SoftAssert sa=new SoftAssert();
        System.out.println("Start the execution");
        sa.assertFalse(true);
        System.out.println("End of program");
    }



}
