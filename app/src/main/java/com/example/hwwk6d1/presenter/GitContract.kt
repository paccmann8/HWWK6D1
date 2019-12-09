package com.example.hwwk6d1.presenter

import android.view.View
import com.example.hwwk6d1.model.Repository


interface GitContract {

    interface Presenter {
        fun getRepositories()
        fun setView(view: GitContract.View)
    }

    interface View {
        fun displayRepositories(repositories: List<Repository>)
        fun displayError()
    }
}