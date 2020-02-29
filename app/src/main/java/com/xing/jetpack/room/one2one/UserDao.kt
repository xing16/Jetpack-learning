package com.xing.jetpack.room.one2one

import androidx.room.*

@Dao
interface UserDao {

    @Query("select * from tb_user")
    fun getAllUsers(): List<User>


    @Query("select * from tb_user where name = :name")
    fun getUserByName(name: String): User

    @Delete
    fun deleteByUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

}