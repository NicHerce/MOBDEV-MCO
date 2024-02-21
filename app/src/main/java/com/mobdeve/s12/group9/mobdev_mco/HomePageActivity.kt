package com.mobdeve.s12.group9.mobdev_mco

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.s12.group9.mobdev_mco.ui.main.SectionsPagerAdapter
import com.mobdeve.s12.group9.mobdev_mco.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewBinding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(homeViewBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = homeViewBinding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = homeViewBinding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = homeViewBinding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}