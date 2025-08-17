package TestNgConcepts;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test(invocationCount = 4)
    public void test()
    {
        System.out.println("hi");
    }
}
