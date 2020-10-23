package com.aathil.loginscreen.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.aathil.loginscreen.R
import com.google.android.material.snackbar.Snackbar
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_login.*
import validations.isEmailValid
import validations.isEmpty

class ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        title = "Forget Password"
    }


    fun goBack(view: View){
        intent = Intent(this,LogInActivity::class.java)
        startActivity(intent)
    }


    private fun validateEmail(): Boolean {

        var email : String = emailInput.text.toString()
        var bool: Boolean = false

        if(email.isEmpty()){
            if(!(email.isEmailValid())){
                emailInput.error = "Please Insert Valid email"

            }
            else{
                bool = true

            }
        }
        else{
            emailInput.error = "Email Should not be empty"
        }
        return bool

    }

    fun reset(view: View){
        validateEmail()
        if(validateEmail()){
            Snackbar.make(
                    findViewById(R.id.constraintLayout),
                    R.string.email_sent,
                    Snackbar.LENGTH_SHORT
            ).show()


        }
    }
}