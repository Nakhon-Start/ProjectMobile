package com.android.example.projectmobile

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.android.example.projectmobile.database.FoodDAO
import com.android.example.projectmobile.database.FoodDB
import java.lang.StringBuilder

class FoodListViewModel(
    private val database: FoodDAO, application: Application
) : AndroidViewModel(application) {

    private val contacts = database.get()
    val contactString = Transformations.map(contacts) { contacts ->
        formatContact(contacts)
    }

    private fun formatContact(contact: List<FoodDB>): Spanned {
        val sb = StringBuilder()
        sb.apply {
            //append(resources.getString(R.string.title))
            contact.forEach {
                append(it.foodname)
                append(" : ")
                append(it.material)
                append(", ")
                append(it.recipe)
                append("<br>")
            }
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}