package com.example.teacherassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.teacherassistant.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //setupActionBarWithNavController(findNavController(R.id.navigationView))
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.navigationView)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

}