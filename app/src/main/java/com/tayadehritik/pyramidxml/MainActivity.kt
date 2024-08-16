package com.tayadehritik.pyramidxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.tayadehritik.pyramidxml.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel:MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.input.addTextChangedListener {
            viewModel.updatePyramidHeight(it.toString().toInt())
        }

        lifecycleScope.launch{
            viewModel.pyramid.collectLatest{
                binding.resultText.text = viewModel.getResultString()
            }
        }
    }
}