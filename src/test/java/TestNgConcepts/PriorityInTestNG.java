package TestNgConcepts;

import org.testng.annotations.Test;

public class PriorityInTestNG {

    //by default 0 will be the priority
    //we can give -ve values to priority
    //lowest value will be executed 1st
    //-1 -2 -3 0 in this -3 will execute 1st
    //by default, natural order will execute that means alphabetical order

    @Test(priority = 1)
    public void test1()
    {
        System.out.println("B");
    }

    @Test(priority = 0)
    public void test2()
    {
        System.out.println("A");
    }

    @Test(priority = 2)
    public void test3()
    {
        System.out.println("C");
    }
}
