package com.hanseltritama.broadcastsender

import android.Manifest
import android.content.*
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun customSendBroadcast(view: View) {
        val intent = Intent("com.hanseltritama.MY_ACTION")
        intent.setPackage("com.hanseltritama.broadcastreceiver")

        val extras = Bundle()
        extras.putString("stringExtra", "Start")

        sendOrderedBroadcast(intent,
            Manifest.permission.WAKE_LOCK,
            SenderReceiver(),
            null,
            0,
            "Start",
            extras)
    }
}
