package com.bala.example.uuid

import javax.inject.Inject

class RandomUuidProvider @Inject constructor(
    uuidGenerator: UuidGenerator
) {
    private val uuid = uuidGenerator.generate()

    fun printUuid() = println(uuid.toString())
}