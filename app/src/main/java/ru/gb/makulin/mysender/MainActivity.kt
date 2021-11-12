package ru.gb.makulin.mysender

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gb.makulin.mysender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val INTENT_ACTION = "Sender Intent"

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            var text = binding.editTextSend.text.toString()
            if (text == "") {
                text = "Пустое сообщение"
            }
            intent = Intent(this, SenderService::class.java)
            intent.putExtra(MSG_EXTRA, text)
            intent.action = INTENT_ACTION
            startService(intent)
        }
    }
}