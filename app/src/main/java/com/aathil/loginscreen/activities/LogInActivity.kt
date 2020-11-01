package com.aathil.loginscreen.activities

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aathil.loginscreen.R
import com.google.firebase.auth.FirebaseAuth
import common.AsyncTaskExample

import kotlinx.android.synthetic.main.activity_login.emailInput
import kotlinx.android.synthetic.main.activity_login.passwordInput
import validations.validEmail
import validations.validPass2


class LogInActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    var progressDialog: ProgressDialog? = null
    var currentUserId : String? = null

    //define shared preference file name
    val sharedFile = "sharedpreference"

    var sharedPreference: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Page is Loading")
        progressDialog!!.setMessage("Loading...")
        progressDialog!!.isIndeterminate = true

        mAuth = FirebaseAuth.getInstance()
        currentUserId = mAuth!!.currentUser?.uid

        sharedPreference = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

//        getFromShared()

    }

    private fun insertToShared(email: String){
        val editor: SharedPreferences.Editor = sharedPreference!!.edit()

        //put into shared preference

        editor.putString("email", email)


        //apply the changes
        editor.apply()

        //commit the changes
        editor.commit()
        val sharedEmail = sharedPreference!!.getString("email", "")




    }


//    public fun getFromShared(): String? {
//        val sharedEmail = sharedPreference!!.getString("email", "")
//        return sharedEmail
//
//
////        if(sharedEmail != ""){
////            startActivity(Intent(this, HomeActivity::class.java))
////
////        }
//    }



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

        var (emailError, emailBool) = validEmail(email)
        var (passwordError, passwordBool) = validPass2(password)

        if(emailError != ""){

            emailInput.error  = emailError
        }

        if(passwordError != ""){

            passwordInput.error  = "Password Should not be empty"
        }

        if(emailBool && passwordBool){

            try {

                    mAuth!!.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if(task.isSuccessful){
                                    insertToShared(email)
                                    Toast.makeText(applicationContext, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, HomeActivity::class.java)
                                    startActivity(intent)
                                }
                                else{
                                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                                    val ex: Exception? = null
                                    Log.d("Error", ex!!.toString())
                                }

                            }


            }catch (ex: Exception){
                Log.d("Login Error", ex.toString())
            }


        }



    }

    fun login(view: View){
        validation()

    }


    fun forgetPass(view: View){
        startActivity(Intent(this, ForgetPassword::class.java))
    }

    fun signUp(view: View){

        try {
            AsyncTaskExample(this).execute()
        }catch (ex: Exception){
            Log.d("Success", ex.toString())
        }


    }
}
