package com.chance;

/**
 * Created by Chance on 2016/7/20.
 */
public class QueryUtil {

    public void findUserInfo(String[] usernames, Strategy strategy) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
//                "123456");
//        Statement stat = conn.createStatement();
        String sql = strategy.getSQL(usernames);
        System.out.println(sql);
//        ResultSet resultSet = stat.executeQuery(sql);
//        while (resultSet.next()) {
//            // 处理从数据库读出来的数据
//        }
//        // 后面应将读到的数据组装成对象返回，这里略去。
    }
}
