package com.fabinpaul.notizia.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fabinpaul.notizia.data.model.Article
import com.fabinpaul.notizia.data.source.remote.TopHeadlinesNewsApiPagingSource
import com.fabinpaul.notizia.data.source.remote.NewsApiService
import com.fabinpaul.notizia.preference.UserPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService,
    private val userPreference: UserPreference
) : NewsRepository {

    override fun getTopHeadlineNewsStream(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { TopHeadlinesNewsApiPagingSource(newsApiService, userPreference) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 35
    }
}