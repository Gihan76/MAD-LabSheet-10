package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageView extends AppCompatActivity {

    DBHelper courseAppDb;
    int messageID;
    TextView messageSubject;
    EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_view);
        messageSubject = findViewById(R.id.subjectTxt);
        message = findViewById(R.id.messageTxt);

        Intent intent = getIntent();
        messageID = Integer.parseInt(intent.getStringExtra("messageId"));
        courseAppDb = new DBHelper(getApplicationContext());
        Cursor cursor = courseAppDb.getTheMessage(messageID);
        if(cursor.moveToFirst()) {
            messageSubject.setText(cursor.getString(2));
            message.setText(cursor.getString(3));

        }else{
            Toast.makeText(getApplicationContext(), "Empty Inbox", Toast.LENGTH_SHORT).show();
        }



    }
}

