package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 建立增加命令的接口
 */
public interface AddCommandInterface {

    public void setCommand(CommandInterface comd);
    public CommandInterface getCommand();
}
