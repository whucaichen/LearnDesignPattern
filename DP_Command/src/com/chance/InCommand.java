package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 命令执行类1
 */
public class InCommand implements CommandInterface {

    /**
     * 具体的命令执行内容
     */
    public void excute() {
        System.out.println("in command");
    }
}
