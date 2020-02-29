package com.xing.jetpack.room.one2one

import androidx.room.*

@Dao
interface IdCardDao {

    @Query(value = "select * from tb_idcard")
    fun getIdcards(): List<IdCard>

    @Query(value = "select * from tb_idcard where cid = :card_id")
    fun getIdCardByName(card_id: String): IdCard

    @Delete
    fun deleteByIdCard(idCard: IdCard)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIdCard(idCard: IdCard)


}