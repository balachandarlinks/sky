package com.bala.bolt

import com.bala.bolt.stubs.Bar
import com.bala.bolt.stubs.Foo
import com.bala.bolt.stubs.FooInjectedWithSingleton
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SingletonInjectorTest {
    private val bolt = Bolt()

    @Test
    fun `test singleton register returns same object everytime`() {
        val container = bolt.getContainer()
        container.registerSingleton<Foo>()

        val foo = container.inject<Foo>()
        val foo1 = container.inject<Foo>()

        assertTrue(foo === foo1)
    }

    @Test
    fun `test singleton injected into transient objects`() {
        val container = bolt.getContainer()
        container.registerSingleton<Bar>()

        val foo = container.inject<FooInjectedWithSingleton>()
        val foo1 = container.inject<FooInjectedWithSingleton>()

        assertTrue(foo.bar === foo1.bar)
    }
}