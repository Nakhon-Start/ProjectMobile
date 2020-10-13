package com.android.example.projectmobile.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDAO {

    @Insert
    fun insert(foodDB: FoodDB)

    @Query("SELECT * from Food_table")
    fun get(): LiveData<List<FoodDB>>
    
}