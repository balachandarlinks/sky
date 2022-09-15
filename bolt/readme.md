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
val foo = container.get<Foo>()
```

## Note

- Constructors need to be annotated with `@Inject` to be used for dependency injection.
- If multiple constructors are annotated, first one will be used.
- If no constructor is annotated, throws error.
- If constructor has parameters, they need to have a constructor annotated with `@Inject` as well.
- Finds circular dependencies and throws error with detail.

## Limitations

- No compile time safety. Unverified injections may crash at runtime.
- Only creates transient objects. No support for singleton.
- Uses reflection.

## Roadmap
- Supporting singleton.
- Supporting interfaces.