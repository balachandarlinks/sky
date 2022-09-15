package com.bala.bolt.errors

import kotlin.reflect.KClass

class NoConstructorFoundError(
    private val kClass: KClass<*>
) : RuntimeException() {
    override val message: String
        get() = "No constructor found with @Inject annotation for the class (${kClass.qualifiedName})"
}
