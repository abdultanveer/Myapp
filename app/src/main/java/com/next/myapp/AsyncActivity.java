package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar hProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        hProgressBar = findViewById(R.id.progressBar);
    }

    public void download(View view) {
        DownloadTask downloadTask = new DownloadTask(hProgressBar);
        downloadTask.execute("http://urlforImagetobedownloaded.com");
    }
}