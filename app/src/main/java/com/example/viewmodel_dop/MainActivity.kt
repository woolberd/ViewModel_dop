package com.example.viewmodel_dop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_dop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserves()
        setupListener()
    }

    private fun setupObserves() {
      viewModel?.number?.observe(this){
          binding.countTxt.text = it.toString()
      }
    }

    private fun setupListener() {
        binding.plusBtn.setOnClickListener {
            viewModel?.setPlus()
        }
        binding.minusBtn.setOnClickListener {
            viewModel?.setMinus()
        }
    }
}