package com.next.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SimpleActivity : AppCompatActivity() {
     val TAG = "SimpleActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        Log.i(TAG,"oncreate")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onstart")

    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onpause")

    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"onresume")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onstop")
    }
}