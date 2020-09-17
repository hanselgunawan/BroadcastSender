package com.hanseltritama.broadcastsender

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

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
            null,
            SenderReceiver(),
            null,
            0,
            "Start",
            extras)
    }
}
