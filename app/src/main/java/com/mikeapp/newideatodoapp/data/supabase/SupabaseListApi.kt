package com.mikeapp.newideatodoapp.data.supabase

import com.mikeapp.newideatodoapp.data.supabase.model.SupabaseList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface SupabaseListApi {
    @GET("/rest/v1/list")
    suspend fun getLists(
        @Query("user") user: String
    ): List<SupabaseList>

    @GET("/rest/v1/list")
    suspend fun getList(
        @Query("id") id: String
    ): List<SupabaseList>

    @POST("/rest/v1/list")
    suspend fun insertList(
        @Body supabaseList: SupabaseList
    ): Response<Unit>

    @PATCH("/rest/v1/list")
    suspend fun update(
        @Query("id") id: String,
        @Body partialUpdate: Map<String, Long>
    ): Response<Unit>
}