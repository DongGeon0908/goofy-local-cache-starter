package com.goofy.localcache.starter.core

class SimpleStringCacheFunction(
    private val cacheMemory: CacheMemory
) : CacheFunction<String> {
    override fun add(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun get(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun delete(key: String) {
        TODO("Not yet implemented")
    }
}
