package com.example.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache.converters.RoomConverters
import com.example.cache.daos.CustomerDao
import com.example.cache.daos.OrderDao
import com.example.cache.daos.SellerDao
import com.example.cache.daos.UserDao
import com.example.cache.models.CustomerEntity
import com.example.cache.models.OrderEntity
import com.example.cache.models.SellerEntity
import com.example.cache.models.UserEntity
import com.example.cache.utils.Constants

@Database(
    entities = [
        UserEntity::class,
        SellerEntity::class,
        CustomerEntity::class,
        OrderEntity::class
    ],
    version = Constants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(RoomConverters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao
    abstract fun sellerDao(): SellerDao
    abstract fun customerDao(): CustomerDao
}