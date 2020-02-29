package com.xing.jetpack.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xing.jetpack.R

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnv_bottom_tab)
        val navController = Navigation.findNavController(this,R.id.fragment_bottom_tab)
        val configuration = AppBarConfiguration.Builder(bottomNavigationView.menu).build()
//        NavigationUI.setupActionBarWithNavController(this, navController, configuration)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,R.id.nav_bottom_tab).navigateUp()
    }
}
