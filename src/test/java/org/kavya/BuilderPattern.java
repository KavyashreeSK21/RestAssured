package org.kavya;

public class BuilderPattern {

    public static void main(String[] args) {
        BuilderPattern bp=new BuilderPattern();
        bp.step1().step3().step2();

    }

    public BuilderPattern step1()
    {
        System.out.println("step 1");
        return  this;
    }

    public BuilderPattern step2()
    {
        System.out.println("Step 2");
        return this;
    }
    public BuilderPattern step3() {
        System.out.println("Step 3");
        return this;
    }
}
