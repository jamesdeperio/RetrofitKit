package jdp.retrofitkitdemo

import android.content.Context
import io.reactivex.schedulers.Schedulers

fun execute(context: Context) {
    val networkManager = NetworkManager (context=context)
    //using rxjava
    networkManager.restRepository.getResponse1()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                print(it.string())
            }
    //using default retrofit
    print(networkManager.restRepository.getResponse2().execute().body()!!.string())
}
