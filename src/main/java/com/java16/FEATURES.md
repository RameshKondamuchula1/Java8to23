# Java 16 — Interview Notes

## Records (standard)
- Compact immutable data carrier: `record Order(String id, double amount) {}`.
- Auto: constructor, accessors (`id()`, not `getId()`), `equals`, `hashCode`, `toString`.
- Can add compact constructor for validation, extra methods, implement interfaces.
- Cannot extend a class (implicitly extend `java.lang.Record`). Can be generic.
- Q: Record vs Lombok `@Value`? Language-level, no extra dependency, truly immutable components.

## Pattern Matching for `instanceof` (standard)
- `if (payment instanceof Card card)` — bind and cast in one step.
- Scope of `card` is the true branch (and further refined conditions).

## Stream.toList()
- Unmodifiable list. Shorter than `collect(Collectors.toList())`.
- Q: vs `Collectors.toList()`? `toList()` is unmodifiable; classic collector is (usually) a mutable `ArrayList`.

## Stream.mapMulti
- Push 0..N elements into a downstream consumer. Alternative to `flatMap` when you would otherwise allocate a tiny stream per element.
- Primitive cousins: `mapMultiToInt` / `mapMultiToLong` / `mapMultiToDouble`.

## Objects (long index checks)
- `checkIndex` / `checkFromToIndex` / `checkFromIndexSize` now have `long` overloads.

## Other
- `Period` / `Duration` `to*Part` methods, Unix-domain sockets, records as local/nested types.
- Vector API still incubator — skip in interviews unless they ask SIMD.
