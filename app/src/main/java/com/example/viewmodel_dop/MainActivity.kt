package com.example.viewmodel_dop

//noinspection SuspiciousImport
import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_dop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserves()
        setupListener()
    }


    private fun setupObserves() {
        viewModel?.number?.observe(this) {
            binding.countTxt.text = it.toString()
        }
    }

    private fun setupListener() {
        binding.plusBtn.setOnClickListener {
            viewModel?.setPlus()
            if (viewModel?.count == 10 || viewModel?.count == -10) {
                binding.countTxt.setTextColor(resources.getColor(R.color.holo_orange_dark))
            }else
                binding.countTxt.setTextColor(resources.getColor(R.color.white))
        }
        binding.minusBtn.setOnClickListener {
            viewModel?.setMinus()
            if (viewModel?.count == 10 || viewModel?.count == -10) {
                binding.countTxt.setTextColor(resources.getColor(R.color.holo_orange_dark))
            }else
                binding.countTxt.setTextColor(resources.getColor(R.color.white))
        }
    }
}