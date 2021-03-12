package com.next.myapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * this class downloads the latest cricket score
 */
//params -- input type, progress type and result type
public class MyDownloadTask  extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = MyDownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;

    public MyDownloadTask(ProgressBar downloadProgressBar) {
        mProgressBar = downloadProgressBar;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    //doInBackground executes in a seperate thread
    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG,"url is"+strings[0]);
        mProgressBar.setProgress(50);
        return null;
    }
}
