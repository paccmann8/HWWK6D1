package com.example.hwwk6d1.presenter

import android.util.Log
import com.example.hwwk6d1.network.GitFactory
import com.example.hwwk6d1.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPresenter: GitContract.Presenter {

    private val gitFactory = GitFactory()

    private lateinit var view: GitContract.View
    override fun getRepositories() {
        //TODO: Implement retrofit
        gitFactory.getRepositories().enqueue(object :
            Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                Log.d("TAG_X", "onREsponse")
                response.body()?.let { repositories ->
                    if(repositories.isNotEmpty())
                        view.displayRepositories(repositories)
                    else
                        view.displayError()

    }




            }
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Log.d("TAG_X", "onFailure®")
                view.displayError()
            }
        })
    }

    override fun setView(view: GitContract.View) {
        this.view = view
    }

}