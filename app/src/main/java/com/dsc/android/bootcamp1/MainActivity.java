package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private EditText etName,etEmail,etPassword,etConfirmPassword;
        private Button btnRegister;
        private String name,email,password,confirmpassword;
        private TinyDB db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(this);
       initView();
        btnRegister.setOnClickListener(this);

    }
    //Initializing the UI components
    private void initView(){
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btLogin);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btLogin: getInfo();
                                register();
                                    break;
        }
    }
    private void getInfo(){
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString();
        confirmpassword = etConfirmPassword.getText().toString();
    }
    private void register(){
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()){
            Toast.makeText(this,"One or More fields is Empty",Toast.LENGTH_LONG).show();

        }
        else {
            if(password.equals(confirmpassword)){
                db.putString("Name","name");
                db.putString("Email","email");
                db.putString("Password","password");
                Toast.makeText(this,"User Registered",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this,"Password did not match",Toast.LENGTH_LONG).show();
            }
        }
    }
}
