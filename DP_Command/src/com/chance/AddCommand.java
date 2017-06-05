package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 增加命令的实现类
 */
public class AddCommand implements AddCommandInterface {

    private CommandInterface comd = null;

    /**
     * 获得命令
     */
    public CommandInterface getCommand() {

        return this.comd;
    }

    /**
     * 设置命令
     */
    public void setCommand(CommandInterface comd) {
        this.comd = comd;
    }
}
