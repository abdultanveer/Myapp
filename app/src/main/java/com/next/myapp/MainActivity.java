package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
                String name = "shubam";
                hIntent.putExtra("studentsname",name);
                startActivity(hIntent);
                break;
            case R.id.buttoncancel:
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}