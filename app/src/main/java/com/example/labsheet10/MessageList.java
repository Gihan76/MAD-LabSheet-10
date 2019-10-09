package com.example.labsheet10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageList extends AppCompatActivity {
    DBHelper courseAppDB;
    TextView welcomeTxt;
    ListView messageList;
    public static ArrayList<Message> messages = new ArrayList<Message>();
    String[] messageLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        messages.clear();

        welcomeTxt = findViewById(R.id.welcomeTxt);
        messageList = findViewById(R.id.messageList);
        welcomeTxt.setText("Welcome " + MainActivity.user.getUserName());
        courseAppDB = new DBHelper(getApplicationContext());

        Cursor cursor = courseAppDB.getAllMessages();
        if(!cursor.moveToFirst()){
            cursor = courseAppDB.getAllMessages();
        }
        do{

            Message message = new Message(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3));
            messages.add(message);
        }while (cursor.moveToNext());
        messageLabels = new String[messages.size()];
        for(int i=0; i<messages.size(); ++i){
            messageLabels[i] = messages.get(i).getSubject();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messageLabels);
        messageList.setAdapter(adapter);

        messageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MessageList.this, MessageView.class);
                intent.putExtra("messageId", String.valueOf(messages.get(i).getMessageID()));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
