package com.fitifyworkouts.bodyweight.workoutap.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitifyworkouts.bodyweight.workoutap.R
import kotlinx.android.synthetic.main.activity_text.*

class TextAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        ok_btn.setOnClickListener{
            startActivity(Intent(this, GameStart::class.java))
        }
    }
}