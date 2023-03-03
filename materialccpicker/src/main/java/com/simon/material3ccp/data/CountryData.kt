package com.juanmartin7961992.material3ccp.data

import androidx.annotation.DrawableRes
import com.juanmartin7961992.material3ccp.R
import java.util.*

data class CountryData(
    private var cCodes: String,
    val countryPhoneCode: String = "+90",
    val cNames:String = "tr",
    @DrawableRes val flagResID: Int = R.drawable.tr
) {
    val countryCode = cCodes.lowercase(Locale.getDefault())
}
