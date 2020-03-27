package com.example.walkwalk.mysqlDB;

import java.sql.SQLException;
import java.sql.*;
import android.util.Log;

import com.example.walkwalk.mysqlDB.mysqlDB;

import com.example.walkwalk.mysqlDB.user.User;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import static android.content.ContentValues.TAG;

/*
 *对用户的操作
 */
public class UserDB {
    private static String TAG="UserDB";

    //用户登录
    public static int userSignIn(String name,String pwd){
        mysqlDB.con=mysqlDB.getConnection();
        String sql="select userPwd from user_info where userName=?";
        try{
            mysqlDB.stmt=mysqlDB.con.prepareStatement(sql);
            mysqlDB.stmt.setString(1,name);
            mysqlDB.rs=mysqlDB.stmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        try{
            //若存在用户
            if(mysqlDB.rs.next()){
                //密码是否匹配
                if(mysqlDB.rs.getString(1).equals(pwd)){
                    Log.d(TAG, "密码:"+mysqlDB.rs.getString(1));
                    return 0;
                }
            }else{
                return 2;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }finally {
            mysqlDB.close(mysqlDB.rs,mysqlDB.stmt,mysqlDB.con); //关闭连接
        }
        return 1;
    }
    //用户注册
    public static int userSignUp(User user){
        mysqlDB.con=mysqlDB.getConnection();
        try{
            if(userexist(user.getName()))
                return 1;
            String sql ="insert into user_info(userId,userName,userPwd,sex,age)value(?,?,?,?,?)";
            mysqlDB.stmt = mysqlDB.con.prepareStatement(sql);
            mysqlDB.stmt.setString(1,user.getId());
            mysqlDB.stmt.setString(2,user.getName());
            mysqlDB.stmt.setString(3,user.getPassword());
            mysqlDB.stmt.setString(4,user.getSex());
            mysqlDB.stmt.setString(5,user.getAge());
            mysqlDB.stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }finally {
            mysqlDB.close(mysqlDB.rs,mysqlDB.stmt,mysqlDB.con);
        }
        return 0;
    }
    //用户是否存在
    private static boolean userexist(String userName) throws SQLException {
        mysqlDB.con = mysqlDB.getConnection();
        String sql = "select * from user_info where userName=?";
        try {
            mysqlDB.stmt = mysqlDB.con.prepareStatement(sql);
            mysqlDB.stmt.setString(1, userName);
            mysqlDB.rs = mysqlDB.stmt.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mysqlDB.rs.next())
            return true;
        else
            return false;
    }
    //获取当前用户
    public static User Getuser(String id) {
        mysqlDB.con = mysqlDB.getConnection();
        String sql = "select * from 11user where Id=?";
        try {
            mysqlDB.stmt = mysqlDB.con.prepareStatement(sql);
            mysqlDB.stmt.setString(1, id);
            mysqlDB.rs = mysqlDB.stmt.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        User my = new User ();
        try
        {
            if (mysqlDB.rs.next())
            {
                my.setId(mysqlDB.rs.getString(1));
                my.setPassword(mysqlDB.rs.getString(2));
//                my.setEmail(mysqlDB.rs.getString(8));
                return my;
            }

            else
                return my;
        }
        catch (SQLException e)
        {
            return my;
        }
    }
}
