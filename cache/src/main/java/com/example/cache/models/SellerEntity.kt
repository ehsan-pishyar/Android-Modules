package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_SELLER)
data class SellerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val user: UserEntity? = null,
    val title: String? = null,
    val description: String? = null,
    val state: String? = null,
    val city: String? = null,
    val orders: List<OrderEntity>? = emptyList()
)
