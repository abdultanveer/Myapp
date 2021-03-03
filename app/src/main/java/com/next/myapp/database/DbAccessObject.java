package com.next.myapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.next.myapp.database.NotesContract.NoteEntry;

public class DbAccessObject {//DAO
    SQLiteDatabase database;
    DbHelper dbHelper;

    public DbAccessObject(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }

    public  void closeDb(){
        database.close();
    }



    //CRUD

    public void createRow(String title, String note){
        ContentValues values = new ContentValues();
        values.put(NoteEntry.COLUMN_NAME_TITLE,title);
        values.put(NoteEntry.COLUMN_NAME_NOTE,note);

        database.insert(NoteEntry.TABLE_NAME,null,values);
    }


    public String readRow(){
      Cursor cursor = database.query(NoteEntry.TABLE_NAME,null,null,null,null,null,null);
      cursor.moveToFirst();
      int titleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE); //index = 1
        int noteIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_NOTE); //index = 2
       return cursor.getString(titleIndex) + "\n"+cursor.getString(noteIndex);

    }
    public void updateRow(){}
    public void deleteRow(){}
}
