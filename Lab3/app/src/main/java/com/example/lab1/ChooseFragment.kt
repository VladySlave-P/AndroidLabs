package com.example.lab1

import android.widget.Toast
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.ClassCastException

class ChooseFragment : Fragment() {

    private lateinit var onTextSentListener: OnTextSent
    private lateinit var onShowStorage: ShowStorage

    interface OnTextSent {
        fun sendData(
            resName: String,
            resSize: String,
            resDough: String
        )
    }

    interface ShowStorage {
        fun show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onTextSentListener = context as OnTextSent
            onShowStorage = context as ShowStorage
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onTextSent"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.choose_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pizzaName = view?.findViewById(R.id.PizzasName) as TextView

        val bigSize = view?.findViewById(R.id.BigSize) as CheckBox
        val middleSize = view?.findViewById(R.id.MiddleSize) as CheckBox
        val smallSize = view?.findViewById(R.id.SmallSize) as CheckBox

        val standardDough = view?.findViewById(R.id.StandardDough) as CheckBox
        val thinDough = view?.findViewById(R.id.ThinDough) as CheckBox
        val philadelphiaDough = view?.findViewById(R.id.PhiladelphiaDough) as CheckBox
        val boardHotDog = view?.findViewById(R.id.BoardHotDog) as CheckBox

        val okButton = view?.findViewById(R.id.okButton) as Button
        val clearButton = view?.findViewById(R.id.clearButton) as Button
        val showStorageButton: Button = view?.findViewById(R.id.show_storage_data_btn) as Button

        var resName = pizzaName.text.toString()

        var resSize = ""
        var resDough = ""


        bigSize.setOnClickListener {
            middleSize.isChecked = false
            smallSize.isChecked = false
            resSize = bigSize.text.toString()
        }
        middleSize.setOnClickListener {
            bigSize.isChecked = false
            smallSize.isChecked = false
            resSize = middleSize.text.toString()
        }
        smallSize.setOnClickListener {
            middleSize.isChecked = false
            bigSize.isChecked = false
            resSize = smallSize.text.toString()
        }

        standardDough.setOnClickListener {
            thinDough.isChecked = false
            philadelphiaDough.isChecked = false
            boardHotDog.isChecked = false
            resDough = standardDough.text.toString()
        }
        thinDough.setOnClickListener {
            standardDough.isChecked = false
            philadelphiaDough.isChecked = false
            boardHotDog.isChecked = false
            resDough = thinDough.text.toString()
        }
        philadelphiaDough.setOnClickListener {
            thinDough.isChecked = false
            standardDough.isChecked = false
            boardHotDog.isChecked = false
            resDough = philadelphiaDough.text.toString()
        }
        boardHotDog.setOnClickListener {
            thinDough.isChecked = false
            philadelphiaDough.isChecked = false
            standardDough.isChecked = false
            resDough = boardHotDog.text.toString()
        }

        okButton.setOnClickListener {
            resName = pizzaName.text.toString()

            if (smallSize.isChecked){
                resSize= smallSize.text.toString()
            } else if (middleSize.isChecked){
                resSize= middleSize.text.toString()
            } else if (bigSize.isChecked) {
                resSize= bigSize.text.toString()
            } else {
                resSize= ""
            }

            if (thinDough.isChecked){
                resDough= thinDough.text.toString()
            } else if (philadelphiaDough.isChecked){
                resDough= philadelphiaDough.text.toString()
            } else if (standardDough.isChecked) {
                resDough= standardDough.text.toString()
            } else if (boardHotDog.isChecked) {
                resDough= boardHotDog.text.toString()
            } else {
                resDough= ""
            }

            if(resName != "" && resSize!="" && resDough!="" && resName != "Заповніть всі поля" && resName != "Введіть назву піци") {
                passData(
                    resName,
                    resSize,
                    resDough
                )
            } else {
                pizzaName.text = "Заповніть всі поля";
            }
        }

        clearButton.setOnClickListener {
            thinDough.isChecked = false
            philadelphiaDough.isChecked = false
            standardDough.isChecked = false
            boardHotDog.isChecked = false

            bigSize.isChecked = false
            smallSize.isChecked = false
            middleSize.isChecked = false

            resName = "Введіть назву піци"
        }

        showStorageButton.setOnClickListener {
            showStorage()
        }
    }

    private fun showStorage() {
        if (::onShowStorage.isInitialized) {
            onShowStorage.show()
        }
    }

    private fun passData(
        resName: String,
        resSize: String,
        resDough: String
    ) {
        onTextSentListener.sendData(
            resName,
            resSize,
            resDough
        )
    }

}