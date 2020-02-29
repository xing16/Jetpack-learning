package com.xing.jetpack.room

import androidx.room.*
import com.xing.jetpack.room.one2many.Computer
import com.xing.jetpack.room.one2many.Programmer

@Dao
interface ProgrammerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(programmer: Programmer)

    @Delete
    fun delete(programmer: Programmer)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(programmer: Programmer)

    @Query("select * from  tb_programmer")
    fun query(): List<Programmer>

    @Query("select * from tb_computer inner join tb_programmer where tb_computer.programmer_name = :programmerName")
    fun queryProgrammerComputers(programmerName: String): List<Computer>

}