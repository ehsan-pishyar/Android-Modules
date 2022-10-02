package com.example.cache.daos

import androidx.room.*
import com.example.cache.models.CustomerEntity

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: CustomerEntity)

    @Query("SELECT * FROM `customer_table` WHERE id = :customerId")
    suspend fun getCustomerById(customerId: Long): CustomerEntity

    @Update(entity = CustomerEntity::class)
    suspend fun updateCustomer(customer: CustomerEntity)

    @Query("DELETE FROM `customer_table`")
    suspend fun deleteCustomer()

    @Query("SELECT COUNT(*) FROM `customer_table`")
    suspend fun isCustomerCacheAvailable(): Int
}