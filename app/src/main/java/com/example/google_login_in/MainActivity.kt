package com.example.google_login_in

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.fragment.event
import com.example.fragment.home


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val nightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (nightMode) {
            Configuration.UI_MODE_NIGHT_YES ->                 // Dark theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            Configuration.UI_MODE_NIGHT_NO, Configuration.UI_MODE_NIGHT_UNDEFINED ->                 // Light theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        setContentView(R.layout.activity_main)

        val homebtn = findViewById<View>(R.id.homebtn) as ImageView
        val eventbtn = findViewById<View>(R.id.eventbtn) as ImageView
        val notificationbtn = findViewById<View>(R.id.notificationbtn) as ImageView
        val userbtn = findViewById<View>(R.id.userbtn) as ImageView


        val m = supportFragmentManager
        val t = m.beginTransaction()
        val Home: Fragment = home()
        t.replace(R.id.fragment, Home)
        t.commit()
        homebtn.setImageResource(R.drawable.homecolor)

        homebtn.setOnClickListener {
            val m = supportFragmentManager
            val t = m.beginTransaction()
            val Home: Fragment = home()
            t.replace(R.id.fragment, Home)
            t.commit()
            homebtn.setImageResource(R.drawable.homecolor)
                            eventbtn.setImageResource(R.drawable.event);
            notificationbtn.setImageResource(R.drawable.notification)
            userbtn.setImageResource(R.drawable.user)
        }

        eventbtn.setOnClickListener {
            val m = supportFragmentManager
            val t = m.beginTransaction()
            val community: Fragment = event()
            t.replace(R.id.fragment, community)
            t.commit()
            homebtn.setImageResource(R.drawable.explore)
            eventbtn.setImageResource(R.drawable.eventcolor)
            notificationbtn.setImageResource(R.drawable.notification)
            userbtn.setImageResource(R.drawable.user)
        }
    }
}