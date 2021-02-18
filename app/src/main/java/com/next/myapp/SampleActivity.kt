package com.next.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

   var    mconstraintLayout = findViewById<ConstraintLayout>(R.id.mconstraintlyt)

      var  mButton = Button(this);
            mButton.text = "mysample button"

        mconstraintLayout.addView(mButton)
    }
}