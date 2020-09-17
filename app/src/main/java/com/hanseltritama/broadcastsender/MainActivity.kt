package com.hanseltritama.broadcastsender

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
        // 1st approach
//        val cn = ComponentName("com.hanseltritama.broadcastreceiver",
//            "com.hanseltritama.broadcastreceiver.MyBroadcastReceiver")
//        intent.component = cn

        // 2nd approach
//        intent.setClassName("com.hanseltritama.broadcastreceiver",
//            "com.hanseltritama.broadcastreceiver.MyBroadcastReceiver")

        // 3rd approach
//        intent.setPackage("com.hanseltritama.broadcastreceiver")

        // 4th approach
        val packageManager: PackageManager = packageManager

        // check which app that has a BroadcastReceiver that is registered
        // with an intent-filter com.hansel.MY_ACTION
        // Let the system found its receiver
        val infos: List<ResolveInfo> = packageManager.queryBroadcastReceivers(intent, 0)
        for (info in infos) {
            val cn = ComponentName(info.activityInfo.packageName,
                info.activityInfo.name)
            intent.component = cn
            sendBroadcast(intent)
        }
    }
}
