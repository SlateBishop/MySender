package ru.gb.makulin.mysender

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.lang.Thread.sleep

const val INTENT_FILTER = "INTENT FILTER"
const val MSG_EXTRA = "GET MSG EXTRA"
const val SENDED_MSG_EXTRA = "SENDED MSG EXTRA"

class SenderService(name: String = "SenderService") : IntentService(name) {


    override fun onHandleIntent(intent: Intent?) {
        sleep(1000)
        Log.d("mylogs", "sender intent action" + intent?.action.toString())
        intent?.let {
            val message = it.getStringExtra(MSG_EXTRA)
            Log.d("mylogs", "sender message" + message!!)
            val senderIntent = Intent(INTENT_FILTER)
            senderIntent.putExtra(SENDED_MSG_EXTRA, message)
            sendBroadcast(senderIntent)
        }
    }
}