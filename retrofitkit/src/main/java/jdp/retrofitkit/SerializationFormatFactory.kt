package jdp.retrofitkit

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

@Suppress("UNREACHABLE_CODE")
class SerializationFormatFactory(private val factory: Map<Class<*>, Converter.Factory>) : Converter.Factory() {

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        annotations!!
                .map { factory[it.annotationClass.javaObjectType] }
                .filter { it!= null}
                .forEach { return it!!.responseBodyConverter(type!!, annotations, retrofit!!) }
        throw RuntimeException("FORGOT TO ADD RETROFIT RESPONSE STRING FORMAT! [eg. @XMLFormat, @JSONFORMAT]")
        return null
    }
     class Builder {
        private var converterFactoryMap: MutableMap<Class<*>, Converter.Factory> = HashMap()

        fun setXMLConverterFactory( converterFactory: Converter.Factory): Builder {
            this.converterFactoryMap[XMLFormat::class.java] = converterFactory
            return this
        }

        fun setJSONConverterFactory( converterFactory: Converter.Factory): Builder {
            this.converterFactoryMap[JSONFormat::class.java] = converterFactory
            return this
        }

         fun addCustomConverterFactory(responseFormat: Class<out Annotation>, converterFactory: Converter.Factory): Builder {
             this.converterFactoryMap[responseFormat] = converterFactory
             return this
         }

         fun build(): SerializationFormatFactory {
             if (converterFactoryMap.isEmpty()) throw RuntimeException("FORGOT TO ADD CONVERTER FACTORY! ")
             return SerializationFormatFactory(converterFactoryMap)
         }

    }
}