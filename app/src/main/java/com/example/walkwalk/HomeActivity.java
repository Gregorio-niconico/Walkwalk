package com.example.walkwalk;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.walkwalk.mysqlDB.user;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private static String TAG="主页面";
    private String user_name,user_pwd,user_sex,user_age;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_sport);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_analyze);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_myinfo);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        user_name=intent.getStringExtra("UserName");
        user_pwd=intent.getStringExtra("UserPwd");
        user_sex=intent.getStringExtra("UserSex");
        user_age=intent.getStringExtra("UserAge");
        Log.d(TAG, "用户："+user_name+" "+user_sex+" ");
        if(user_sex.equals("男")){
            setContentView(R.layout.activity_home_m);
        }else{
            setContentView(R.layout.activity_home_w);
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
