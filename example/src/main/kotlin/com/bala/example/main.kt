package com.bala.example

import com.bala.bolt.Bolt
import com.bala.example.uuid.RandomUuidProvider


fun main() {
    val bolt = Bolt()
    val container = bolt.getContainer()
    val randomUuidProvider = container.inject<RandomUuidProvider>()
    randomUuidProvider.printUuid()
}
