package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.Constants

@Entity(tableName = Constants.ENTITY_ORDER)
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Long? = null,
    val discount: Int? = null,
    val rating: Double? = null,
    val seller: SellerEntity? = null,
    val categories: List<String>? = null
)
