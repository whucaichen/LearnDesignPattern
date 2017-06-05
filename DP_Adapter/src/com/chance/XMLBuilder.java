package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class XMLBuilder {

    public static String buildXML(PlayerCount player) {
        StringBuilder builder = new StringBuilder();
        builder.append("<root>");
        builder.append("<server>").append(player.getServerName()).append("</server>");
        builder.append("<player_count>").append(player.getPlayerCount()).append("</player_count>");
        builder.append("</root>");
        return builder.toString();
    }
}
