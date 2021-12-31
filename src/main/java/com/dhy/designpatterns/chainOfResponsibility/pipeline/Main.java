package com.dhy.designpatterns.chainOfResponsibility.pipeline;

public class Main {
    public static void main(String[] args) {
        String handling = "aabb1122zzyy";
        StandardPipeline pipeline = new StandardPipeline();

        BasicValve basicValve = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();

        pipeline.setBasic(basicValve);
        pipeline.addValve(secondValve);
        pipeline.addValve(thirdValve);

        pipeline.getFirst().invoke(handling);
    }
}