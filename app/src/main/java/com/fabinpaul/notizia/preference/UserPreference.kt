package com.fabinpaul.notizia.preference

import com.fabinpaul.notizia.data.model.Source

interface UserPreference {

    fun country(): String

    fun sources(): List<Source>

    fun category(): String

}