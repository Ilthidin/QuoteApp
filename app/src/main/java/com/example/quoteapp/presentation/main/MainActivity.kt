package com.example.quoteapp.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.quoteapp.data.datasource.QuoteApiDataSource
import com.example.quoteapp.data.datasource.QuoteDataSource
import com.example.quoteapp.data.repository.QuoteRepository
import com.example.quoteapp.data.repository.QuoteRepositoryImpl
import com.example.quoteapp.data.source.network.services.QuoteApiServices
import com.example.quoteapp.databinding.ActivityMainBinding
import com.example.quoteapp.utils.GenericViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels {
        val s = QuoteApiServices.invoke()
        val ds: QuoteDataSource = QuoteApiDataSource(s)
        val rp: QuoteRepository = QuoteRepositoryImpl(ds)
        GenericViewModelFactory.create(MainViewModel(rp))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}