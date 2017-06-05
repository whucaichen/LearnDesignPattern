package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 对命令接口的实现
 */
public class Actualize {

    private AddCommandInterface addCommand = null;

    public Actualize() {

    }

    /**
     * 增加命令
     * @param addCommand
     */
    public void addCommandInter(AddCommandInterface addCommand) {
        this.addCommand = addCommand;
    }

    /**
     * 执行命令
     * @param action
     */
    public void addAction(ActionInterface action) {
        action.actionPerformed(this.addCommand);
    }
}
