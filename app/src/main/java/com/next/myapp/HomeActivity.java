package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add(10,20);
       // throw new RuntimeException("onclick");

        /*String name = getIntent().getExtras().getString("student");

        TextView nameTextView;
        nameTextView = findViewById(R.id.textViewhome);
        nameTextView.setText(name);*/
    }

    private void add(int i, int i1) {
        int a = 15;
        throw new RuntimeException("Test Crash"); // Force a crash

    }
}