package com.goofy.localcache.starter.core

interface CacheFunction {
    fun add(key: String, value: Any)

    fun get(key: String): Any?

    fun delete(key: String)
}
