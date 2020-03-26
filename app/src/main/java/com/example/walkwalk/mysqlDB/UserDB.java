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
//    public static int userSignUp
}
