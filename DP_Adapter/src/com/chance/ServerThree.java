package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class ServerThree implements PlayerCount {

    @Override
    public String getServerName() {
        return "三服";
    }

    @Override
    public int getPlayerCount() {
        return Utility.getOnlinePlayerCount(3);
    }
}
