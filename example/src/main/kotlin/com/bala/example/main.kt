package com.bala.example

import com.bala.bolt.Bolt
import com.bala.example.uuid.RandomUuidProvider

fun main() {
    val bolt = Bolt()

    // Create a bolt container
    val container = bolt.getContainer()

    // Transient injection
    val randomUuidProvider1 = container.inject<RandomUuidProvider>()
    randomUuidProvider1.printUuid()
    val randomUuidProvider2 = container.inject<RandomUuidProvider>()
    randomUuidProvider2.printUuid()

    // Singleton injection
    container.registerSingleton<RandomUuidProvider>()
    val singletonRandomUuidProvider1 = container.inject<RandomUuidProvider>()
    singletonRandomUuidProvider1.printUuid()
    val singletonRandomUuidProvider2 = container.inject<RandomUuidProvider>()
    singletonRandomUuidProvider2.printUuid()
}
