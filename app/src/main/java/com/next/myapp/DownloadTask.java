package com.next.myapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.URL;

//inputtype = url= string, Integer = progress type = percentage, Bitmap = result type
public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar dtProgressBar;
    ImageView dtImageView;

    public DownloadTask(ProgressBar hProgressBar, ImageView imageView) {
        dtProgressBar = hProgressBar;
        dtImageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dtProgressBar.setVisibility(View.VISIBLE);

    }


    /**
     * i calling another student to get water
     * @param strings
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG,"downloading image from the url="+ strings[0]);
        Bitmap image = null;
        //mimic download of 5% every 200 ms
      /*  try {
        for(int i=1; i<21; i++) {
            publishProgress(i * 5); //background student telling the scores to teacher
            Thread.sleep(100);
        }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        try {
            URL url = new URL(strings[0]);
             image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch(IOException e) {
            System.out.println(e);
        }
        return image;
    }

    @Override
    protected void onProgressUpdate(Integer... values) { //teacher telling the students the latest score
        super.onProgressUpdate(values);
        dtProgressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        dtImageView.setImageBitmap(bitmap);
    }
}
