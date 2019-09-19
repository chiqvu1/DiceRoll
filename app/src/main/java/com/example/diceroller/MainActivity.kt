package com.example.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Rock 'n' Roll"
        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val toast_message: ArrayList<String> = ArrayList<String>(6)
        toast_message.add("Someone will invite you to a Karaoke party.")
        toast_message.add("May you someday be carbon neutral.")
        toast_message.add("Never forget a friend. Especially if he owes you.")
        toast_message.add("Fortune not found? Abort, Retry, Ignore.")
        toast_message.add("An alien of some sort will be appearing to you shortly.")
        toast_message.add("You will be hungry again in one hour.")

        Toast.makeText(this, toast_message[randomInt - 1], Toast.LENGTH_LONG).show()

        diceImage.setImageResource((drawableResource))

    }
}
