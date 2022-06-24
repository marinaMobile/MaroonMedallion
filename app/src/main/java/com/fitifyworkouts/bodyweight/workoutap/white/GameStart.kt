package com.fitifyworkouts.bodyweight.workoutap.white

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.fitifyworkouts.bodyweight.workoutap.R
import kotlinx.android.synthetic.main.activity_game_start.*
import kotlinx.coroutines.*


class GameStart : AppCompatActivity() {
    var currentProgress: Int = 0
    var currentProgressFood: Int = 0
    var currentProgressPlay: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)
        food_pb.progressTintList = ColorStateList.valueOf(Color.WHITE);
        play_pb.progressTintList = ColorStateList.valueOf(Color.WHITE);
        shower_pb.progressTintList = ColorStateList.valueOf(Color.WHITE);

    startRepeatingJob(1000)

        val catSound: MediaPlayer = MediaPlayer.create(this, R.raw.catsound)

        cat.setOnClickListener{
            catSound.start()
        }
        info.setOnClickListener{
            startActivity(Intent(this, TextAct::class.java))
        }
        food_pb.max = 100
        shower_pb.max = 100
        play_pb.max = 100

        food_pb.min = 0
        shower_pb.min = 0
        play_pb.min = 0

        fish.setOnClickListener{
            if (currentProgressFood < 100) {
                currentProgressFood += 20
            }
            ObjectAnimator.ofInt(food_pb, "progress", currentProgressFood)
                .start()
           Log.d("Number Test", currentProgressFood.toString())

        }
        shower.setOnClickListener{
            if(currentProgress < 100) {
                currentProgress+= 20
            }

            ObjectAnimator.ofInt(shower_pb, "progress", currentProgress)
                .start()
        }
        mouse.setOnClickListener{
            if(currentProgressPlay < 100) {
                currentProgressPlay+= 20
            }

            ObjectAnimator.ofInt(play_pb, "progress", currentProgressPlay)
                .start()
        }


    }




    private fun startRepeatingJob(timeInterval: Long): Job {
        return CoroutineScope(Dispatchers.Default).launch {
            while (NonCancellable.isActive) {
                // add your task here
                    if(currentProgressFood > 0){
                        currentProgressFood -= 10
                    }
                if(currentProgress > 0){
                    currentProgress -= 10
                }
                if(currentProgressPlay > 0){
                    currentProgressPlay -= 10
                }

                food_pb.progress = currentProgressFood
                play_pb.progress = currentProgressPlay
                shower_pb.progress = currentProgress

                Log.d("test", currentProgressFood.toString())
                delay(timeInterval)
            }
        }
    }




}