package org.kavya;

public class NonBuildPattern {

    public static void main(String[] args) {

        NonBuildPattern np = new NonBuildPattern();
        np.step3();
        np.step1();
        np.step2();
        //non-builder pattern, we can use any method in any order.

    }

    public void step1()
    {
        System.out.println("step 1");
    }

    public void step2()
    {
        System.out.println("Step 2");
    }
    public void step3()
    {
        System.out.println("step 3");
    }
}
