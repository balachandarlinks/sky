package com.bala.example.uuid

import java.util.UUID
import javax.inject.Inject

class UuidGenerator @Inject constructor() {
    fun generate(): UUID = UUID.randomUUID()
}