package com.example.labsheet10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    Context context;

    public static final String DATABASENAME = "courseApp";

    public static final String TABLE_USERTABLE = "UserTable";
    public static final String USERID = "UserID";
    public static final String NAME = "Name";
    public static final String PASSWORD = "Password";
    public static final String TYPE = "Type";

    public static final String TABLE_MESSAGETABLE = "Message_Table";
    public static final String MESSAGEID = "MessageID";
    public static final String USER = "UserID";
    public static final String SUBJECT = "Subject";
    public static final String MESSAGE = "Message";



    public DBHelper(Context context) {
        super(context, DATABASENAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USERTABLE + "(UserID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Password TEXT, TYPE TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_MESSAGETABLE + "(MessageID INTEGER PRIMARY KEY AUTOINCREMENT, UserID INTEGER, Subject TEXT, Message TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERTABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGETABLE);
    }

    public boolean insertAUser(String userName, String password, String type){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userName);
        contentValues.put(PASSWORD, password);
        contentValues.put(TYPE, type);

        long result = db.insert(TABLE_USERTABLE, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertAMessage(int user, String subject, String message){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER, user);
        contentValues.put(SUBJECT, subject);
        contentValues.put(MESSAGE, message);

        long result = db.insert(TABLE_MESSAGETABLE, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }

    public boolean loginCheck(String userName, String password){

        SQLiteDatabase db = getWritableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_USERTABLE + " WHERE Name = '" + userName + "' and Password = '" + password + "'", null);
        while (res.moveToNext()){
            User user = new User(res.getInt(0), res.getString(1), res.getString(2), res.getString(3));
            MainActivity.user = user;
            return true;
        }
        return false;
    }
}
