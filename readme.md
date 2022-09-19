Bolt is a simple DI lib to inject dependencies.

## Installation

```groovy
dependencies {
    implementation (":bolt")
}
```

## Usage

```kotlin
val bolt = Bolt()
val container = bolt.container() // Optional key param helps to create and retrieve the same container if needed.

// Transient
val foo = container.inject<Foo>()

// Singleton
container.registerSingleton<Bar>()
val bar = container.inject<Bar>()
```

## Note

- Constructors need to be annotated with `@Inject` to be used for dependency injection.
- If multiple constructors are annotated, first one will be used.
- If no constructor is annotated, throws error.
- If constructor has parameters, they need to have a constructor annotated with `@Inject` as well.
- Finds circular dependencies and reports the object that has circular dependency.

## Limitations

- No compile time safety. Unverified injections may crash at runtime.
- Uses reflection.

## Roadmap
- Supporting interfaces.