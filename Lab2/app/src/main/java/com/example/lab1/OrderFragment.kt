package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lab1.R

class OrderFragment  : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.order_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val resName = arguments?.getString("resName")
        val resSize = arguments?.getString("resSize")
        val resDough = arguments?.getString("resDough")

        val textView: TextView = view?.findViewById(R.id.OfferText) as TextView

            textView.text = textView.text.toString() +
                    "\n"+ resName + " "+ resSize + " "+ resDough
    }
}
