package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateMSG extends AppCompatActivity implements View.OnClickListener {

    TextView welcomeTxt;
    EditText subjectTxt, messageTxt;
    Button sendBtn;
    DBHelper courseAppDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_msg);

        welcomeTxt = findViewById(R.id.welcomeTxt);
        sendBtn = findViewById(R.id.sendBtn);
        subjectTxt = findViewById(R.id.subjectTxt);
        messageTxt = findViewById(R.id.messageTxt);
        courseAppDB = new DBHelper(getApplicationContext());
        welcomeTxt.setText("Welcome " + MainActivity.user.getUserName());
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendBtn:
                boolean sent = courseAppDB.insertAMessage(MainActivity.user.getUserID(), subjectTxt.getText().toString(), messageTxt.getText().toString());
                if(sent){
                    Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CreateMSG.this, MessageList.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Something went wrong try again", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

