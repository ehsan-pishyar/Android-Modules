package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.AppDatabase
import com.example.cache.converters.RoomConverters
import com.example.cache.daos.CustomerDao
import com.example.cache.daos.OrderDao
import com.example.cache.daos.SellerDao
import com.example.cache.daos.UserDao
import com.example.cache.utils.Constants
import com.example.cache.utils.GsonParser
import com.example.cache.utils.JsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun gsonProvider(gson: Gson): JsonParser =
        GsonParser(gson)

    @Provides
    @Singleton
    fun roomConvertersProvider(jsonParser: JsonParser): RoomConverters =
        RoomConverters(jsonParser)

    @Provides
    @Singleton
    fun appDatabaseProvider(@ApplicationContext app: Context, roomConverters: RoomConverters) =
        Room.databaseBuilder(app, AppDatabase::class.java, Constants.DB_NAME)
            .addTypeConverter(roomConverters)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun userDaoProvider(database: AppDatabase): UserDao =
        database.userDao()

    @Provides
    @Singleton
    fun sellerDaoProvider(database: AppDatabase): SellerDao =
        database.sellerDao()

    @Provides
    @Singleton
    fun customerDaoProvider(database: AppDatabase): CustomerDao =
        database.customerDao()

    @Provides
    @Singleton
    fun orderDaoProvider(database: AppDatabase): OrderDao =
        database.orderDao()
}