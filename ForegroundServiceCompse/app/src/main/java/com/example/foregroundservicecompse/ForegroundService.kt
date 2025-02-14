package com.example.foregroundservicecompse

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    @SuppressLint("ForegroundServiceType")
    private fun start() {
        val notification = NotificationCompat.Builder(
            this,
            "channel"
        ).apply {
            setContentText("Hello Abdallah")
            setSmallIcon(R.drawable.ic_launcher_foreground)
        }.build()

        startForeground(1, notification)
    }

    enum class Actions {
        START, STOP
    }
}