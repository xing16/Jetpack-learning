package com.xing.jetpack.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xing.jetpack.room.converters.DateConverter
import com.xing.jetpack.room.converters.ListConverter
import com.xing.jetpack.room.one2many.Computer
import com.xing.jetpack.room.one2many.Programmer
import com.xing.jetpack.room.one2one.IdCard
import com.xing.jetpack.room.one2one.IdCardDao
import com.xing.jetpack.room.one2one.User
import com.xing.jetpack.room.one2one.UserDao

@Database(entities = [User::class, IdCard::class, Programmer::class, Computer::class], version = 1)
@TypeConverters(DateConverter::class, ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getIdCardDao(): IdCardDao

    abstract fun getComputerDao(): ComputerDao

    abstract fun getProgrammerDao(): ProgrammerDao

}