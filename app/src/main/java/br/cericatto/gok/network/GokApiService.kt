package br.cericatto.gok.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GokApiService {
    @GET("sandbox/products")
    suspend fun getProperties(
    ): GokProperty
}

object GokApi {
    val retrofitService : GokApiService by lazy {
        retrofit.create(GokApiService::class.java)
    }
}