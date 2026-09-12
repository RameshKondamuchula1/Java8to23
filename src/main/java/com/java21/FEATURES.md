# Java 21 — Interview Notes

Latest LTS. If they ask “what’s new after 17?”, start here.

## Thread builders
- `Thread.ofVirtual()` / `Thread.ofPlatform()` / `Thread.startVirtualThread(runnable)`.

## Virtual Threads (standard)
- Cheap threads: millions can exist; they unmount from the carrier during blocking I/O.
- `Executors.newVirtualThreadPerTaskExecutor()` or `Thread.ofVirtual().start(...)`.
- Best for I/O-bound request handling. Not faster CPU work.
- Don’t pool them. Watch pinning: long `synchronized` or native calls keep the carrier stuck.
- Q: vs platform threads? Platform = 1:1 OS thread. Virtual = many-to-few, JVM-scheduled.

## Sequenced Collections
- New interfaces: `SequencedCollection`, `SequencedSet`, `SequencedMap`.
- Collection: `getFirst()`, `getLast()`, `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`, `reversed()`.
- Map: `firstEntry()`, `lastEntry()`, `pollFirstEntry()`, `pollLastEntry()`, `putFirst()`, `putLast()`.
- Implemented by `List`, `LinkedHashSet`, `LinkedHashMap`, `SortedSet` / `SortedMap`, `Deque`.

## Collections helpers for sequenced types
- `unmodifiableSequencedCollection` / `Set` / `Map`.
- `shuffle(list, RandomGenerator)`.
- `newSequencedSetFromMap(sequencedMap)`.

## String / Math extras
- `String.splitWithDelimiters(regex, limit)` — tokens **and** the separators.
- `String.indexOf(str, begin, end)` — search in a range.
- `StringBuilder.repeat` / `StringBuffer.repeat`.
- `Math.clamp(value, min, max)` — cap qty / discount / score.

## Record Patterns (standard)
- Deconstruct: `case Order(String id, double amount) -> ...`
- Nested patterns allowed. Use `var` or `_` (22) when you don’t care about a component.

## Pattern Matching for switch (standard)
- Switch on type, null, and guards: `case Card c when c.amount() > 10_000`.
- With sealed types, switch can be exhaustive — no `default` needed.
- Q: `when`? Extra boolean guard after the pattern.

## Character emoji + Pattern.splitWithDelimiters
- `Character.isEmoji` / `isEmojiPresentation` / `isEmojiModifier` / `isEmojiModifierBase` / `isEmojiComponent` / `isExtendedPictographic`.
- `Pattern.splitWithDelimiters` — same idea as `String.splitWithDelimiters`.

## Other
- String Templates were preview here and **removed in 23** — don’t use them in answers.
- Unnamed classes / instance main — preview (teaching/scripts).
- Generational ZGC — GC, not coding.
