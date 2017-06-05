package com.chance;

/**
 * Created by Chance on 16/08/25.
 */
public class Agent implements IStar {

    IStar mIStar;
    boolean mIsHappy;

    public Agent(IStar mIStar) {
        this.mIStar = mIStar;
    }

    /**
     * 代理可以在一定情况下拦截、修改被代理对象的行为
     * @param mIStar
     * @param mIsHappy
     */
    public Agent(IStar mIStar, boolean mIsHappy) {
        this.mIStar = mIStar;
        this.mIsHappy = mIsHappy;
    }

    @Override
    public void attendShow() {
        mIStar.attendShow();
    }

    @Override
    public void loveWife() {
        if(mIsHappy){
            mIStar.loveWife();
        }else {
            //当经纪人心情不好时就会干坏事
            System.out.println("经纪人照顾妻子");
        }
    }
}
