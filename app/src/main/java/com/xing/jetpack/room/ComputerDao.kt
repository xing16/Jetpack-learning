package com.xing.jetpack.room

import androidx.room.*
import com.xing.jetpack.room.one2many.Computer

@Dao
interface ComputerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(computer: Computer)

    @Delete
    fun delete(computer: Computer)

    @Update
    fun update(computer: Computer)

    @Query("select * from tb_computer")
    fun queryComputers(): List<Computer>

//    @Query("select * from tb_programmer inner join tb_computer where tb_programmer.pname in ")
//    fun queryProgrammerByComputerId(computerId: String): Programmer


}