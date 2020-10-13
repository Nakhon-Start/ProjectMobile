package com.android.example.projectmobile.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Food_table")
class FoodDB {
    @PrimaryKey(autoGenerate = true) var foodId: Long = 0L

    @ColumnInfo(name = "Name") var foodname : String = ""

    @ColumnInfo(name = "Material") var material : String = ""

    @ColumnInfo(name = "Recipe") var recipe : String = ""
}