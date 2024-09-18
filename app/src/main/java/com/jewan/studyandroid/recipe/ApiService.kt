package com.jewan.studyandroid.recipe

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()) // Gson: 코틀린의 객체로 변환
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("categories.php") // Http 요청의 엔드포인트
    suspend fun getCategories(): CategoriesResponse // suspend: 동시성을 간단하고 구조화된 방식으로 관리하는 코루틴 API의 일종
    // UI로 인한 프리징을 막기 위해
    // 코루틴: 코틀린의 동시성 프레임 워크, 잠재적으로 시간이 많이 소요되는 작업을 백그라운드에서 실행함으로써 효율적이고 반응이 빠른 사용자 인터페이스 제공
}