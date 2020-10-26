package com.aathil.loginscreen.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import com.aathil.loginscreen.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailError
import kotlinx.android.synthetic.main.activity_sign_up.emailInput
import kotlinx.android.synthetic.main.activity_sign_up.passwordError
import kotlinx.android.synthetic.main.activity_sign_up.passwordInput
import validations.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



    }


    fun goBack(view: View){
        intent = Intent(this,LogInActivity::class.java)
        startActivity(intent)
    }

//    fun showPass(view: View){
//        view as ImageButton
//
//
//        view.setOnTouchListener(View.OnTouchListener { v, event ->
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> {
//
//                    passwordInput.transformationMethod = null
//                    password2Input.transformationMethod = null
//                    view.setImageResource(R.drawable.eye_checked)
//
//                }
//
//                MotionEvent.ACTION_UP -> {
//                    passwordInput.transformationMethod = PasswordTransformationMethod()
//                    password2Input.transformationMethod = PasswordTransformationMethod()
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

        var userName: String = nameInput.text.toString()
        var email: String = emailInput.text.toString()
        var password1 : String = passwordInput.text.toString()
        var password2 : String = password2Input.text.toString()
        var passwordBool = false

        var (emailError, emailBool) = validEmail(email)
        Log.d("email", emailBool.toString())
        if(emailError != ""){

            emailInput.error  = emailError
        }

        var (userNameError, userNameBool) = validName(userName)
        Log.d("user name", userNameBool.toString())
        if(userNameError != ""){

            nameInput.error  = userNameError
        }

        var (password1Error, password1NameBool) = validPass(password1)
        Log.d("pass1", password1NameBool.toString())
        if(password1Error != ""){

            passwordInput.error  = password1Error
        }

        var (password2Error, password2NameBool) = validPass2(password2)
        Log.d("pass2", password2NameBool.toString())
        if(password2Error != ""){

            password2Input.error  = password2Error
        }
        if(password1NameBool && password2NameBool){
            if(password1 != password2){
                passwordInput.error = "Passwords are not matching"
                password2Input.error = "Passwords are not matching"

            }
            else{
                passwordBool = true
            }
        }


        if(emailBool && userNameBool && passwordBool){

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }



    }




    fun signUp(view: View){
        validation()

    }
}