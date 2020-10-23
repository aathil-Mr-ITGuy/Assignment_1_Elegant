package com.aathil.loginscreen.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import com.aathil.loginscreen.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailError
import kotlinx.android.synthetic.main.activity_sign_up.emailInput
import kotlinx.android.synthetic.main.activity_sign_up.passwordError
import kotlinx.android.synthetic.main.activity_sign_up.passwordInput
import validations.isEmailValid
import validations.isEmpty
import validations.isNamevalid
import validations.isPassWordValid

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

        //validation
        var isEmailValid : Boolean = email.isEmailValid()
        var isEmailEmpty: Boolean = email.isEmpty()
        var isNameValid: Boolean = userName.isNamevalid()
        var isNameEmpty: Boolean = userName.isEmpty()
        var isPassword1Valid: Boolean = password1.isPassWordValid()
        var isPassword2Valid: Boolean = password2.isPassWordValid()
        var isPassword1Empty: Boolean = password1.isEmpty()
        var isPassword2Empty: Boolean = password2.isEmpty()

        //email
        if(isEmailEmpty){
            if(!isEmailValid){
                emailInput.error = "Please Insert Valid email"

            }
//            else{
//                emailInput.error = "Please Insert Valid email"
//            }
        }
        else{
            emailInput.error = "Email Should not be empty"
        }

        //password 1
        if(isPassword1Empty){
            if(!isPassword1Valid){
                passwordInput.error = "Password should be 5-20 length and should start with alphabets"
            }
//            else{
//                passwordInput.error = "Password should be 5-20 length and should start with alphabets"
//            }
        }
        else{
            passwordInput.error = "Password Should not be empty"
        }

        //password 2
        if(!isPassword2Empty){
            password2Input.error = "Re-enter the password please"
        }


        //name
        if(isNameEmpty){
            if(!isNameValid){
                nameInput.error = "Please Insert Valid Name"
            }
//            else{
//                nameInput.error = "Please Insert Valid Name"
//            }
        }
        else{
            nameInput.error = "User Name Should not be empty"
        }

        if(isPassword1Valid && isPassword2Valid){
            if(password1 != password2){
                passwordInput.error = "Passwords are not matching"
                password2Input.error = "Passwords are not matching"
            }
        }




    }




    fun signUp(view: View){
        validation()
    }
}