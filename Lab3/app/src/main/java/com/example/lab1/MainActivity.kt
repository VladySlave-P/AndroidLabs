package com.example.lab1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.*
import java.lang.Exception

class MainActivity  : AppCompatActivity(), ChooseFragment.OnTextSent, ChooseFragment.ShowStorage {

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

            writeFileOnInternalStorage("orderData", resName+" "+resSize+" "+resDough)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, orderFragment).addToBackStack(null).commit()

        } else {
            Toast.makeText(applicationContext, "Input field empty!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun show() {
        val intent = Intent(this, InternalStorageActivity::class.java)
        startActivity(intent)
    }

    private fun writeFileOnInternalStorage(fileName: String, fileData: String) {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND)
            fileOutputStream.write(("$fileData, ").toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}