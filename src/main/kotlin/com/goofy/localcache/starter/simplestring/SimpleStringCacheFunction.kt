package com.goofy.localcache.starter.simplestring

import com.goofy.localcache.starter.core.CacheFunction
import com.goofy.localcache.starter.core.CacheMemory

class SimpleStringCacheFunction(
    private val cacheMemory: CacheMemory
) : CacheFunction {
    override fun add(key: String, value: Any) {
        TODO("Not yet implemented")
    }

    override fun get(key: String): Any? {
        TODO("Not yet implemented")
    }

    override fun delete(key: String) {
        TODO("Not yet implemented")
    }
}
