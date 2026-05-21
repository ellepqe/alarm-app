package com.ellepqe.alarmapp.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.os.Vibrator
import com.ellepqe.alarmapp.R

class AlarmService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private var vibrator: Vibrator? = null
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): AlarmService = this@AlarmService
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        startAlarmSound()
        return START_STICKY
    }

    private fun startAlarmSound() {
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound)
            mediaPlayer?.isLooping = true
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun vibrate(duration: Long = 500) {
        vibrator?.vibrate(duration)
    }

    fun stopAlarm() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
