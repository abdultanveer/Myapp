package com.next.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener {
    public static String TAG = MainActivity.class.getSimpleName();
    EditText etPersonname;
    EditText etPassword;
    Spinner spinner;
    String[] studentsPlug = {"dhruvil","sai", "shubam","farhan"};

    /**
     * memory is getting allocated in the ram for this activity so it is getting created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //layout inflater
       // Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am in oncreate");// i = info
        etPersonname = findViewById(R.id.etPersonName);
        etPersonname.setOnFocusChangeListener(this);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ListView studentsListViewSocket = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,studentsPlug);
        studentsListViewSocket.setAdapter(adapter);
/*

        Button mButton;
        mButton = new Button(this);
        mButton.setText("login");*/
    }

    /**
     * the activity is starting i.e v can see and tap button on the screen
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"i am in onstart"); //v = verbose

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"i am in onresume");//w = warning

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"i am in onpause"); //e = error

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"i am in onstop"); // d= debug

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

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this, "is focussed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String itemSelected = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "back button was pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        //inflating a baloon --- main_menu.xml
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
           case  R.id.settings_menu:
               Toast.makeText(this, "settings was selected", Toast.LENGTH_SHORT).show();
             break;
             case R.id.logout:
                 Toast.makeText(this, "logout was selected", Toast.LENGTH_SHORT).show();

                 break;

         }
        return true;
    }
}