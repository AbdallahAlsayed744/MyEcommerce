package com.example.myapplication.presentation.homescreen.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.presentation.account.ui.AccountFragment
import com.example.myapplication.presentation.cart.ui.CartFragment
import com.example.myapplication.presentation.explore.ui.ExploreFragment
import com.example.myapplication.presentation.homepage.ui.HomePageFragment
import com.example.myapplication.presentation.homescreen.adapter.HomeViewPagerAdapter
import com.example.myapplication.presentation.offer.ui.OfferFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding?= null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intitviewpager()
        intitbottomnav()






    }



    private fun intitbottomnav() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home -> binding.viewPager.currentItem = 0

                R.id.search -> binding.viewPager.currentItem = 1

                R.id.cart -> binding.viewPager.currentItem = 2

                R.id.offer -> binding.viewPager.currentItem = 3

                R.id.account -> binding.viewPager.currentItem = 4

            }

          true

        }
    }

    private fun intitviewpager() {
        val fragments = listOf(
            HomePageFragment(),
            ExploreFragment(),
            CartFragment(),
            OfferFragment(),
            AccountFragment()
        )
        binding.viewPager.apply {
            offscreenPageLimit = fragments.size
            adapter = HomeViewPagerAdapter(this@HomeActivity, fragments)
            isUserInputEnabled=true
            registerOnPageChangeCallback(
                object : androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        binding.bottomNavigationView.menu.getItem(position).isChecked = true
                    }
                }
            )

        }


    }

}