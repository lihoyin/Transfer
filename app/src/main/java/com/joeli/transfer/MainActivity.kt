package com.joeli.transfer

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.joeli.transfer.databinding.ActivityMainBinding
import com.joeli.transfer.model.MainViewModel
import com.joeli.transfer.presenter.MainPresenterImpl
import com.joeli.transfer.utils.isValidAmount
import com.joeli.transfer.utils.showKeyboard
import com.joeli.transfer.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val viewModel = MainViewModel()
    private val presenter = MainPresenterImpl(this, this, viewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)

        binding.model = viewModel
        binding.view = this
    }

    override fun onAmountChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        submitButton.isEnabled = s.toString().isValidAmount()
    }

    override fun onReset() {
        viewModel.reset()
        amountField.setText("")
        amountField.showKeyboard()
    }

    override fun onSubmit() {
        presenter.doTransfer()
    }

    override fun getAmount(): Int {
        return amountField.text.toString().toIntOrNull() ?: 0
    }
}
