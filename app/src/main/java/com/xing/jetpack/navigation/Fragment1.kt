package com.xing.jetpack.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.xing.jetpack.R


/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        val button: Button = view.findViewById<Button>(R.id.btn_user_list)
        button.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("name", "tomcat")
            bundle.putInt("age", 12)
            val options = NavOptions.Builder()
                .setEnterAnim(R.anim.anim_enter)
                .setPopExitAnim(R.anim.anim_exit)
                .build()

            findNavController().navigate(R.id.action_fragment1_to_fragment2, bundle)
        }
        return view
    }


}
