package com.example.elso_ora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val d6 = Dice(6)
        var d6result = 1
        val rollbutton: Button = findViewById(R.id.button_roll)
        val diceNumber: TextView = findViewById(R.id.textview_dicenumber)
        val diceImageView: ImageView = findViewById(R.id.imageView_dice)


        rollbutton.setOnClickListener {
            d6result = d6.rolldoce()
            diceNumber.text = d6.rolldoce().toString()

            val drawableResources = when (d6result) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> {
                    R.drawable.dice_6
                }
            }
            diceImageView.setImageResource(drawableResources)



            Toast.makeText(applicationContext, "roll was made", Toast.LENGTH_SHORT).show()


        }


    }
}

class Dice(val numSides: Int) {
    fun rolldoce(): Int {
        return (1..numSides).random()
    }

}