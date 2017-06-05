package com.chance;

/**
 * Created by Chance on 16/08/25.
 */
public class Client {

    public static void main(String[] args) {
        Star baoqiang = new Star("王宝强");
        Agent songJJ = new Agent(baoqiang, false);
        songJJ.attendShow();
        songJJ.loveWife();
    }
}
