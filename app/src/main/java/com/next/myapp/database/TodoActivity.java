package com.next.myapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.next.myapp.R;


/**
 * database name = tododb
 * table name = todonotes
 *  id, title, note
 */


public class TodoActivity extends AppCompatActivity {
    EditText titleEditText, noteEditText;
    DbAccessObject dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        titleEditText = findViewById(R.id.etTitle);
        noteEditText = findViewById(R.id.etNote);
        dao = new DbAccessObject(this);
        dao.openDb();
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