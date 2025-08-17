package TestNgConcepts;

import org.testng.annotations.*;

public class TestngAnnotations {

    @BeforeSuite
    public void test1()
    {
        System.out.println("Before suite");
    }

    @BeforeTest
    public void test2()
    {
        System.out.println("Before test");
    }

    @BeforeClass
    public void test3()
    {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void test4()
    {
        System.out.println("Before method");
    }

    @Test
    public void test5()
    {
        System.out.println("Test method");
    }

    @AfterClass
    public void test6()
    {
        System.out.println("After Class");
    }

    @AfterMethod
    public void test7()
    {
        System.out.println("After method");
    }

    @AfterTest
    public void test8()
    {
        System.out.println("After test");
    }

    @AfterSuite
    public void test9()
    {
        System.out.println("After suite");
    }
}
