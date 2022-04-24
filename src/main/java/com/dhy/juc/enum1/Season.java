package com.dhy.juc.enum1;

/**
 * 自定义类实现枚举
 */
public class Season {
    private final int seasonCode;
    private final String seasonName;
    private final String seasonDesc;
    private Season(int seasonCode,String seasonName,String seasonDesc){
        this.seasonCode = seasonCode;
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season(1,"spring","春天到了");
    public static final Season SUMMER = new Season(2,"summer","夏天来了");
    public static final Season AUTUMN = new Season(3,"autumn","树叶黄了");
    public static final Season WINNER = new Season(4,"winner","寒风刺骨");


    @Override
    public String toString() {
        return "Season{" +
                "seasonCode=" + seasonCode +
                ", seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        System.out.println(spring.toString());
        System.out.println(summer.toString());

    }

}
