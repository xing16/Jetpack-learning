package com.xing.jetpack.coroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xing.jetpack.R
import com.xing.jetpack.api.ApiService
import com.xing.jetpack.http.RetrofitClient
import com.xing.jetpack.model.Banner
import com.xing.jetpack.viewmodel.BannerViewModel
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.InputStream

class CoroutineActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById<Button>(R.id.tv_result)
        val imageView: ImageView = findViewById(R.id.iv_image)


        val viewModel = ViewModelProviders.of(this).get(BannerViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            textView.text = it.toString()
        })


        launch {
            Log.e("debug", "thread = ${Thread.currentThread().name}")
            textView.text = "casdcas"
//            val inputStream = getImageStream()
//            val bitmap = convertBitmap(inputStream!!)
//            imageView.setImageBitmap(bitmap)
//
            val avatar = async {
                Log.e("debug", "avatar")
                getAvatar()
            }

            val name = async {
                Log.e("debug", "name")
                getName()
            }

            Log.e("debug", "${name.await()}")
            Log.e("debug", "${avatar.await()}")


        }
//        GlobalScope.launch(Dispatchers.Main) {
//
//            val avatar: String? = load1()
//            Log.e("debug", "thread 222= ${Thread.currentThread().name}")
//            launch(Dispatchers.Main) { }
//            textView.text = avatar
//        }
    }


    private suspend fun load() = withContext(Dispatchers.IO) {
        Log.e("debug", "thread 111 = ${Thread.currentThread().name}")
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://www.baidu.com")
            .build()
        val response: Response = client.newCall(request).execute()
        response.body?.string()
    }


    private suspend fun load1(): String? {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("http://www.baidu.com")
                .build()
            val response: Response = client.newCall(request).execute()
            response.body?.string()
        }
    }

    private suspend fun getImageStream(): InputStream? {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://user-gold-cdn.xitu.io/2019/9/21/16d52b9d63b87cef?imageView2/1/w/1304/h/734/q/85/format/webp/interlace/1")
                .build()
            val response: Response = client.newCall(request).execute()
            response.body?.byteStream()
        }
    }

    private suspend fun convertBitmap(inputStream: InputStream): Bitmap {
        return withContext(Dispatchers.IO) {
            BitmapFactory.decodeStream(inputStream)
        }
    }

    private suspend fun getAvatar(): String {
        return withContext(Dispatchers.IO) {
            delay(7000)
            "http://www.avatar.com"
        }
    }

    private suspend fun getName(): String {
        return withContext(Dispatchers.IO) {
            delay(4000)
            "tomcat"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    private suspend fun loadBanner(): List<Banner> {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.get().retrofit.create(ApiService::class.java)
            apiService.loadBanner().data
        }
    }


}