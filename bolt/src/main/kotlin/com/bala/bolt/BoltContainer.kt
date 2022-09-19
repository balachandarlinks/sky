package com.bala.bolt

import com.bala.bolt.errors.CircularDependencyError
import com.bala.bolt.errors.NoConstructorFoundError
import kotlin.reflect.KClass

class BoltContainer {
    private val singletonStore = mutableMapOf<KClass<*>, Any?>()
    private val constructorResolver = ConstructorResolver()

    /**
     * Creates a new instance of the given class.
     *
     * @param clazz The class to create an instance of.
     * @return The new instance.
     */
    inline fun <reified T : Any> inject(): T = inject(T::class) as T

    /**
     * Registers the given class a singleton.
     * @param clazz The class to be considered as singleton during injection.
     */
    inline fun <reified T : Any> registerSingleton() = registerSingleton(T::class)

    @PublishedApi
    internal fun inject(kClass: KClass<*>): Any {
        singletonStore[kClass]?.let { return it }

        val constructor = constructorResolver.resolve(kClass) ?: throw NoConstructorFoundError(kClass)

        val args = try {
            constructor.parameters.map { param ->
                val paramClass = param.type.classifier as KClass<*>
                inject(paramClass)
            }
        } catch (e: StackOverflowError) {
            throw CircularDependencyError(kClass)
        }

        val instance = constructor.call(*args.toTypedArray())

        if (singletonStore.containsKey(kClass)) {
            singletonStore[kClass] = instance
        }

        return instance
    }

    @PublishedApi
    internal fun registerSingleton(kClass: KClass<*>) {
        singletonStore.putIfAbsent(kClass, null)
    }
}
