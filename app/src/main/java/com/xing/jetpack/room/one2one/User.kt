package com.xing.jetpack.room.one2one

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tb_user",
    foreignKeys = [ForeignKey(
        entity = IdCard::class,
        parentColumns = ["cid"],     // 父表主键
        childColumns = ["card_id"]   // 关联表外键
    )]
)
data class User(

    @PrimaryKey
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "vip") val vip: Boolean = false,
    // 外键， 一对一关联关系
    @ColumnInfo(name = "card_id") val cardId: String

)