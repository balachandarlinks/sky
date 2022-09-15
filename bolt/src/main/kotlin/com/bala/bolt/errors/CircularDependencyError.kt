package com.bala.bolt.errors

import java.lang.RuntimeException
import kotlin.reflect.KClass

class CircularDependencyError(
    private val kClass: KClass<*>
) : RuntimeException() {
    override val message: String
        get() = "Circular dependency while resolving dependencies for ${kClass.qualifiedName}"
}