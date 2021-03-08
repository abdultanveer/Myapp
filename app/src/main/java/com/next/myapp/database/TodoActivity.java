package com.next.myapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.next.myapp.database.NotesContract.NoteEntry;

import com.next.myapp.R;


/**
 * database name = tododb
 * table name = todonotes
 *  id, title, note
 */


public class TodoActivity extends AppCompatActivity {
    EditText titleEditText, noteEditText;
    DbAccessObject dao;
    ListView notesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        titleEditText = findViewById(R.id.etTitle);
        noteEditText = findViewById(R.id.etNote);
        dao = new DbAccessObject(this);
        dao.openDb();
        populateNotesListview();

    }

    private void populateNotesListview() {
        notesListView = findViewById(R.id.notesListview);
        Cursor cursor = dao.getAllRows();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,   //layout of each row
                cursor,                                //data
                    new String[]{NoteEntry.COLUMN_NAME_TITLE,NoteEntry.COLUMN_NAME_NOTE}, // column from which we want to get the data
                   new int[]{android.R.id.text1,android.R.id.text2} );             //textview in which we want to put the data

        notesListView.setAdapter(adapter);
    }


    public void saveDataDb(View view) {
        String title = titleEditText.getText().toString();
        String note = noteEditText.getText().toString();
        //put the data into db
        dao.createRow(title,note);

        titleEditText.setText("");
        noteEditText.setText("");
    }

    public void getDataDb(View view) {
        //get data from db
       String data = dao.readRow();
        //put data into textview
        TextView tvDbdata = findViewById(R.id.tvDbData);
        tvDbdata.setText(data);
    }
}