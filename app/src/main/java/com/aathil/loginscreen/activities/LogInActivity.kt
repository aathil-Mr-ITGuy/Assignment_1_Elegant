package com.aathil.loginscreen.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aathil.loginscreen.R
import common.AsyncTaskExample
import validations.isEmailValid
import validations.isEmpty

import kotlinx.android.synthetic.main.activity_login.*


class LogInActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Page is Loading")
        progressDialog!!.setMessage("Loading...")
        progressDialog!!.setIndeterminate(true);

    }



//    fun showPass(view: View){
//        view as ImageButton
//
//        view.setOnTouchListener(OnTouchListener { v, event ->
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> {
//                    passwordInput.transformationMethod = null
//                    view.setImageResource(R.drawable.eye_checked)
//
//                }
//
//                MotionEvent.ACTION_UP -> {
//                    passwordInput.transformationMethod = PasswordTransformationMethod()
//                    view.setImageResource(R.drawable.eye_unchecked)
//
//                }
//            }
//            true
//        })
//
//
//    }




    private fun validation(){
        var email : String = emailInput.text.toString()
        var password:String = passwordInput.text.toString()

        if(email.isEmpty()){
            if(!(email.isEmailValid())){

                emailInput.error = "Please Insert Valid email"

            }
//            else{
//                emailError.text = "Please Insert Valid email"
//            }
        }
        else{
//            Toast.makeText(applicationContext,"Email Should not be empty", Toast.LENGTH_SHORT).show()
//            emailInput.error = "Email Should not be empty"
            emailInput.error = "Email Should not be empty"
        }

        if(!(password.isEmpty())){
            passwordInput.error = "Password Should not be empty"
        }



    }

    fun login(view: View){
        validation()

    }


    fun forgetPass(view: View){
        startActivity(Intent(this, ForgetPassword::class.java))
    }

    fun signUp(view: View){
        AsyncTaskExample(this).execute()
//        Loading.Companion.MyTask(this).execute()

    }
}
