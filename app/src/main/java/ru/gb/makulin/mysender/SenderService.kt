package ru.gb.makulin.mysender

import android.app.IntentService
import android.content.Intent
import android.util.Log

const val INTENT_FILTER = "INTENT FILTER"
const val MSG_EXTRA = "GET MSG EXTRA"
const val SEND_MSG_EXTRA = "PUT MSG EXTRA"

class SenderService(name: String = "SenderService") : IntentService(name) {


    override fun onHandleIntent(intent: Intent?) {
        Log.d("mylogs", intent?.action.toString())
        intent?.let {
            val message = it.getStringExtra(MSG_EXTRA)
            Log.d("mylogs", message!!)
            val senderIntent = Intent(INTENT_FILTER)
            senderIntent.putExtra(SEND_MSG_EXTRA, message)
            sendBroadcast(senderIntent)
        }
    }
}