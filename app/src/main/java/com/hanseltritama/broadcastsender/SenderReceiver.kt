package com.hanseltritama.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class SenderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData: String = resultData
        var resultExtras: Bundle = getResultExtras(true)
        var stringExtra: String? = resultExtras .getString("stringExtra")

        resultCode += 1
        stringExtra += "->SenderReceiver"

        val toastText: String = "SenderReceiver\n" +
                "resultCode $resultCode\n" +
                "resultData $resultData\n" +
                "stringExtra $stringExtra"


        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "SenderReceiver"
        resultExtras.putString("stringExtra", stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }

}