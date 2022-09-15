package com.bala.bolt

import com.bala.bolt.errors.CircularDependencyError
import com.bala.bolt.errors.NoConstructorFoundError
import javax.inject.Inject
import kotlin.reflect.KClass
import kotlin.reflect.full.hasAnnotation

class BoltContainer {
    private val constructorResolver = ConstructorResolver()

    /**
     * Creates a new instance of the given class.
     */
    inline fun <reified T : Any> inject(): T = inject(T::class) as T

    @PublishedApi
    internal fun inject(kClass: KClass<*>): Any {
        val constructor = constructorResolver.resolve(kClass) ?: throw NoConstructorFoundError(kClass)

        val args = try {
            constructor.parameters
                .map { param ->
                    val paramClass = param.type.classifier as KClass<*>
                    inject(paramClass)
                }
        } catch (e: StackOverflowError) {
            throw CircularDependencyError(kClass)
        }

        return constructor.call(*args.toTypedArray())
    }
}
