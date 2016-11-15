package com.hukang.mydemo.ui;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hukang.mydemo.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.til_username);
        textInputLayout.setHint("username");
        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.til_username2);
        textInputLayout2.setHint("username2");
    }
}
