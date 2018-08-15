# RetrofitKit
[![Release](https://jitpack.io/v/jamesdeperio/PocketLib.svg)](https://jitpack.io/#jamesdeperio/RetrofitKit)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## USAGE:
RetrofitManager
- extend with your to apply this lazy retrofit configuration
- available methods
    * initCacheSize
    * initBaseURL
    * initWriteTimeOut
    * initConnectTimeOut
    * initReadTimeOut
    * initConverterFactory
    * initRxAdapterFactory
    * isPrintLogEnabled
    * clearRetrofit
    * create(service: Class<*>)
    * OkHttpClient.Builder.interceptorConfiguration(builder: OkHttpClient.Builder) //add your custom interceptor
    
       
```kotlin
class NetworkManager(context: Context) : RetrofitManager(context=context) {
    private var restRepository:RestRepository = create(RestRepository::class.java) as RestRepository //provide your api locator

    override fun initBaseURL(): String = "baseURL.com/"
    override fun initCacheSize(): Int = 0
    override fun initConnectTimeOut(): Long = 60
    override fun initReadTimeOut(): Long = 60
    override fun initWriteTimeOut(): Long = 60

    override fun initConverterFactory(): Converter.Factory = SerializationFormatFactory.Builder()
            .setXMLConverterFactory(converterFactory = TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
            .setJSONConverterFactory(converterFactory = GsonConverterFactory.create(GsonBuilder().setLenient().create()))
             //.addCustomConverterFactory(responseFormat = YAMLFormat::class.java, converterFactory = YAMLConverterFactory.create())
            .build()

    override fun initRxAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
    override fun isPrintLogEnabled(): Boolean = true
}

interface RestRepository {
    @GET("something")
    @JSONFormat
    fun getResponse1(): Observable<Response>

    @GET("something")
    @XMLFormat
    fun getResponse2(): Observable<Response>

   // @GET("something")
   // @YAMLFormat
   // fun getResponse3(): Observable<Response>

}

```
___
* SerializationFormatFactory.Builder()
- custom builder that allow multiple converterfactory
- available methods
    * setXMLConverterFactory
    * setJSONConverterFactory
    * addCustomConverterFactory
    
  
```kotlin
  SerializationFormatFactory.Builder()
    .setXMLConverterFactory(converterFactory = TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
    .setJSONConverterFactory(converterFactory = GsonConverterFactory.create(GsonBuilder().setLenient().create()))
    //.addCustomConverterFactory(responseFormat = YAMLFormat::class.java, converterFactory = YAMLConverterFactory.create())
    .build()
    
    //add annotation for custom converter
    @Retention(AnnotationRetention.RUNTIME)
    annotation class YAMLFormat

```
___
Thanks to the author of external Library used:
* [org.jetbrains.kotlin:kotlin-stdlib-jdk7](https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib)
* [com.squareup.retrofit2:retrofit](https://github.com/square/retrofit)
* [com.squareup.okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
