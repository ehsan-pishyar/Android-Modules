package com.example.cache.daos

import androidx.room.*
import com.example.cache.models.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM `user_table` WHERE id = :userId")
    suspend fun getUserById(userId: Long): UserEntity

    @Query("SELECT * FROM `user_table` WHERE email = :userEmail")
    suspend fun getUserByEmail(userEmail: String?): UserEntity

    @Update(entity = UserEntity::class)
    suspend fun updateUser(userEntity: UserEntity)

    @Query("DELETE FROM `user_table` WHERE id = :userId")
    suspend fun deleteUser(userId: Long)

    @Query("SELECT COUNT(*) FROM `user_table`")
    suspend fun isUserCacheAvailable(): Int
}