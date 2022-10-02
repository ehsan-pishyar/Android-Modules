package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_CUSTOMER)
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val user: UserEntity? = null,
    val name: String? = null,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null,
    val address: String? = null
)
