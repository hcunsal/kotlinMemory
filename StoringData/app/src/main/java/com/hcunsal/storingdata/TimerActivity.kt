package com.hcunsal.storingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_timer.*

    var runnable : Runnable = java.lang.Runnable{ }
    var handler : Handler = Handler(Looper.getMainLooper())
    var timerNumber = 0

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val intent = intent
        val number = intent.getStringExtra("number")
        numberText2.text = "NUMBER: $number"


        object : CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                leftTimeText.text = "Left: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                leftTimeText.text = "Left: 0"
            }

        }.start()

    }

    fun start(view: View){
        timerNumber = 0

        runnable = object : Runnable{
            override fun run() {
                timerNumber = timerNumber + 1
                timerText.text = "Timer: $timerNumber"
                handler.postDelayed(runnable, 1000)
            }

        }
    handler.post(runnable)
    }

    fun stop(view: View){
        timerText.text = "Time: 0"
        handler.removeCallbacks(runnable)
    }
}