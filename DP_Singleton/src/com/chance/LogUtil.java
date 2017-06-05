package com.chance;

/**
 * Created by Chance on 2016/7/21.
 */
public class LogUtil {

    private static LogUtil sLogUtil;

    public final int DEGUB = 0;

    public final int INFO = 1;

    public final int ERROR = 2;

    public final int NOTHING = 3;

    public int level = DEGUB;   //可做自定义的全局限制

    private LogUtil() {
    }

    public static LogUtil getInstance() {
        if (sLogUtil == null) {
            synchronized (LogUtil.class) {
                if (sLogUtil == null) {
                    sLogUtil = new LogUtil();
                }
            }
        }
        return sLogUtil;
    }

    public void debug(String msg) {
        if (DEGUB >= level) {
            System.out.println(msg);
        }
    }

    public void info(String msg) {
        if (INFO >= level) {
            System.out.println(msg);
        }
    }

    public void error(String msg) {
        if (ERROR >= level) {
            System.out.println(msg);
        }
    }
}
