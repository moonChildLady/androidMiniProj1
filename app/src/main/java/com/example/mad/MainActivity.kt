package com.example.mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random
import android.widget.ImageView
import com.example.s20079853.R

class MainActivity : AppCompatActivity() {

    val cards = arrayOf(
        R.drawable.cards_1,
        R.drawable.cards_2,
        R.drawable.cards_3,
        R.drawable.cards_4,
        R.drawable.cards_5,
        R.drawable.cards_6,
        R.drawable.cards_7,
        R.drawable.cards_8,
        R.drawable.cards_9,
        R.drawable.cards_10,
        R.drawable.cards_11,
        R.drawable.cards_12,
        R.drawable.cards_13,
        R.drawable.cards_back,
    )

    var cardsName = mapOf(
        0 to "Ace",
        1 to "2",
        2 to "3",
        3 to "4",
        4 to "5",
        5 to "6",
        6 to "7",
        7 to "8",
        8 to "9",
        9 to "10",
        10 to "J",
        11 to "Q",
        12 to "K",
    )

    var count = 0
    var points = 0
    var totalpoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun generateNextNumber(v: View) {                                                  //view = object
        //val luckyNumberTV = findViewById<TextView>(R.id.luckyNumberTV)               //UI ID
        var cardImageView_1 = findViewById<ImageView>(R.id.cardImageView_1)
        var cardImageView_2 = findViewById<ImageView>(R.id.cardImageView_2)

        var points_TV = findViewById<TextView>(R.id.getPoint_TV)
        var totalpoints_TV = findViewById<TextView>(R.id.totalPoints_TV)
        var card_status = findViewById<TextView>(R.id.card_status)

        var round_TV = findViewById<TextView>(R.id.round_tv)
        var cards1 = Random.nextInt(0, 12)
        var cards2 = Random.nextInt(0, 12)
        //card_status.text = ""
        //01_luckyNumberTV.text = luckyNumber.toString()
        //04_When click button will call the luckNumber.toString()
        //05_number = class
        //02_luckyNumberTV.text = cards[luckyNumber]
        //03_cardImageView.setImageResource(R.drawable.cards_1)
        cardImageView_1.setImageResource(cards[cards1])
        cardImageView_2.setImageResource(cards[cards2])

        when{
            cards1 == 0 && cards2 == 0 -> points = 50
            cards1 == 10 && cards2 == 10 -> points = 20
            cards1 == 11 && cards2 == 11 -> points = 20
            cards1 == 12 && cards2 == 12 -> points = 20
            cards1 == 9 && cards2 == 9 -> points = 10
            cards1 == 0 || cards2 == 0 -> points = 2
            cards1 == cards2 -> points = 5
            else -> points = -1
        }

        when {
            cards1==0 -> card_status.text = "One ${cardsName[cards1]}"
            cards2==0 -> card_status.text = "One ${cardsName[cards2]}"

            cards1==cards2 -> card_status.text = "Congrats!! One Pair of ${cardsName[cards2]}!"
            else -> card_status.text = "Oh! Please try again!"
        }

        points_TV.text = points.toString()
        totalpoints += this.points
        totalpoints_TV.text = totalpoints.toString()
        //Round x 0 times
        count+=1
        round_TV.text = "Round x ${count} times".toString()
    }
}