package com.android.example.projectmobile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.example.projectmobile.database.FoodDAO
import com.android.example.projectmobile.database.FoodDB
import com.android.example.projectmobile.databinding.FragmentAddfoodBinding
import kotlinx.coroutines.*

class FoodViewModel(private val database: FoodDAO,
                    private val binding: FragmentAddfoodBinding,
                    application: Application
): AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun onContactAdd() {
        uiScope.launch {
            val newFood = FoodDB()
            newFood.foodname = binding.FoodName.text.toString()
            newFood.material = binding.Material.text.toString()
            newFood.recipe = binding.Recipe.text.toString()
            insert(newFood)
        }
    }


    private suspend fun insert(foodDB: FoodDB) {
        withContext(Dispatchers.IO) {
            database.insert(foodDB)
        }
    }
}