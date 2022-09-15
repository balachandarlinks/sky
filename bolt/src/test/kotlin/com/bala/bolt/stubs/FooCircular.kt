package com.bala.bolt.stubs

import javax.inject.Inject

class FooWithBar @Inject constructor(bar: BarWithFoo)

class BarWithFoo @Inject constructor(foo: FooWithBar)