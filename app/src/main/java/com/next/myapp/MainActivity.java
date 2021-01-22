package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mobiClickHandler(View view) {

        switch (view.getId()){
            case R.id.buttonlogin:
                Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();

                break;
            case R.id.buttoncancel:
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}