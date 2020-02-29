package com.xing.jetpack.navigation


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.xing.jetpack.R

class Fragment2 : Fragment() {

    private var name: String? = null
    private var age: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment2, container, false)
        val textView = view.findViewById<TextView>(R.id.tv_title)
        val button: Button = view.findViewById(R.id.btn_detail_back)
        val button2: Button = view.findViewById(R.id.btn_fragment3)
        button2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment3)
        }
        button.setOnClickListener {
            findNavController().navigateUp()
        }
        textView.text = "name = $name, age = $age"
        return view

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        name = arguments?.getString("name")
        age = arguments?.getInt("age")
    }


}
