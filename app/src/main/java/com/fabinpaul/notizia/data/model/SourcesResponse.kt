package com.fabinpaul.notizia.data.model

data class SourcesResponse(
    val sources: List<SourceDetail>,
    val status: String
)