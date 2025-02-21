package com.example.lab28broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.text.Format
import java.text.SimpleDateFormat
import java.util.Date

//класс приемник (типо программный, не через манифест)
class TimeBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val msgStr = StringBuilder("Текущее время: ")
        val formatter: Format = SimpleDateFormat("hh:mm:ss a")
        msgStr.append(formatter.format(Date()))
        Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show()
    }
}