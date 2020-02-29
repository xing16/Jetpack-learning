package com.xing.jetpack.room.one2many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * 多方
 */
@Entity(
    tableName = "tb_computer", foreignKeys = [
        ForeignKey(
            entity = Programmer::class,
            parentColumns = ["pname"],
            childColumns = ["programmer_name"]
        )]
)
data class Computer(
    @PrimaryKey
    @ColumnInfo(name = "computer_id") val computerId: String,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "price") val price: Double,
    // 外键
    @ColumnInfo(name = "programmer_name") val programmerName: String
)