package com.bala.bolt

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoltTest {
    private val bolt = Bolt()

    @Test
    fun `test create bolt container`() {
        val container = bolt.getContainer()

        assertNotNull(container)
    }

    @Test
    fun `test returns same bolt container when same key is used`() {
        val container1 = bolt.getContainer("key")
        val container2 = bolt.getContainer("key")

        assertTrue(container1 === container2)
    }
}