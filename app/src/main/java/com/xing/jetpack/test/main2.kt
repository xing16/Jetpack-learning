package com.xing.jetpack.test

import java.io.File
import java.nio.charset.Charset

fun main() {
    Thread {
        print("cdscsd")
    }
    print(globalNum)


    val file = File("/Users/xing/Desktop/Android.md")
    print(file.readText(Charset.forName("utf-8")))


    val c = getCount(11)
}


val globalNum = 20

class Person {
    fun getNumber() = globalNum
}


fun getCount(num: Int) = if (num > 0) 2 * num else num




/**
 * 给 File 添加 readText() 方法
 */
fun File.readText(charset: Charset): String = readBytes().toString(charset)


interface Listener {

}

