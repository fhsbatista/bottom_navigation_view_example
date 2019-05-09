package com.fbatista.bottomnavigationfragments

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val dashboardFragment = DashboardFragment()
    val notificationFragment = NotificationFragment()
    val fragmentManager = supportFragmentManager
    var currentFragment: Fragment = homeFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fragmentManager.beginTransaction().hide(currentFragment).show(homeFragment).commit()
                currentFragment = homeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragmentManager.beginTransaction().hide(currentFragment).show(dashboardFragment).commit()
                currentFragment = dashboardFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragmentManager.beginTransaction().hide(currentFragment).show(notificationFragment).commit()
                currentFragment = notificationFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fragmentManager.beginTransaction().add(R.id.main_container, notificationFragment, "3").hide(notificationFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, dashboardFragment, "2").hide(dashboardFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, homeFragment, "1").commit()
    }
}
