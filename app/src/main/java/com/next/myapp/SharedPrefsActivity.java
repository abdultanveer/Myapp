package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefsActivity extends AppCompatActivity {

   static String FILE_NAME = "mypreferences";
   static  int MODE = Activity.MODE_PRIVATE;
    EditText phoneEditText;
    CheckBox remPwdCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);
        phoneEditText = findViewById(R.id.etPhoneno);
        remPwdCheckBox = findViewById(R.id.checkBoxRp);
    }

    @Override
    protected void onPause() {
        super.onPause();
        storeData();
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        //open the file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE);
        //read from file
        String phno = preferences.getString("phoneno","");
        Boolean isChkd = preferences.getBoolean("rempwd",false);
        //put the data into edittext and cb
        phoneEditText.setText(phno);
        remPwdCheckBox.setChecked(isChkd);
    }

    private void storeData() {
        //get data from edittext and checkbox
        String phno = phoneEditText.getText().toString();
        Boolean  isChecked = remPwdCheckBox.isChecked();
        //create a file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("phoneno",phno);
        editor.putBoolean("rempwd",isChecked);
        //save the file
        editor.apply();
        Toast.makeText(this, "data stored", Toast.LENGTH_SHORT).show();
    }
}