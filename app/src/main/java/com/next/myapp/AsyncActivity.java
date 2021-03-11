package com.next.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar hProgressBar;
    ImageView imageView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        hProgressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView2);
        url = "https://www.wishgoodmorning.org/wp-content/uploads/2016/03/Awesome-Morning-Flowers-wg01004-600x449.jpg";
    }


    public void download(View view) {
        DownloadTask downloadTask = new DownloadTask(hProgressBar,imageView);
        downloadTask.execute(url);
    }
}