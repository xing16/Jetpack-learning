package com.xing.jetpack.room.one2one

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "tb_idcard", primaryKeys = ["cid"])
data class IdCard(
    @ColumnInfo(name = "cid") val cardId: String,
    @ColumnInfo(name = "publish_date") val publishDate: Date
)