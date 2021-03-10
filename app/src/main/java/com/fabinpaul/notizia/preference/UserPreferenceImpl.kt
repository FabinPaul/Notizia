package com.fabinpaul.notizia.preference

import com.fabinpaul.notizia.data.model.Source
import java.util.*

object UserPreferenceImpl : UserPreference {

    override fun country(): String {
        return Locale.getDefault().country
    }

    override fun sources(): List<Source> {
        TODO("Not yet implemented")
    }

    override fun category(): String {
        TODO("Not yet implemented")
    }
}