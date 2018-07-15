package com.joeli.transfer

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joeli.transfer.databinding.ActivityMainBinding
import com.joeli.transfer.model.MainViewModel
import com.joeli.transfer.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.model = viewModel
        binding.view = this
    }

    override fun onAmountChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        submitButton.isEnabled = !s.toString().isEmpty()
    }

    override fun onReset() {
        viewModel.isSubmitted.postValue(false)
        viewModel.description.postValue("")
        viewModel.isLoading.postValue(false)
        viewModel.isSuccess.postValue(false)
    }

    override fun onSubmit() {
        viewModel.isSubmitted.postValue(true)
        viewModel.isLoading.postValue(true)
        viewModel.isSuccess.postValue(true)
        viewModel.description.postValue(getString(R.string.result_success))
    }

    override fun getAmount(): Int {
        Log.d("test", "getAmount")
        return amountField.text.toString().toInt()
    }
}
