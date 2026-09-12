# Java 19 — Interview Notes

Most 19 features were **preview**. Remember “this is where virtual threads appeared”.

## Virtual Threads (preview, standard in 21)
- Lightweight threads scheduled by the JVM onto a pool of carrier platform threads.
- Designed for **high-concurrency I/O** (one thread per request again).
- `Thread.startVirtualThread(runnable)` / `Thread.ofVirtual().start(...)`.
- Do not pool virtual threads. Avoid long `synchronized` / native pins if you can.
- Full example in this package; production story in `com.java21`.

## Record Patterns (preview, standard in 21)
- Deconstruct a record in `instanceof` / `switch`: `if (obj instanceof Order(var id, var amt))`.
- See `com.java21.RecordPatterns`.

## Structured Concurrency (incubator)
- Treat a group of related tasks as one unit (cancel the rest on failure).
- Still evolving in 21–23 as preview. Know the idea, not every API rename.

## HashMap / HashSet factories
- `HashMap.newHashMap(expectedMappings)` sized from **mappings**, not raw capacity (load factor handled).
- Same idea: `HashSet.newHashSet`, `LinkedHashMap.newLinkedHashMap`, `LinkedHashSet.newLinkedHashSet`.
- Prefer these over `new HashMap<>(expected * 2)` guesses.

## Objects.toIdentityString
- Identity string (`Class@hex`) without calling an overridden `toString`. Handy in logs.

## Locale.of
- `Locale.of("en", "IN")` replaces the `new Locale(...)` constructors (later deprecated).

## Other
- Foreign Function & Memory API still preview (standard in 22).
- Vector API incubator.
