package com.android.example.projectmobile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.projectmobile.database.FoodDatabase
import com.android.example.projectmobile.databinding.FragmentAddfoodBinding


class AddFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<FragmentAddfoodBinding>(
            inflater,
            R.layout.fragment_addfood,
            container,
            false
        )

        setHasOptionsMenu(true)

        return binding.root
    }

}