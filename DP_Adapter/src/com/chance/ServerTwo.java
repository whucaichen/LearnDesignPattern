package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class ServerTwo implements PlayerCount {

    @Override
    public String getServerName() {
        return "二服";
    }

    @Override
    public int getPlayerCount() {
        return Utility.getOnlinePlayerCount(2);
    }
}
