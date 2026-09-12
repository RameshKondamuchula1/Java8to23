# Java 17 — Interview Notes

Current long-term support release many companies still run.

## Sealed Classes (standard)
- Restricts which types may extend/implement you: `sealed interface Payment permits Card, Upi, Wallet`.
- Permitted types must be `final`, `sealed`, or `non-sealed`.
- Enables exhaustive `switch` (Java 21) — compiler knows the full hierarchy.
- Q: Why? Domain modeling (closed payment types) + safer pattern matching.

## Enhanced Pseudo-Random Number Generators
- `RandomGenerator` / `RandomGeneratorFactory` — `L64X128MixRandom`, `Xoshiro256PlusPlus`, etc.
- Use instead of `new Random()` when you care about algorithm choice or streams of numbers.

## Pattern Matching for switch (preview)
- Preview here; **standard in Java 21**. See `com.java21`.

## Map.Entry.copyOf
- `Map.Entry.copyOf(entry)` — unmodifiable snapshot of a live entry (safe to keep after the map changes).

## HexFormat
- `HexFormat.of().formatHex(bytes)` / `parseHex` / `toHexDigits` — standard hex encode/decode (tokens, fingerprints).

## InstantSource
- Clock-without-zone: `clock.instant()`. Inject in tests with `InstantSource.fixed(...)`.

## Process readers/writers
- `Process.inputReader()`, `errorReader()`, `outputWriter()` — charset-aware wrappers around the child streams.

## Sealed reflection
- `Class.isSealed()`, `Class.getPermittedSubclasses()`.

## ObjectInputFilter
- Allow-list filter on `ObjectInputStream` (`Config.createFilter("com.retail.**;!*")`) — blocks gadget deserialization.

## Other interview mentions
- Strong encapsulation of JDK internals (`--add-opens` needed for old hacks).
- Security Manager deprecated for removal.
- New macOS rendering pipeline — not a coding question.
