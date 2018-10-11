package jdp.retrofitkitdemo

import android.content.Context
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import jdp.retrofitkit.RetrofitManager
import jdp.retrofitkit.SerializationFormatFactory
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager(context:Context) : RetrofitManager(context = context) {
    var restRepository:RestRepository = create(RestRepository::class.java) as RestRepository //provide your api interface

    override fun initCacheSize(): Int = 0
    override fun initBaseURL(): String = "http://BASE URL.com/"

    override fun initConverterFactory(): Converter.Factory {
        //kotlin
        //using TikXml library as xml converter
        val tikXMLConverter = TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build())
        //using GSON library as json converter
        val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())
        return SerializationFormatFactory.Builder()
                .setXMLConverterFactory(tikXMLConverter)
                .setJSONConverterFactory(gsonConverter)
                .build()
    }
    override fun initCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
    override fun isPrintLogEnabled(): Boolean = true
}
