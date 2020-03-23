package com.example.walkwalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener{
    private EditText et_username;
    private EditText et_pwd;
    private String user_name,user_password;
//    private List<user_info> userInfo;
    private static final String TAG="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username=(EditText)findViewById(R.id.et_username);
        et_pwd=(EditText)findViewById(R.id.et_pwd);
        Button loginButton=(Button)findViewById(R.id.button_login);
        Button registerButton=(Button)findViewById(R.id.button_register);
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                Intent intent1=new Intent("android.intent.action.MAIN");
                startActivity(intent1);
            case R.id.button_register:
                Intent intent2=new Intent(login.this,RegisterActivity.class);
                startActivity(intent2);
        }
    }
}
