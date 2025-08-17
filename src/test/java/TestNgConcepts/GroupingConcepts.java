package TestNgConcepts;

import org.testng.annotations.Test;

//here i want to run only regression test or i want only smoke or sanity testcases we go for grouping
//create a testng file there mention group tag and add what ever test we want to do inside the include tag

public class GroupingConcepts {

    @Test(groups = {"reg"})
    public void regressionTest()
    {
        System.out.println("regresssion");
    }

    @Test(groups = {"smoke","reg"})
    public void smokeTest()
    {
        System.out.println("smoke");
    }

    @Test(groups = {"sanity","reg"})
    public void sanityTest()
    {
        System.out.println("sanity");
    }
}
