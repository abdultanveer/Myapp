package com.next.myapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.next.myapp.database.NotesContract.NoteEntry;

import androidx.annotation.Nullable;

/**
 * this class will help me create a db
 */


public class DbHelper extends SQLiteOpenHelper {
//create table todonotes(_id INTEGER PRIMARY KEY, title TEXT, note TEXT )
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteEntry.TABLE_NAME + " (" +
                    NoteEntry._ID + " INTEGER PRIMARY KEY," +
                    NoteEntry.COLUMN_NAME_TITLE + " TEXT," +
                    NoteEntry.COLUMN_NAME_NOTE + " TEXT)";

    public DbHelper(@Nullable Context context) { //as i invoke this constructor a db will be created
        super(context, NoteEntry.DB_NAME, null, 1);
    }

    //oncreate gets called when the db is created for the first time
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { // i'll create a table in the db created above
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    //when user upgrades the version of the app
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
