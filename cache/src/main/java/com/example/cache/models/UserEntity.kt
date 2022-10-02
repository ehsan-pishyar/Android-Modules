package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_USER)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val email: String? = null,
    val password: String? = null,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null
)
