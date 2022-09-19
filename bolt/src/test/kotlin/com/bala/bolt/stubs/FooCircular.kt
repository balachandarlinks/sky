package com.bala.bolt.stubs

import javax.inject.Inject

class FooBar @Inject constructor(barFoo: BarFoo)

class BarFoo @Inject constructor(fooBar: FooBar)
