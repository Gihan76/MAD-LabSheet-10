package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper courseAppDB;

    Button loginBtn, regBtn;
    EditText userName, password;

    public static int currentUserSessionId;
    public static String currentUserSessionType;

    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        regBtn = findViewById(R.id.registerBtn);
        userName = findViewById(R.id.userNameTxt);
        password = findViewById(R.id.passwordTxt);
        courseAppDB = new DBHelper(getApplicationContext());

        loginBtn.setOnClickListener(this);
        regBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:
                boolean logged = courseAppDB.loginCheck(userName.getText().toString(), password.getText().toString());
                if(logged) {
                    if(MainActivity.user.getType().equalsIgnoreCase("student")) {
                        startActivity(new Intent(getApplicationContext(), MessageList.class));
                    }else{
                        startActivity(new Intent(getApplicationContext(), CreateMSG.class));
                    }
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.registerBtn:
                startActivity(new Intent(MainActivity.this, Register.class));
                break;
        }
    }
}
