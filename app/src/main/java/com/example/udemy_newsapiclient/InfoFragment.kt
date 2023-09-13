package com.example.udemy_newsapiclient

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.udemy_newsapiclient.databinding.FragmentInfoBinding
import com.example.udemy_newsapiclient.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class InfoFragment : Fragment() {

    private lateinit var fragmentInfoBinding : FragmentInfoBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()

        val article = args.selectedArticle

        newsViewModel = (activity as MainActivity).newsViewModel

        fragmentInfoBinding.wvNews.apply {
            webViewClient = WebViewClient()
            if(article.url != null) {
                loadUrl(article.url)
            }

        }

        fragmentInfoBinding.fabSave.setOnClickListener {
            newsViewModel.saveArticle(article)
            Snackbar.make(view, "Saved successfully", Snackbar.LENGTH_LONG).show()
        }
    }
}