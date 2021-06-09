package com.lomas.androidSplashScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

class AndroidSplashScreen(var mActivity: Activity) {

    private var ivLogo: ImageView? = null
    var tvHeader: TextView? = null
    var tvFooter: TextView? = null
    var tvAboveLogoText: TextView? = null
    var tvBelowLogoText: TextView? = null
    private var rlSplashWrapper: RelativeLayout
    private var bundle: Bundle? = null
    private val mView: View
    private var targetActivity: Class<*>? = null

    /** Duration of splash screen - by default 2 seconds */
    private var SPLASH_TIME_OUT = 2000

    init {
        val mInflater: LayoutInflater = LayoutInflater.from(mActivity)
        mView = mInflater.inflate(R.layout.splash_screen, null)
        rlSplashWrapper = mView.findViewById<View>(R.id.rlSplashWrapper) as RelativeLayout
    }

    /** This functions hides status bar only.
     * To hide action bar in specific activity, use theme with no action bar property
     * in activity declaration in manifest file. */
    fun withFullScreen(): AndroidSplashScreen {
        mActivity.apply {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }.also { return this }
    }

    /** Specifies the activity to open after splash screen */
    fun withTargetActivity(tAct: Class<*>?): AndroidSplashScreen {
        targetActivity = tAct
        return this
    }

    /** Sets the duration of splash screen - by default 2 seconds
     * @param timeout duration in milliseconds */
    fun withSplashTimeOut(timeout: Int): AndroidSplashScreen {
        SPLASH_TIME_OUT = timeout
        return this
    }

    /** Provide android bundle to target activity */
    fun withBundleExtras(bundle: Bundle?): AndroidSplashScreen {
        this.bundle = bundle
        return this
    }

    /**
     * Sets the background color for this view.
     * @param splashBackgroundColor the color of the background
     */
    fun withBackgroundColor(@ColorInt splashBackgroundColor: Int): AndroidSplashScreen {
        rlSplashWrapper.setBackgroundColor(splashBackgroundColor)
        return this
    }

    /**
     * Set the background to a given resource. The resource should refer to
     * a Drawable object or 0 to remove the background.
     * @param splashBackgroundResource The identifier of the resource. */
    fun withBackgroundResource(splashBackgroundResource: Int): AndroidSplashScreen {
        rlSplashWrapper.setBackgroundResource(splashBackgroundResource)
        return this
    }

    /**
     * Sets a drawable as the logo.
     * @param logo the resource identifier of the drawable */
    fun withLogo(@DrawableRes logo: Int): AndroidSplashScreen {
        ivLogo = mView.findViewById<View>(R.id.ivLogo) as ImageView
        ivLogo!!.setImageResource(logo)
        return this
    }

    /** @param text text to be displayed in the header */
    fun withHeaderText(text: String?): AndroidSplashScreen {
        tvHeader = mView.findViewById<View>(R.id.tvHeader) as TextView
        tvHeader!!.text = text
        return this
    }

    /** @param text text to be displayed in the footer */
    fun withFooterText(text: String?): AndroidSplashScreen {
        tvFooter = mView.findViewById<View>(R.id.tvFooter) as TextView
        tvFooter!!.text = text
        return this
    }

    /** @param text text to be displayed just above the logo */
    fun withAboveLogoText(text: String?): AndroidSplashScreen {
        tvAboveLogoText = mView.findViewById<View>(R.id.tvAboveLogoText) as TextView
        tvAboveLogoText!!.text = text
        return this
    }

    /** @param text text to be displayed just below the logo */
    fun withBelowLogoText(text: String?): AndroidSplashScreen {
        tvBelowLogoText = mView.findViewById<View>(R.id.tvBelowLogoText) as TextView
        tvBelowLogoText!!.text = text
        return this
    }

    /** Creates the specified splash screen */
    fun create(): View {
        setUpHandler()
        return mView
    }

    private fun setUpHandler() {
        if (targetActivity != null) {
            Handler(Looper.myLooper()!!).postDelayed({
                val intent = Intent(mActivity, targetActivity)
                if (bundle != null) {
                    intent.putExtras(bundle!!)
                }
                mActivity.startActivity(intent)
                // close splash
                mActivity.finish()
            }, SPLASH_TIME_OUT.toLong())
        }
    }
}
