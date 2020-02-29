package com.xing.jetpack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xing.jetpack.coroutine.CoroutineActivity
import com.xing.jetpack.navigation.BottomNavigationActivity
import com.xing.jetpack.navigation.NavigationActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun click(view: View) {
        when (view.id) {
            R.id.btn_coroutine -> gotoActivity(CoroutineActivity::class.java)
            R.id.btn_navigation -> gotoActivity(NavigationActivity::class.java)
            R.id.btn_bottom_navigation -> gotoActivity(BottomNavigationActivity::class.java)
        }
    }

    fun gotoActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)

    }


}
