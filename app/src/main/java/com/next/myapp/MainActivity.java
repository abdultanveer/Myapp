package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
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
                EditText nameEditText;
                nameEditText = findViewById(R.id.etPersonName);
                String name = nameEditText.getText().toString();
                hIntent.putExtra("studentsname",name);
                startActivity(hIntent);
                break;
            case R.id.buttoncancel:
                EditText pwdEditText;
                pwdEditText = findViewById(R.id.etPassword);
                String pwd = pwdEditText.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+pwd));
                startActivity(dialIntent);
                break;
            case R.id.buttonalarm:
                createAlarm("milk boiled",20,06);
                break;
        }
    }


    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}