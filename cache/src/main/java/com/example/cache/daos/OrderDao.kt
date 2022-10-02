package com.example.cache.daos

import androidx.room.*
import com.example.cache.models.OrderEntity

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrder(order: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrders(orders: List<OrderEntity>?)

    @Query("SELECT * FROM `order_table`")
    suspend fun getOrders(): List<OrderEntity>?

    @Query("SELECT * FROM `order_table` WHERE id = :orderId")
    suspend fun getOrderById(orderId: Long?): OrderEntity

    @Query("SELECT * FROM `order_table` WHERE title LIKE :orderTitle OR description LIKE :orderDescription")
    suspend fun getOrdersByTitleOrDescription(orderTitle: String?, orderDescription: String?): List<OrderEntity>?

    @Query("SELECT * FROM `order_table` WHERE price <= :orderPrice")
    suspend fun getOrdersByPrice(orderPrice: Long): List<OrderEntity>?

    @Query("SELECT * FROM `order_table` WHERE price BETWEEN :minPrice AND :maxPrice")
    suspend fun getOrdersByPriceRange(minPrice: Long, maxPrice: Long): List<OrderEntity>?

    @Query("SELECT title, price FROM `order_table`")
    suspend fun getOrdersTitleAndPrice(): List<OrderEntity>?

    @Query("SELECT * FROM `order_table` WHERE categories IN (:orderCategories)")
    suspend fun getOrdersOfCategories(orderCategories: List<String?>?): List<OrderEntity>?

    @Update(entity = OrderEntity::class)
    suspend fun updateOrder(order: OrderEntity)

    @Query("DELETE FROM `order_table` WHERE id = :orderId")
    suspend fun deleteOrderById(orderId: Long?)

    @Query("DELETE FROM `order_table`")
    suspend fun deleteOrders()

    @Query("SELECT COUNT(*) FROM `order_table`")
    suspend fun isOrderCacheAvailable(): Int
}