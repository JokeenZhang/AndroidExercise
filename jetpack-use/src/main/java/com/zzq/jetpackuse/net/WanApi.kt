package com.zzq.jetpackuse.net

import retrofit2.http.GET

interface WanApi {

    @GET("")
    fun getArticles():List<String>
}