package org.d3if3063.asesmen1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3063.asesmen1.model.FunFact
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"+"AlifFadhlan/asesmen1mobpro/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FactApiService {
    @GET("static-api.json")
    suspend fun getFact(): List<FunFact>
}

object FactApi {
    val service: FactApiService by lazy {
        retrofit.create(FactApiService::class.java)
    }
    fun getFactUrl(imageId: String): String {
        return "$BASE_URL$imageId.png"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
