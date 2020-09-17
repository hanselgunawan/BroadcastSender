package com.hanseltritama.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
        val intent: Intent = Intent("com.hanseltritama.MY_ACTION")
        intent.putExtra("com.hanseltritama.MY_TEXT", "Broadcast Received")
        sendBroadcast(intent)
    }

    private val broadcastReceiver: BroadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val receivedText: String? = intent?.getStringExtra("com.hanseltritama.MY_TEXT")
            text_view.text = receivedText
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter: IntentFilter = IntentFilter("com.hanseltritama.MY_ACTION")
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}
