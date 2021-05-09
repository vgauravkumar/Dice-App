package com.example.mydice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Dice(var n: Int) {
    fun roll(): Int {
        return (1..n).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener() {
            rollDice()
            makeTost()
            println("Thanks")
        }
    }

    private fun makeTost() {
        val toast = Toast.makeText(this, "Dice Rolled.", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultImageView: ImageView = findViewById(R.id.imageView)
        when(diceRoll){
            1 -> resultImageView.setImageResource(R.drawable.dice_1)
            2 -> resultImageView.setImageResource(R.drawable.dice_2)
            3 -> resultImageView.setImageResource(R.drawable.dice_3)
            4 -> resultImageView.setImageResource(R.drawable.dice_4)
            5 -> resultImageView.setImageResource(R.drawable.dice_5)
            6 -> resultImageView.setImageResource(R.drawable.dice_6)
        }
        resultTextView.text = diceRoll.toString()
    }
}