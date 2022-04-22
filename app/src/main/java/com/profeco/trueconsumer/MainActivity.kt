package com.profeco.trueconsumer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.profeco.trueconsumer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_markets, R.id.navigation_products, R.id.navigation_wishlists, R.id.navigation_profile
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.selectedItemId= R.id.navigation_home

        val bundle: Bundle? = intent.extras

        val email: String = bundle?.getString("email")?:""
        val name: String? = bundle?.getString("name")?:""

        val prefs = getSharedPreferences(getString(R.string.shared_prefences), Context.MODE_PRIVATE).edit()

        prefs.putString("email", email)
        prefs.putString("name", name)
        prefs.apply()

    }

    private fun signOut(){
        val prefs = getSharedPreferences(getString(R.string.shared_prefences), Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()

        Firebase.auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}