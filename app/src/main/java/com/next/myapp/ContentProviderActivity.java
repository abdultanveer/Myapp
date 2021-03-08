package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        ListView listView = findViewById(R.id.cpListview);
        Uri uriSms = Uri.parse("content://sms/inbox"); //http://smsdb/inboxtable
        Cursor dataCursor =  getContentResolver()
                .query(uriSms,null,null,null,null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                dataCursor,
                new String[]{"body"}, new int[] {android.R.id.text1});
        listView.setAdapter(adapter);
    }
}