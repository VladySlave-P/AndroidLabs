package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaName = findViewById<TextView>(R.id.PizzasName)

        val chooseSize = findViewById<TextView>(R.id.ChooseSize)
        val bigSize = findViewById<CheckBox>(R.id.BigSize)
        val middleSize = findViewById<CheckBox>(R.id.MiddleSize)
        val smallSize = findViewById<CheckBox>(R.id.SmallSize)

        val chooseDough = findViewById<TextView>(R.id.ChooseDough)
        val standardDough = findViewById<CheckBox>(R.id.StandardDough)
        val thinDough = findViewById<CheckBox>(R.id.ThinDough)
        val philadelphiaDough = findViewById<CheckBox>(R.id.PhiladelphiaDough)
        val boardHotDog = findViewById<CheckBox>(R.id.BoardHotDog)

        val offerText = findViewById<TextView>(R.id.OfferText)

        val okButton = findViewById<Button>(R.id.okButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        var resSize = ""

        bigSize.setOnClickListener {
            middleSize.isChecked = false
            smallSize.isChecked = false
            resSize= bigSize.text.toString()
        }
        middleSize.setOnClickListener {
            bigSize.isChecked = false
            smallSize.isChecked = false
            resSize= middleSize.text.toString()
        }
        smallSize.setOnClickListener {
            middleSize.isChecked = false
            bigSize.isChecked = false
            resSize= smallSize.text.toString()
        }

        var resDough =""

        standardDough.setOnClickListener {
            thinDough.isChecked = false
            philadelphiaDough.isChecked = false
            boardHotDog.isChecked = false
            resDough= standardDough.text.toString()
        }
        thinDough.setOnClickListener {
            standardDough.isChecked = false
            philadelphiaDough.isChecked = false
            boardHotDog.isChecked = false
            resDough= thinDough.text.toString()
        }
        philadelphiaDough.setOnClickListener {
            thinDough.isChecked = false
            standardDough.isChecked = false
            boardHotDog.isChecked = false
            resDough= philadelphiaDough.text.toString()
        }
        boardHotDog.setOnClickListener {
            thinDough.isChecked = false
            philadelphiaDough.isChecked = false
            standardDough.isChecked = false
            resDough= boardHotDog.text.toString()
        }

        okButton.setOnClickListener{
            if (pizzaName.text.isEmpty() ||
                (!bigSize.isChecked && !middleSize.isChecked && !smallSize.isChecked) ||
                (!standardDough.isChecked && !thinDough.isChecked && !philadelphiaDough.isChecked && !boardHotDog.isChecked)) {

                Toast.makeText(baseContext, "Заповніть всі поля", Toast.LENGTH_SHORT).show()
                }
            else {
                offerText.text= offerText.text.toString() +
                        "\n"+ pizzaName.text.toString()+ " "+ resSize + " "+ resDough
            }
        }

        clearButton.setOnClickListener{
            offerText.text = "Ваше замовлення:"
        }


    }
}