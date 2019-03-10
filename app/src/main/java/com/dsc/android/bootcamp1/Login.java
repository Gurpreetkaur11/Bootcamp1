package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
        private EditText etname,etpassword;
        Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComp();


    }
    public void initComp(){
        etname = findViewById(R.id.etloginId);
        etpassword = findViewById(R.id.etPasswordId);
        login = findViewById(R.id.btnloginId);

    }
}
