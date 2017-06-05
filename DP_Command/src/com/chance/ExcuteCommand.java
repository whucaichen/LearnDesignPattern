package com.chance;

/**
 * Created by Chance on 2016/7/21.
 * 封装接口的实现
 */
public class ExcuteCommand {

    public static void exec(CommandInterface com) {
        Actualize actu = new Actualize();

        AddCommand outAdd = new AddCommand();

        outAdd.setCommand(com);

        actu.addCommandInter(outAdd);

        actu.addAction(new Action());
    }
}
