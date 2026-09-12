# Java 9 — Interview Notes

## Module System (JPMS)
- `module-info.java` declares `module`, `requires`, `exports`, `opens`, `provides` / `uses`.
- Strong encapsulation: packages are hidden unless exported.
- Interview: know the idea; most business apps still use the classpath. Coding example omitted (needs a multi-module layout).

## Collection Factory Methods
- `List.of()`, `Set.of()`, `Map.of()`, `Map.ofEntries()`, `Map.entry(k, v)`.
- Result is **unmodifiable**, **no nulls**, Set/Map reject duplicate keys.
- Q: vs `Arrays.asList`? `asList` is fixed-size but settable; `List.of` is truly immutable.

## Objects
- `requireNonNullElse(value, default)` / `requireNonNullElseGet(value, supplier)`.
- `checkIndex` / `checkFromToIndex` / `checkFromIndexSize` — bounds checks that throw `IndexOutOfBoundsException`.

## Collectors
- `filtering(predicate, downstream)` — filter **inside** a grouping (not before).
- `flatMapping(mapper, downstream)` — flatMap inside a collector.

## String
- `chars()` / `codePoints()` — `IntStream` over the string (also on `CharSequence` since 9).

## I/O & Arrays
- `InputStream.transferTo(OutputStream)`, `readAllBytes()`, `readNBytes(n)`.
- `Arrays.compare`, `Arrays.mismatch`, `Arrays.equals` with ranges.

## Private Interface Methods
- Private instance/static methods to share logic between `default` methods.
- Keeps interfaces clean without leaking helpers to implementers.

## Stream Improvements
- `takeWhile` — keep until predicate fails (ordered prefix).
- `dropWhile` — skip until predicate fails, then keep the rest.
- `iterate(seed, hasNext, next)` — finite iterate (old `iterate` was infinite).
- `Stream.ofNullable(x)` — empty stream if `x` is null.

## Optional Improvements
- `ifPresentOrElse(consumer, runnable)` — handle both present and empty.
- `or(supplier)` — fallback Optional, not a raw value.
- `stream()` — 0 or 1 element; useful with `flatMap`.

## Try-with-resources
- Resource can be created **before** `try` if it is final / effectively final.
- Avoids nesting the constructor inside the `try (...)`.

## Process API
- `ProcessHandle.current()`, `info()`, `onExit()` — inspect / manage OS processes.
- Useful for ops tooling, not typical CRUD apps.

## Diamond Operator
- Diamond `<>` now works with anonymous classes: `new ArrayList<>() { }`.
