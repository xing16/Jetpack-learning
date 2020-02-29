package com.xing.jetpack.test

fun main() {

    val baseImpl = BaseImpl()
    // 调用的是 BaseImpl 中的 say() 方法
    BaseProxy(baseImpl).say()

//    val user = User()
//    user.setName("tomcat")
//    user.show()


}

/**
 * 定义 Base 接口
 *
 */
interface Base {
    fun say()
}

/**
 * 定义 Base 接口的实现类，并实现 say() 方法
 */
class BaseImpl : Base {
    override fun say() {
        println("BaseImpl say()")
    }
}

/**
 * 定义 BaseProxy 类，并实现了 Base 接口，
 * by 关键字将接口 Base 中所有的方法都委托给 base 对象，这样 BaseProxy 类就不需要去实现接口 Base 中的方法了，
 * 简化了实现接口时要实现其中的方法。
 */
class BaseProxy(base: Base) : Base by base

class User {
    private lateinit var name: String
    private val password: String by lazy {
        println("lazy init")
        "admin"
    }

    fun setName(name: String) {
        this.name = name
    }

    fun show() {
        println("name = $name")
        println("--------------------")
        println("第一次访问 password = $password")
        println("第二次访问 password = $password")
    }
}

