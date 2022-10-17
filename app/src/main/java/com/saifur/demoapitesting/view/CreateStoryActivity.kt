package com.saifur.demoapitesting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.saifur.demoapitesting.databinding.ActivityCreateStoryBinding
import com.saifur.demoapitesting.utils.Status
import com.saifur.demoapitesting.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateStoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateStoryBinding

    private val postViewModel: PostViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            postViewModel.createStory(
                binding.etTitle.text.toString(),
                binding.etDescription.text.toString()
            ).observe(this) {
                if (it.status == Status.SUCCESS) {
                    binding.etTitle.text.clear()
                    binding.etDescription.text.clear()
                    Snackbar
                        .make(binding.root, "Success Post", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}