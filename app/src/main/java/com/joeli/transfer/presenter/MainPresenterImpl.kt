package com.joeli.transfer.presenter

import android.content.Context
import com.joeli.transfer.ApiService
import com.joeli.transfer.R
import com.joeli.transfer.model.MainViewModel
import com.joeli.transfer.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(private val context: Context, val view: MainView, val viewModel: MainViewModel) : MainPresenter {
    private val apiService by lazy { ApiService.create() }

    override fun doTransfer() {
        viewModel.isSubmitted.postValue(true)
        viewModel.isLoading.postValue(true)

        apiService.transfer(view.getAmount())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewModel.isLoading.postValue(false)
                    viewModel.isSuccess.postValue(it.result.success)
                    viewModel.description.postValue(if (it.result.success) context.getString(R.string.result_success) else it.result.error.message)
                }, {
                    viewModel.description.postValue(context.getString(R.string.result_fail))
                    viewModel.isLoading.postValue(false)
                    viewModel.isSuccess.postValue(false)
                })
    }
}