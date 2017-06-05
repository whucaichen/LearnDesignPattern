package com.chance;

/**
 * Created by Chance on 2016/7/20.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        QueryUtil query = new QueryUtil();
        query.findUserInfo(new String[] { "Tom", "Jim", "Anna" }, new Strategy1());
        query.findUserInfo(new String[] { "Jac", "Joe", "Rose" }, new Strategy2());
    }
}
