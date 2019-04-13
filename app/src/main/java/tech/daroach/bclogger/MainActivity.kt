package tech.daroach.bclogger

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

import tech.daroach.bclogger.ui.Dashboard

class MainActivity : AppCompatActivity(), Dashboard.OnFragmentInteractionListener {

    companion object {
        const val TAG = "androidx_is_nice"
    }

    override fun onFragmentInteraction(uri: Uri) {
        Log.d(TAG, "OnFragmentInteraction: " + uri.toString()) //TODO: figure out what this is needed for. added for navigation x
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        val navController = host.navController

        setupBottomNavMenu(navController)
    }
        private fun setupBottomNavMenu(navController: NavController) {
            NavigationUI.setupWithNavController(findViewById<BottomNavigationView>(R.id.bottom_nav), navController)
        }
}
