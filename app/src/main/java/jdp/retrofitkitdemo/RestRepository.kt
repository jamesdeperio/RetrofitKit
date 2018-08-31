package jdp.retrofitkitdemo

import io.reactivex.Observable
import jdp.retrofitkit.JSONFormat
import jdp.retrofitkit.XMLFormat
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface RestRepository {
    @GET("something")
    @JSONFormat
    fun getResponse1(): Observable<ResponseBody>

    @GET("something")
    @XMLFormat
    fun getResponse2(): Call<ResponseBody>

}