package com.chance;

import java.util.Random;

/**
 * Created by Chance on 2016/7/21.
 */
public class ServerOne implements PlayerCount {

    private ServerFirst mServerFirst;

    public ServerOne() {
        mServerFirst = new ServerFirst();
    }

    @Override
    public String getServerName() {
        return "一服";
    }

    @Override
    public int getPlayerCount() {
        return mServerFirst.getOnlinePlayerCount();
    }

    class ServerFirst{
        private int getOnlinePlayerCount(){
            return new Random().nextInt(10000);
        }
    }
}
