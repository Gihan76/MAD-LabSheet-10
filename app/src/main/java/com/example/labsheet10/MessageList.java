package com.example.labsheet10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageList extends AppCompatActivity {

    TextView welcomeTxt;
    ListView messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        welcomeTxt = findViewById(R.id.welcomeTxt);
        messageList = findViewById(R.id.messageList);
        welcomeTxt.setText("Welcome " + MainActivity.user.getUserName());
    }

    public class MessageListAdapter extends ArrayAdapter<Message> {

        ArrayList<Message> messages;

        public MessageListAdapter(@NonNull Context context, int resource, ArrayList<Message> messages) {
            super(context, resource, messages);
            this.messages = messages;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View view = null;

            return super.getView(position, convertView, parent);
        }
    }
}
