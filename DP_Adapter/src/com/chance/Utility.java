package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class Utility {

    public static int getOnlinePlayerCount(int server){
        int count;
        switch (server){
            case 2:
                count = server*1000;
                break;
            case 3:
                count = server*100;
                break;
            default:
                count = -1;
        }
        return count;
    }
}
