package com.example.androidcoursepractice.di

import com.example.androidcoursepractice.data.api.IProductApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Апишка:
// https://fakestoreapi.com/products - все продукты
// https://fakestoreapi.com/products/{id} - продукт по id

val networkModule = module {
    factory { provideRetrofit() }
    single { provideNetworkApi(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

}

fun provideNetworkApi(retrofit: Retrofit): IProductApi =
    retrofit.create(IProductApi::class.java)