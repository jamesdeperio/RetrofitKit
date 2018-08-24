# RetrofitKit
[![Release](https://jitpack.io/v/jamesdeperio/RetrofitKit.svg)](https://jitpack.io/#jamesdeperio/RetrofitKit)
[![GitHub release](https://img.shields.io/github/release/jamesdeperio/RetrofitKit.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/releases/)
[![GitHub tag](https://img.shields.io/github/tag/jamesdeperio/RetrofitKit.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/tags/)
[![GitHub commits](https://img.shields.io/github/commits-since/jamesdeperio/RetrofitKit/v2.0.0.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/commit/)
[![HitCount](http://hits.dwyl.io/jamesdeperio/RetrofitKit.svg)](http://hits.dwyl.io/jamesdeperio/RetrofitKit)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/graphs/commit-activity)
[![GitHub forks](https://img.shields.io/github/forks/jamesdeperio/RetrofitKit.svg?style=social&label=Fork&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/network/)
[![GitHub stars](https://img.shields.io/github/stars/jamesdeperio/RetrofitKit.svg?style=social&label=Star&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/jamesdeperio/RetrofitKit.svg?style=social&label=Watch&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/watchers/)
[![GitHub followers](https://img.shields.io/github/followers/jamesdeperio.svg?style=social&label=Follow&maxAge=2592000)](https://github.com/jamesdeperio?tab=followers)
## How to?

### Gradle
```groovy
dependencies {
    implementation 'com.github.jamesdeperio:RetrofitKit:v1.0.0'
}
```
- better if you will consider using [CodePocketBuilder](https://github.com/jamesdeperio/CodePocketBuilder)
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
SerializationFormatFactory.Builder()
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
