package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button registerBtn;
    EditText userName, password;
    CheckBox teacherChk, studentChk;
    String checkedText = "";

    DBHelper courseAppDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.registerBtn);
        userName = findViewById(R.id.userNameTxt);
        password = findViewById(R.id.passwordTxt);
        teacherChk = findViewById(R.id.teacherCheckBtn);
        studentChk = findViewById(R.id.studentCheckBtn);

        courseAppDB =  new DBHelper(getApplicationContext());

        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBtn:
                if(userName.getText().equals("") ){

                }else if(password.getText().equals("")){

                }else if(userName.getText().equals("") && password.getText().equals("")) {

                }else {
                    if (!teacherChk.isChecked() && !studentChk.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Please select the user type", Toast.LENGTH_SHORT).show();
                        studentChk.setFocusable(true);
                        teacherChk.setFocusable(true);
                    } else {
                        if (teacherChk.isChecked() && studentChk.isChecked())
                            checkedText = "both";
                        else if (teacherChk.isChecked())
                            checkedText = teacherChk.getText().toString();
                        else if (studentChk.isChecked())
                            checkedText = studentChk.getText().toString();

                        boolean inserted = courseAppDB.insertAUser(userName.getText().toString(), password.getText().toString(), checkedText);
                        if(inserted){
                            Toast.makeText(getApplicationContext(), "User Registered Successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, MainActivity.class));
                        }
                    }
                }
                break;
        }
    }
}
