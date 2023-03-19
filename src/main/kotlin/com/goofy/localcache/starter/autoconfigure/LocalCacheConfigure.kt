package com.goofy.localcache.starter.autoconfigure

import com.goofy.localcache.starter.core.CacheFunction
import com.goofy.localcache.starter.core.ValueType
import com.goofy.localcache.starter.simplestring.SimpleStringCacheFunction
import com.goofy.localcache.starter.simplestring.SimpleStringCacheMemory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class LocalCacheConfigure {
    @Bean
    fun cacheFunction(localCacheProperties: LocalCacheProperties): CacheFunction {
        return when (localCacheProperties.type) {
            ValueType.SIMPLE_STRING -> SimpleStringCacheFunction(SimpleStringCacheMemory())
            else -> throw RuntimeException("error")
        }
    }

    @Primary
    @Configuration
    @ConfigurationProperties(prefix = "goofy.starter.cache.local")
    @ConfigurationPropertiesBinding
    class LocalCacheProperties {
        var type: ValueType? = null
    }
}
