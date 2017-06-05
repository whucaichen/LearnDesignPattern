package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class Test {

    public static void main(String[] args) {
        int result;
        result = new TechnicalStatistics().getBrowseCount();
        System.out.println(result+"");
        result = new AllStatistics().getSalesCount();
        System.out.println(result+"");
    }
}
