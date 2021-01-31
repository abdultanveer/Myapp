package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    /**
     * memory is getting allocated in the ram for this activity so it is getting created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am in oncreate");

    }

    /**
     * the activity is starting i.e v can see and tap button on the screen
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"i am in onstart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"i am in onresume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"i am in onpause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"i am in onstop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"i am in ondestroy");

    }

    public void mobiClickHandler(View view) {
        Log.i(TAG,"i am in clickhandler");

        switch (view.getId()){
            case R.id.buttonlogin:
                Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);//breakpoint -- please stop the execution when you reach this point
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