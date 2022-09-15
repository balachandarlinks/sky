package com.bala.bolt

import javax.inject.Inject
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.hasAnnotation

internal class ConstructorResolver {
    fun resolve(kClass: KClass<*>): KFunction<Any>? {
        val constructors = kClass.constructors
        return constructors.find { it.hasAnnotation<Inject>() }
    }
}
