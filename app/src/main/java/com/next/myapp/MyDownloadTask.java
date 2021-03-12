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

    //doInBackground executes in a seperate thread -- background guy
    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG,"url is"+strings[0]);

        for(int i=1; i<21;i++){
            try {
                publishProgress(i*5);
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


       // mProgressBar.setProgress(50);
        return null;
    }

    //guy standing next to the blackboard to update the cricket score
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);
    }
}
