package com.goofy.localcache.starter.core

interface CacheFunction<T> {
    fun add(key: String, value: T)

    fun get(key: String): T?

    fun delete(key: String)
}
