package com.android.example.projectmobile

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.projectmobile.database.FoodDAO
import com.android.example.projectmobile.databinding.FragmentAddfoodBinding


class FoodViewModelFactory(
    private val dataSource: FoodDAO,
    private val binding:FragmentAddfoodBinding,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            return FoodViewModel(dataSource,binding, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}