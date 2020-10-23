package com.aathil.loginscreen.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aathil.loginscreen.R

class SplashActivity : AppCompatActivity() {

    private val timeOut: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)

        startActivity(Intent(this, LogInActivity::class.java))

        //close
        finish()
//        setContentView(R.layout.activity_splash)
//
//        Handler().postDelayed({
//            //start the main activity
//            startActivity(Intent(this, LoginActivity::class.java))
//
//            //close
//            finish()
//
//        }, timeOut)
    }
}