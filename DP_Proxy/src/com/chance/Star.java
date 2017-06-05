package com.chance;

/**
 * Created by Chance on 16/08/25.
 */
public class Star implements IStar {

    private String mName;

    public Star(String mName) {
        this.mName = mName;
    }

    @Override
    public void attendShow() {
        System.out.println(this.mName+ "参加演出\n");
    }

    @Override
    public void loveWife() {
        System.out.println(this.mName+ "照顾妻子\n");
    }
}
