package com.lawlett.zingua

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lawlett.zingua.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        val navView: BottomNavigationView = binding.navView
        navView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val actionBar = supportActionBar
            when (destination.id) {
                R.id.navigation_grammar, R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_dashboard, R.id.resultFragment -> {
                    actionBar?.setDisplayHomeAsUpEnabled(false) // Убрать стрелку "Назад"
                }
                else -> {
                    actionBar?.setDisplayHomeAsUpEnabled(false) // Показать стрелку "Назад" на других экранах
                }
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            navView.visibility = when (destination.id) {
                R.id.quizFragment, R.id.grammarDetailFragment, R.id.resultFragment-> View.GONE
                else -> View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {

        val currentFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main)
            ?.childFragmentManager
            ?.primaryNavigationFragment


        if (currentFragment is ResultFragment) {
            // Игнорируем нажатие кнопки "Назад"
            return
        }

        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}