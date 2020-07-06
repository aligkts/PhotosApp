package com.aligkts.photos.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY_VALUE)
            .addQueryParameter(METHOD_QUERY, METHOD_VALUE)
            .addQueryParameter(FORMAT_QUERY, FORMAT_VALUE)
            .addQueryParameter(NO_JSON_CALLBACK_QUERY, NO_JSON_CALLBACK_VALUE)
            .addQueryParameter(EXTRAS_QUERY, EXTRAS_VALUE)
            .addQueryParameter(PER_PAGE_QUERY, PER_PAGE_VALUE)
            .build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

    companion object {
        const val BASE_URL = "https://www.flickr.com/"

        const val API_KEY_QUERY = "api_key"
        const val API_KEY_VALUE = "bc6c771cbdd250504b69987a1036e151"

        const val METHOD_QUERY = "method"
        const val METHOD_VALUE = "flickr.photos.getRecent"

        const val FORMAT_QUERY = "format"
        const val FORMAT_VALUE = "json"

        const val NO_JSON_CALLBACK_QUERY = "nojsoncallback"
        const val NO_JSON_CALLBACK_VALUE = "1"

        const val EXTRAS_QUERY = "extras"
        const val EXTRAS_VALUE = "url_m"

        const val PER_PAGE_QUERY = "per_page"
        const val PER_PAGE_VALUE = "20"
    }
}