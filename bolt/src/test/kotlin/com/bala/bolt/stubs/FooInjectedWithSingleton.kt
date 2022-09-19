package com.bala.bolt.stubs

import javax.inject.Inject

class FooInjectedWithSingleton @Inject constructor(
    val bar: Bar
)

class Bar @Inject constructor()
