package com.purnendu.navigationcomponent.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.purnendu.navigationcomponent.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var bnv:BottomNavigationView
    private lateinit var snv: NavigationView
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.toolbar)
        bnv=findViewById(R.id.bnv)
        snv=findViewById(R.id.snv)
        drawerLayout=findViewById(R.id.drawerLayout)


        setSupportActionBar(toolbar)



        val navHostFragment=supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        navController=navHostFragment.navController
        appBarConfiguration= AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.settingFragment,
            R.id.notificationFragment
        ),drawerLayout)
        toolbar.setupWithNavController(navController,appBarConfiguration)
      //  setupActionBarWithNavController(navController,appBarConfiguration)
        bnv.setupWithNavController(navController)
        snv.setupWithNavController(navController)
    }


//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId)
        {
            R.id.logOut ->{
                val preference = this.getSharedPreferences("loggedInStatus", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = preference.edit()
                editor.putBoolean("status",false)
                if(editor.commit())
                {
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                return true
            }
            else->{ return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)}
        }
    }


}