package com.next.myapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
//inputtype = url= string, Integer = progress type = percentage, Bitmap = result type
public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar dtProgressBar;

    public DownloadTask(ProgressBar hProgressBar) {
        dtProgressBar = hProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dtProgressBar.setVisibility(View.VISIBLE);
        dtProgressBar.setProgress(50);

    }


    /**
     * i calling another student to get water
     * @param strings
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG,"downloading image from the url="+ strings[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }
}
