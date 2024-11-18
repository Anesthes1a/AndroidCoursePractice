package com.example.androidcoursepractice.di

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidcoursepractice.MyApplication
import com.example.androidcoursepractice.data.mapper.ProductResponseToEntityMapper
import com.example.androidcoursepractice.data.repository.ProductRepository
import com.example.androidcoursepractice.domain.repository.IProductRepository
import com.example.androidcoursepractice.presentation.viewModel.AllProductsViewModel
import com.example.androidcoursepractice.presentation.mapper.ProductEntityToUIMapper
import com.example.androidcoursepractice.presentation.viewModel.FavoriteProductsViewModel
import com.example.androidcoursepractice.presentation.viewModel.ProductDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val rootModule = module {
    single<IProductRepository> { ProductRepository(get(),get(),get()) }
    factory { ProductResponseToEntityMapper() }
    factory { ProductEntityToUIMapper() }
    viewModel { AllProductsViewModel(get(), get()) }
    viewModel { ProductDetailViewModel(get(), get()) }
    viewModel { FavoriteProductsViewModel(get(), get()) }
}