package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 事件激发借口的实现类
 */
public class Action implements ActionInterface {

    public void actionPerformed(AddCommandInterface comInter) {
        comInter.getCommand().excute();
    }
}
