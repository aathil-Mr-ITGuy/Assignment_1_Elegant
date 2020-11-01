package com.aathil.loginscreen.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.aathil.loginscreen.R
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null

//    //define shared preference file name
//    private val sharedFile = "sharedpreference"

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


//        var currentUserId = mAuth!!.currentUser?.uid
//
//        //define shared preference
//
//        val sharedPreference: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
////        val editor: SharedPreferences.Editor = sharedPreference.edit()
//
//
//            //put into shared preference
//        editor.putString("userId", currentUserId)
//
//            //apply the changes
//            editor.apply()
//
//            //commit the changes
//            editor.commit()
//




        mAuth = FirebaseAuth.getInstance()


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_logout -> {
                    val logoutAlert = AlertDialog.Builder(this)
                    logoutAlert.setTitle("Alert")
                    logoutAlert.setMessage("Are sure you want to logout?")

                    logoutAlert.setPositiveButton("YES"){

                        logoutAlert, id ->
                        mAuth!!.signOut()
                        mAuth!!.currentUser?.uid?.let { it1 -> Log.d("Current User", it1) }
                        startActivity(Intent(this, LogInActivity:: class.java))
                    }
                    logoutAlert.setNegativeButton("NO"){
                        logoutAlert, id ->
                        logoutAlert.dismiss()


                    }
                    logoutAlert.show()
                }

        }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}