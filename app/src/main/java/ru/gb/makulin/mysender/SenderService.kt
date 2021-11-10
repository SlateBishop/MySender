package ru.gb.makulin.mysender

import android.app.IntentService
import android.content.Intent

class SenderService(name: String = "SenderService") : IntentService(name) {

    private val INTENT_FILTER = "INTENT FILTER"
    private val GET_MSG_EXTRA = "GET MSG EXTRA"
    private val PUT_MSG_EXTRA = "PUT MSG EXTRA"


    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            val message = it.getStringExtra(GET_MSG_EXTRA)
            val senderIntent = Intent(INTENT_FILTER)
            senderIntent.putExtra(PUT_MSG_EXTRA,message)
            sendBroadcast(senderIntent)
        }
    }
}