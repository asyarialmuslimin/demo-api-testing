package com.saifur.demoapitesting.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.saifur.demoapitesting.databinding.ActivityMainBinding
import com.saifur.demoapitesting.utils.Status
import com.saifur.demoapitesting.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val storyViewModel: PostViewModel by viewModel()
    private val storyAdapter by lazy {
        StoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStory.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = storyAdapter
        }

        storyViewModel.getStory().observe(this) { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    result.data?.let { storyAdapter.setData(it) }
                    with(binding) {
                        rvStory.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        errorLayout.visibility = View.GONE
                    }
                }
                Status.ERROR -> {
                    with(binding) {
                        rvStory.visibility = View.GONE
                        progressBar.visibility = View.GONE
                        errorLayout.visibility = View.VISIBLE
                    }
                }
                Status.LOADING -> {
                    with(binding) {
                        rvStory.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                        errorLayout.visibility = View.GONE
                    }
                }
            }
        }

        binding.btnCreate.setOnClickListener {
            startActivity(Intent(this, CreateStoryActivity::class.java))
        }
    }
}