package com.example.walkwalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText  edit_username;
    private EditText  edit_pwd;
    private EditText  edit_checkpwd;
    private String username,pwd,checkpwd;
    private static final String TAG="Register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button confirmButton=(Button)findViewById(R.id.button_confirm);
        Button cancelButton=(Button)findViewById(R.id.button_cancel);
    }
    @Override
    public void onClick(View v) {

    }
}
