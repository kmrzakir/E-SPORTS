package com.example.esports

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class NavigateActivity : AppCompatActivity() {

    private lateinit var crossIc : ImageView
    private lateinit var goToContactUsFragment : TextView
    private lateinit var goToAboutUsFragment : TextView
    private lateinit var goToTournamentsFragment : TextView
    private lateinit var goToShopFrag : TextView
    private lateinit var linearLayout1 : LinearLayout
    private lateinit var linearLayout2 : LinearLayout
    private lateinit var fragmentContainer : FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.navigate_activity)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        crossIc = findViewById(R.id.cross_ic)
        goToContactUsFragment = findViewById(R.id.go_to_contact_us_frag)
        goToAboutUsFragment = findViewById(R.id.go_to_about_us_frag)
        goToTournamentsFragment = findViewById(R.id.go_to_tournament_frag)
        goToShopFrag = findViewById(R.id.go_to_shop_frag)
        linearLayout1 = findViewById(R.id.linearLayout1)
        linearLayout2 = findViewById(R.id.linearLayout2)
        fragmentContainer = findViewById(R.id.fragment_container)


        //NAVIGATE TO MAIN ACTIVITY
        crossIc.setOnClickListener {
            var intend = Intent(this,MainActivity::class.java)
            startActivity(intend)
            finish()
        }
        //NAVIGATE TO CONTACT US FRAGMENT
        goToContactUsFragment.setOnClickListener {
            loadFragment(ContactUsFragment())
        }

        //NAVIGATE TO ABOUT US FRAGMENT
         goToAboutUsFragment.setOnClickListener {
             loadFragment(AboutUSFragment())
         }
        //NAVIGATE TO ABOUT US FRAGMENT
        goToTournamentsFragment.setOnClickListener {
            loadFragment(TournamentsFragment())
        }

        //NAVIGATE TO OUR SHOP FRAGMENT
        goToShopFrag.setOnClickListener {
            loadFragment(OurShopFragment())
        }

    }

    private fun loadFragment(fragment: Fragment) {
        setVisibilityOfFrameLayout()
      var fragmentManager = supportFragmentManager
      var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

    private fun setVisibilityOfFrameLayout() {
        linearLayout1.visibility = View.GONE
        linearLayout2.visibility = View.GONE
        fragmentContainer.visibility = View.VISIBLE
    }
}