package com.fabinpaul.notizia.data

import androidx.paging.PagingData
import com.fabinpaul.notizia.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getTopHeadlineNewsStream(): Flow<PagingData<Article>>
}