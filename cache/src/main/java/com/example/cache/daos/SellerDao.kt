package com.example.cache.daos

import androidx.room.*
import com.example.cache.models.SellerEntity

@Dao
interface SellerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSeller(seller: SellerEntity)

    @Query("SELECT * FROM `seller_table`")
    suspend fun getSellers(): List<SellerEntity>

    @Query("SELECT * FROM `seller_table` WHERE id = :sellerId")
    suspend fun getSellerById(sellerId: Long): SellerEntity

    @Query("SELECT * FROM `seller_table` WHERE title like :sellerTitle")
    suspend fun getSellersByTitle(sellerTitle: String?): List<SellerEntity>

    @Update(entity = SellerEntity::class)
    suspend fun updateSeller(seller: SellerEntity)

    @Query("DELETE FROM `seller_table` WHERE id = :sellerId")
    suspend fun deleteSellerById(sellerId: Long)

    @Query("DELETE FROM `seller_table`")
    suspend fun deleteSellers()

    @Query("SELECT COUNT(*) FROM `seller_table`")
    suspend fun isSellerCacheAvailable(): Int
}