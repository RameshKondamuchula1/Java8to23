# Java 8 — Interview Notes

LTS. Biggest language jump after Java 5. Almost every interview starts here.

## Lambda Expressions
- Anonymous function: `(args) -> body`. Used to pass **behavior** as data.
- Target type must be a **functional interface** (exactly one abstract method).
- Captured local variables must be **effectively final**.
- Q: Lambda vs anonymous class? Lambda has no `this` of its own; anonymous class does.

## Functional Interfaces
- `@FunctionalInterface` — one abstract method; default/static methods allowed.
- Built-ins: `Predicate<T>` (test), `Function<T,R>` (transform), `Consumer<T>` (side effect), `Supplier<T>` (produce), `BiFunction`, `UnaryOperator`.
- Q: Why not just use lambdas without this annotation? Annotation is a compile-time check, not required.

## Method References
- Shorthand lambda: `Order::getAmount`, `Customer::new`, `System.out::println`.
- Types: static, instance on a type, instance on a specific object, constructor.

## Stream API (full Java 8 surface)
- Not a data structure. A **pipeline**: source → intermediate (lazy) → terminal (eager).
- Stream can be consumed **only once**. Parallel streams use the common ForkJoinPool — avoid for I/O or shared mutable state.
- Intermediate: `filter`, `map` / `mapToInt|Long|Double`, `flatMap` / `flatMapToInt|Long|Double`, `distinct`, `sorted()`, `sorted(cmp)`, `peek`, `limit`, `skip`.
- Terminal: `forEach`, `forEachOrdered` (keeps encounter order on parallel), `toArray()`, `toArray(generator)`, `reduce` (identity, Optional, 3-arg combiner), `collect(Collector)`, `collect(supplier, acc, combiner)`, `min`, `max`, `count`, `anyMatch` / `allMatch` / `noneMatch`, `findFirst`, `findAny`.
- Factories: `empty`, `of`, `iterate(seed, f)`, `generate`, `concat`, `builder`.
- Q: `map` vs `flatMap`? `map` 1→1; `flatMap` 1→N and flattens.
- Q: `findFirst` vs `findAny`? First is encounter-order; any is cheaper on parallel.
- Q: `forEach` vs `forEachOrdered`? Ordered keeps source order when parallel.

## Collectors
- `toList`, `toSet`, `toMap`, `toCollection`, `groupingBy`, `partitioningBy`, `joining`.
- Numbers: `counting`, `summing*`, `averaging*`, `summarizing*`, `minBy`, `maxBy`, `reducing`.
- Adapters: `mapping`, `collectingAndThen`.
- Downstream: `groupingBy(Order::getCity, summingDouble(Order::getAmount))`.

## Optional
- Container for a value that may be absent. Avoids raw `null` in return types.
- Prefer `map` / `flatMap` / `orElse` / `orElseGet` / `orElseThrow`. Never `Optional.get()` blindly.
- Do **not** use as a field or method parameter. Do **not** wrap collections (use empty list).

## Collection / Iterable / List methods (default)
- `Iterable.forEach(Consumer)` — walk every element. Prefer this over a raw `for` when the body is a side effect.
- `Iterator.forEachRemaining(Consumer)` — finish the **rest** of an iterator after you already called `next()`.
- `Collection.removeIf(Predicate)` — in-place delete matching elements.
- `Collection.stream()` / `parallelStream()` / `spliterator()`.
- `List.sort(Comparator)` — in-place sort (better than `Collections.sort(list)`).
- `List.replaceAll(UnaryOperator)` — in-place map.
- Q: `forEach` vs enhanced-for? Same idea; `forEach` takes a lambda / method ref. Cannot use `break`; use a stream + `anyMatch` / `findFirst` instead.

## Map methods (default)
- `getOrDefault(key, default)`
- `putIfAbsent(key, value)`
- `computeIfAbsent(key, mappingFn)` — classic cache / “list per key” (`map.computeIfAbsent(city, k -> new ArrayList<>()).add(order)`).
- `computeIfPresent` / `compute` / `merge` — update a value from the old one (qty++, counters).
- `replace(k, v)` / `replace(k, old, new)` / `replaceAll` / `remove(k, v)` / `forEach(BiConsumer)`.
- Q: `putIfAbsent` vs `computeIfAbsent`? `putIfAbsent` stores a ready value (even if unused). `computeIfAbsent` runs the function **only** when the key is missing (or mapped to null).

## Objects (Java 8 additions)
- `isNull` / `nonNull` — method refs for `filter(Objects::nonNull)`.
- `requireNonNull(obj, Supplier<String>)` — build the error message only if null.

## Files (Java 8 stream / convenience APIs)
- `lines(path)`, `list(dir)`, `walk(start)`, `find(start, depth, matcher)` — must close the stream (try-with-resources).
- `readAllLines(path)`, `write(path, lines)`, `newBufferedReader(path)` / `newBufferedWriter(path)` (charset overloads already existed).

## Map.Entry comparators
- `comparingByKey()` / `comparingByValue()` (and overloads with a Comparator).

## String.join / StringJoiner
- `String.join(delimiter, elements…)` and `join(delimiter, Iterable)` — opposite of `split`.
- `StringJoiner` when you need prefix/suffix (`[INV-1, INV-2]`).

## Comparator factories
- `comparing`, `thenComparing`, `reversed`, `naturalOrder`, `nullsFirst` / `nullsLast`.
- Replaces most anonymous `Comparator` classes.

## Default & Static Interface Methods
- `default` — instance behavior with a body; classes inherit it, can override.
- `static` — helper on the interface; **not** inherited by implementing classes.
- Solves API evolution (e.g. `List.sort`) without breaking old implementations.
- Q: Multiple default methods with same signature? Class must override (unless one is more specific).

## Date/Time API (`java.time`)
- Immutable, thread-safe. Replaces `Date` / `Calendar`.
- `LocalDate` (date), `LocalTime` (time), `LocalDateTime` (both, no zone), `ZonedDateTime` (with zone), `Instant` (UTC timestamp), `Duration` / `Period`.
- Format with `DateTimeFormatter`. Parse throws `DateTimeParseException`.

## CompletableFuture
- Async result you can compose: `thenApply`, `thenCompose`, `thenCombine`, `allOf`, `exceptionally`.
- `supplyAsync` runs on `ForkJoinPool.commonPool()` unless you pass an `Executor`.
- Q: `thenApply` vs `thenCompose`? Apply maps a value; compose flattens a nested future (like `flatMap`).

## Core / Advanced also in Java 8 (interview)
- `Base64` encoder/decoder (basic + URL).
- `Math.addExact` / `multiplyExact` / `toIntExact` / `floorDiv` / `floorMod` — overflow throws.
- `ConcurrentHashMap` parallel `forEach` / `reduce` / `search` + `compute*`.
- `LongAdder` — cheaper counters than `AtomicLong` under contention.
- `Arrays.parallelSort` / `parallelPrefix` / `setAll`.
- JDBC 4.2 ↔ `java.time`: `Date.valueOf(LocalDate)`, `rs.getObject(i, LocalDate.class)`.
- `Predicate.and/or/negate`, `Function.andThen/compose`.
- `OptionalInt` / `OptionalLong` / `OptionalDouble`.
- `BufferedReader.lines()`, `Pattern.splitAsStream`.
- `ThreadLocal.withInitial(supplier)`.
- `SecureRandom.getInstanceStrong()`.

## Not demoed (JDK internals / rarely asked)
- `java.lang.invoke` metafactory, zip/Adler internals, most `java.security.cert` SPI, Swing/AWT, every `Arrays` overload (~50). The JDK 8 delta is ~700 members; this package covers what interviews actually probe.
