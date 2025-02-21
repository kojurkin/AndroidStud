package com.example.lab28broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

//для того чтобы мы смогли принимать свои сообщения (типо приемник, через манифест)
class MessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action.equals("android.intent.action.ACTION_POWER_DISCONNECTED", true)) {
            Toast.makeText(context, "Обнаружено сообщение: выдернут кабель", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Обнаружено сообщение: "
                    + intent.getStringExtra("com.broadcast.Message"), Toast.LENGTH_LONG).show()
        }
    }

}