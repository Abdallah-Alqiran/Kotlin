package com.example.stopwatchapp

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stopwatchapp.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isStarted = true
    private lateinit var serviceIntent: Intent
    private var time = 0.0

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.stArtOp.setOnClickListener {
            trueOrfalse()
        }

        binding.reset.setOnClickListener {
            reset()
        }

        serviceIntent = Intent(applicationContext,StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATED_TIME))

    }

    private fun trueOrfalse ()
    {
        if (isStarted)
            Start()
        else
            Stop()
    }

    private fun Start() {

        serviceIntent.putExtra(StopWatchService.CURRENT_TIME, time)
        startService(serviceIntent)

        binding.stArtOp.setBackgroundColor(resources.getColor(R.color.opColor,null))
        binding.stArtOp.text = "Stop"
        isStarted = false
    }

    private fun Stop() {

        stopService(serviceIntent)

        binding.stArtOp.setBackgroundColor(resources.getColor(R.color.artColor,null))
        binding.stArtOp.text = "Start"
        isStarted = true
    }

    private fun reset() {
        Stop()
        time = 0.0
        binding.txt.text = getFormattedTime(time)
    }


    private val updateTime : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(StopWatchService.CURRENT_TIME, 0.0)
            binding.txt.text = getFormattedTime(time)
        }

    }

    @SuppressLint("DefaultLocale")
    private fun getFormattedTime(time : Double):String {
        val timeInt = time.roundToInt()
        val hours = timeInt % 86400 / 3600
        val minutes = timeInt % 86400 % 3600 / 60
        val seconds = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d", hours, minutes, seconds)

    }

}