package com.fabinpaul.notizia.data.source.remote

import androidx.paging.PagingSource
import com.fabinpaul.notizia.data.model.Article
import com.fabinpaul.notizia.preference.UserPreference

class TopHeadlinesNewsApiPagingSource(
    private val newsApiService: NewsApiService,
    private val userPreference: UserPreference
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: PAGE_STARTING_INDEX
        return try {
            val headlinesResponse = newsApiService.topHeadlines(
                country = userPreference.country(),
                page = page,
                pageSize = params.loadSize
            )
            LoadResult.Page(
                data = headlinesResponse.articles,
                prevKey = if (page == PAGE_STARTING_INDEX) null else page - 1,
                nextKey = if (page == headlinesResponse.totalResults) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val PAGE_STARTING_INDEX = 1
    }
}