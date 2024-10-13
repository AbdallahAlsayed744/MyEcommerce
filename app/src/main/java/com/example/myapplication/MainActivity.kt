package com.example.myapplication

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator

import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private var  _binding: ActivityMainBinding? = null
   private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        InstallsplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }

    private fun InstallsplashScreen() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            // For Android 12 and higher, use the SplashScreen API
            installSplashScreen()
            splashScreen.setOnExitAnimationListener { splashscreenview ->
                val slideup = ObjectAnimator.ofFloat(
                    splashscreenview,
                    View.TRANSLATION_X,
                    -splashscreenview.height.toFloat()
                )
                slideup.interpolator = AnticipateInterpolator()
                slideup.duration = 1000L
                slideup.doOnEnd {
                    splashscreenview.remove()
                }
                slideup.start()
            }

        } else {
            setTheme(R.style.Theme_MyApplication)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

