package com.bala.bolt

import com.bala.bolt.errors.CircularDependencyError
import com.bala.bolt.errors.NoConstructorFoundError
import com.bala.bolt.stubs.Foo
import com.bala.bolt.stubs.FooNoInject
import com.bala.bolt.stubs.FooBar
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TransientInjectorTest {

    private val bolt = Bolt()

    @Test
    fun `test transient injector`() {
        val container = bolt.getContainer()

        val foo = container.inject<Foo>()

        assertNotNull(foo)
    }

    @Test
    fun `test transient injector returns new object everytime`() {
        val container = bolt.getContainer()

        val foo = container.inject<Foo>()
        val foo1 = container.inject<Foo>()

        assertTrue(foo !== foo1)
    }

    @Test
    fun `test transient injector without @Inject annotated constructor`() {
        val container = bolt.getContainer()

        assertThrows<NoConstructorFoundError> {
            container.inject<FooNoInject>()
        }
    }

    @Test
    fun `test transient injector with circular dependency`() {
        val container = bolt.getContainer()

        assertThrows<CircularDependencyError> {
            container.inject<FooBar>()
        }
    }
}