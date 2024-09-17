package com.example.esports

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var goToNavigationActivity : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        goToNavigationActivity = findViewById(R.id.go_to_navigation_activity)
        //NAVIGATE TO NAVIGATE ACTIVITY
        goToNavigationActivity.setOnClickListener {
            var intent  = Intent(this,NavigateActivity::class.java)
            startActivity(intent)
        }

    }
}