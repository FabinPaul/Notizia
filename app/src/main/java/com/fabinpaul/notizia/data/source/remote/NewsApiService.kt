package com.fabinpaul.notizia.data.source.remote

import com.fabinpaul.notizia.BuildConfig
import com.fabinpaul.notizia.data.model.NewsResponse
import com.fabinpaul.notizia.data.model.SourcesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {


    @GET("v2/top-headlines")
    suspend fun topHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") clientId: String = BuildConfig.NEWS_API_KEY,
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @Query("q") query: String? = null
    ): NewsResponse

    @GET("v2/sources")
    suspend fun sources(
        @Query("apiKey") clientId: String = BuildConfig.NEWS_API_KEY,
        @Query("category") category: String? = null,
        @Query("language") language: String? = null,
        @Query("country") country: String? = null
    ): SourcesResponse

    @GET("v2/everything")
    suspend fun everything(
        @Query("apiKey") clientId: String = BuildConfig.NEWS_API_KEY,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("q") query: String? = null,
        @Query("qInTitle") queryTitle: String? = null,
        @Query("sources") sources: String? = null,
        @Query("domains") domains: String? = null,
        @Query("excludeDomains") excludeDomains: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") language: String? = null,
        @Query("sortBy") sortBy: String? = null
    ): NewsResponse

    companion object {

        fun create(): NewsApiService {
            val logger = HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BASIC
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.NEWS_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApiService::class.java)
        }
    }
}