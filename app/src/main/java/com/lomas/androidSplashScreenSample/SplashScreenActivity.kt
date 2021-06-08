package com.lomas.androidSplashScreenSample

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View.TEXT_ALIGNMENT_CENTER
import androidx.appcompat.app.AppCompatActivity
import com.lomas.androidSplashScreen.AndroidSplashScreen

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config: AndroidSplashScreen = AndroidSplashScreen(this).apply {
            this.withFullScreen()
                .withTargetActivity(MainActivity::class.java)
                .withSplashTimeOut(4000)
                .withBackgroundResource(R.drawable.stars_in_the_sky)
                .withHeaderText("It's Header")
                .withFooterText("It's Footer")
                .withAboveLogoText("It's above logo text")
                .withLogo(R.drawable.logo_white)
                .withBelowLogoText(
                    "It's below logo text\n\"Photo by Juskteez Vu on Unsplash\""
                )
        }

        // customize all TextViews
        config.apply {
            tvBelowLogoText!!.typeface = Typeface.createFromAsset(assets, "lucidaCalligraphy.ttf")
            tvHeader!!.setTextColor(Color.WHITE)
            tvFooter!!.setTextColor(Color.WHITE)
            tvAboveLogoText!!.setTextColor(Color.WHITE)
            tvBelowLogoText!!.setTextColor(Color.WHITE)
            tvBelowLogoText!!.textAlignment = TEXT_ALIGNMENT_CENTER
        }

        // create the view
        setContentView(config.create())
    }
}
