package com.example.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.cache.models.CustomerEntity
import com.example.cache.models.OrderEntity
import com.example.cache.models.SellerEntity
import com.example.cache.models.UserEntity
import com.example.cache.utils.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class RoomConverters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromUserJson(json: String): UserEntity? {
        return jsonParser.fromJson<UserEntity>(json, object : TypeToken<UserEntity>(){}.type)
    }

    @TypeConverter
    fun toUserJson(userEntity: UserEntity?): String {
        return jsonParser.toJson(userEntity, object : TypeToken<UserEntity>(){}.type) ?: ""
    }

    @TypeConverter
    fun fromSellerJson(json: String): SellerEntity? {
        return jsonParser.fromJson<SellerEntity>(json, object : TypeToken<SellerEntity>(){}.type)
    }

    @TypeConverter
    fun toSellerJson(sellerEntity: SellerEntity): String {
        return jsonParser.toJson(sellerEntity, object : TypeToken<SellerEntity>(){}.type) ?: ""
    }

    @TypeConverter
    fun fromCustomerJson(json: String): CustomerEntity? {
        return jsonParser.fromJson(json, object : TypeToken<CustomerEntity>(){}.type)
    }

    @TypeConverter
    fun toCustomerJson(customerEntity: CustomerEntity): String {
        return jsonParser.toJson(customerEntity, object : TypeToken<CustomerEntity>(){}.type) ?: ""
    }

    @TypeConverter
    fun fromOrdersJson(json: String): List<OrderEntity>? {
        return jsonParser.fromJson(json, object : TypeToken<List<OrderEntity>?>(){}.type)
    }

    @TypeConverter
    fun toOrdersEntity(orderEntity: List<OrderEntity>?): String {
        return jsonParser.toJson(orderEntity, object : TypeToken<List<OrderEntity>?>(){}.type) ?: ""
    }

    @TypeConverter
    fun fromString(string: String): List<String>? {
        return jsonParser.fromJson(string, object : TypeToken<List<String>?>() {}.type)
    }

    @TypeConverter
    fun toString(strings: List<String>?): String? {
        return jsonParser.toJson(strings, object : TypeToken<List<String>?>() {}.type)
    }
}