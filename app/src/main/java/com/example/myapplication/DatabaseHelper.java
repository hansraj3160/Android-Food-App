package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME="FOOD_APP.DB";
    static final int VERSION=1;

    static final  String DATABASE_TABLE="USERS";
    static final String USER_ID="_ID";
     static final String USER_EMAIL="user_email";
    static final String USER_PASSWORD="user_password";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "CREATE TABLE IF NOT EXISTS "+ DATABASE_TABLE+"("+
                          "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                          USER_EMAIL+" TEXT NOT NULL,"+
                          USER_PASSWORD+" TEXT NOT NULL);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                    db.execSQL("drop TABLE if exists "+DATABASE_TABLE+"");
    }


    public boolean insertData(String user_email,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(USER_EMAIL,user_email);
        contentvalues.put(USER_PASSWORD,name);
        long result=db.insert(DATABASE_TABLE,null,contentvalues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }


    }
    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("Select * from "+DATABASE_TABLE,null);
        return cr;
    }
    public Boolean deleteData(int Id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("Select * From USERS where ID= ?", new String[]{String.valueOf(Id)});
        if (cr.getCount()>0){
            long result=db.delete("USERS","ID=?", new String[]{String.valueOf(Id)});
            if (result==-1)
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }public Boolean upDateData(int Id,String name,String password )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(USER_EMAIL,name);
        contentValues.put(USER_PASSWORD,password);
        Cursor cr=db.rawQuery("Select * From USERS where ID= ?",new String[]{String.valueOf(Id)});
        if (cr.getCount()>0){
            long result=db.update("USERS",contentValues,"ID=?",new String[]{String.valueOf(Id)});
            if (result==-1)
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
