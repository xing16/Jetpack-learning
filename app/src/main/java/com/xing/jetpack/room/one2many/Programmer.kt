package com.xing.jetpack.room.one2many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 *  一方
 */
@Entity(tableName = "tb_programmer")
data class Programmer(
    @PrimaryKey
    @ColumnInfo(name = "pname") val name: String,
    @ColumnInfo(name = "age") val age: Int
//    @ColumnInfo(name = "computers") val computers: List<Computer>
)