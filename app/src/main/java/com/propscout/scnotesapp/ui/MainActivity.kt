package com.propscout.scnotesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.propscout.scnotesapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get the navigation controller
        val navController: NavController = findNavController(R.id.nav_host_fragment)

        //Init app bar configuration
        mAppBarConfiguration = AppBarConfiguration(setOf(R.id.listFragment))

        //Setup action bar with nav controller
        setupActionBarWithNavController(navController, mAppBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController: NavController = findNavController(R.id.nav_host_fragment)

        return navController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }
}