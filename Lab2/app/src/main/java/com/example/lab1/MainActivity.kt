package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity  : AppCompatActivity(), ChooseFragment.OnTextSent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chooseFragment = ChooseFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, chooseFragment)
            .commit()
    }

    override fun sendData(
        resName: String,
        resSize: String,
        resDough: String
    ) {
        val orderFragment = OrderFragment()
        val bundle = Bundle()

        if (resName.isNotEmpty() && resSize.isNotEmpty() && resDough.isNotEmpty()) {
            bundle.putString("resName", resName)
            bundle.putString("resSize", resSize)
            bundle.putString("resDough", resDough)

            orderFragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, orderFragment).addToBackStack(null).commit()

        } else {
            Toast.makeText(applicationContext, "Input field empty!", Toast.LENGTH_SHORT).show()
        }
    }

}