package com.chance.aircon;

/**
 * Created by Chance on 16/08/19.
 */
public class Aircon {
    /**
     * 状态模式允许对象在内部状态改变时改变它的行为，对象看起来好像修改了他的类。适用场景：
     * 一个对象的行为取决于他的状态，并且它必须在运行时根据状态改变它的行为；
     * 一个操作中含有庞大的多分支结构，并且这些分支决定于对象的状态。
     */

    AirState state = AirState.OFF;//private改默认，删除getState()。

    //两个Action
    public void power() {//按power键
        state.power(this);
    }

    public void cool() {//按制冷键
        state.cool(this);
    }

    public static void main(String[] args) {
        Aircon ac = new Aircon();
        System.out.println("Current AirState:" + ac.state.name());
        ac.cool();
        ac.power();
        ac.cool();
        ac.cool();
        ac.power();
        ac.power();
        ac.power();
    }
}
