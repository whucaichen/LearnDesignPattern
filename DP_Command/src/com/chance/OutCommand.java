package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 命令执行类2
 */
public class OutCommand implements CommandInterface {

    /**
     * 具体的命令执行内容
     */
    public void excute() {
        System.out.println("out command");
    }
}
