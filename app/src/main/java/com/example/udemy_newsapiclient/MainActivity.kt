package com.example.udemy_newsapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.udemy_newsapiclient.databinding.ActivityMainBinding
import com.example.udemy_newsapiclient.presentation.adapter.NewsAdapter
import com.example.udemy_newsapiclient.presentation.viewmodel.NewsViewModel
import com.example.udemy_newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var newsViewModel : NewsViewModel
    @Inject
    lateinit var newsViewModelFactory : NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(navController)

        newsViewModel = ViewModelProvider(this, newsViewModelFactory)
            .get(NewsViewModel::class.java)
    }
}