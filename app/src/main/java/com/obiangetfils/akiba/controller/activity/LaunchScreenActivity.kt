package com.obiangetfils.akiba.controller.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.obiangetfils.akiba.R

class LaunchScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        val progressBar: ProgressBar = findViewById(R.id.my_progressBar)

        Thread {
            for (i in 1..100) {
                Thread.sleep(100)
                runOnUiThread {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        progressBar.setProgress(i, true)
                    }
                }
            }
        }.start()

        val homeActivityIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeActivityIntent)
    }
}