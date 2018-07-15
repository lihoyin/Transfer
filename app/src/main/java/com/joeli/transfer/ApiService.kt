package com.joeli.transfer

import com.joeli.transfer.model.ResponseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("bins/lo2fa")
    fun transfer(@Query("amount") amount: Int): Observable<ResponseModel.Response>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.myjson.com/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}