package com.jkstudy.homework.class_10.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 22:28
 * @description：
 * @modified By：
 * @version: $
 */
public class JdbcTest {

    private static DBUtil dbUtil = new DBUtil();


    public static void main(String[] args) throws Exception {

        //使用Statement

        Connection conn = null;
        Statement st = null;
//        try {
//            conn = dbUtil.getCon();
//            // 3. 创建一个sql语句的发送命令对象
//            String insertSql = "insert into user values(2,'kd',35)";
//            st = conn.createStatement();
//            st.execute(insertSql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                dbUtil.close(st,conn);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        //使用PreparedStatement
        PreparedStatement pstmt = null;
        String updateSql = "update user set name = ? ,age = ? where id = 3";
        try {
            conn = dbUtil.getCon();
            conn.setAutoCommit(false);   //关闭自动提交，此句代码会自动开启事务。默认为true，自动提交。
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, "king");//给第一个坑设值
            pstmt.setString(2, "23");
            pstmt.execute();
            conn.commit(); //提交
        } catch (SQLException e) {
            conn.rollback();//回滚
            e.printStackTrace();
        }finally {
            dbUtil.close(pstmt,conn);
        }

    }

}
