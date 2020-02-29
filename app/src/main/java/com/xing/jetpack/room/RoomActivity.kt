package com.xing.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.xing.jetpack.R
import com.xing.jetpack.room.one2one.IdCard
import com.xing.jetpack.room.one2one.User
import java.lang.Exception
import java.util.*

class RoomActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        textView = findViewById(R.id.tv_room_result)


    }

    fun click(view: View) {
        when (view.id) {
            R.id.btn_insert -> insert()
            R.id.btn_delete -> delete()
            R.id.btn_update -> update()
            R.id.btn_query -> query()
        }
    }

    fun insert() {
        val name = nameEditText.text.toString()
        val ageStr = ageEditText.text.toString()
        var age: Int = 0
        try {
            age = ageStr.toInt()
        } catch (e: Exception) {
            age = 0
        }
        AppDatabaseManager.getInstance(this).getIdCardDao().insertIdCard(IdCard(name, Date()))
    }

    fun delete() {

    }

    fun update() {

    }

    fun query() {

    }
}
