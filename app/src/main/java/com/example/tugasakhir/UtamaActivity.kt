package com.example.tugasakhir

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class UtamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        if (Build.VERSION.SDK_INT >= 21) {
            MainActivity.setWindowFlag(
                this,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                false
            )
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val activityWindow = activity.window
            val layoutParams = activityWindow.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            activityWindow.attributes = layoutParams
        }
    }
}