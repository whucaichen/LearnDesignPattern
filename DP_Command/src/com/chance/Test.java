package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class Test {

    public static void main(String[] args) {
        OutCommand out = new OutCommand();
        ExcuteCommand.exec(out);

        InCommand in = new InCommand();
        ExcuteCommand.exec(in);
    }
}
