# Java 26 — Interview Notes

March 2026. Not an LTS (next LTS is 29). Small language surface; HTTP/3 is the headline API.

## String case-fold (Unicode)
- `equalsFoldCase`, `compareToFoldCase`, `UNICODE_CASEFOLD_ORDER`.
- Stronger than `equalsIgnoreCase` for locale-independent matching (`İ` / `ß` / `ss`).

## List.ofLazy / Map.ofLazy (preview)
- Lazy-filled list/map; see `LazyConstants`. Same preview family as `LazyConstant`.

## HTTP/3 for HttpClient (standard)
- New `HttpClient.Version.HTTP_3`. **Opt-in** — default is still HTTP/2.
- Set on the client or a single request: `.version(HttpClient.Version.HTTP_3)`.
- Uses QUIC/UDP. If the server has no HTTP/3, the client **falls back** to HTTP/2 then HTTP/1.1 unless you force URI-only discovery.
- Interview: same `send` / `sendAsync` API as Java 11; only the version enum is new.

## Structured Concurrency (sixth preview)
- Treat related forks as **one unit**: cancel siblings on failure, one join, clear lifetime.
- Java 25+ style: `try (var scope = StructuredTaskScope.open()) { scope.fork(...); scope.join(); }`.
- Joiners: `allSuccessfulOrThrow`, `anySuccessfulOrThrow` (race), `awaitAll`.
- Still preview — know the idea; don’t memorize every rename.
- Q: vs `CompletableFuture.allOf`? Structured scope cancels leftovers and ties threads to a block.

## Lazy Constants (second preview)
- `LazyConstant.of(supplier)` — compute once on first `get()`, then immutable (JVM can constant-fold).
- Preview in 25 as “Stable Values”, renamed here.
- Also `List.ofLazy(size, index -> ...)`, `Map.ofLazy(keys, key -> ...)`.
- Q: vs holder / double-check lock? Thread-safe, at-most-once, and still looks like a constant to the JIT.

## Primitive Types in Patterns (fourth preview)
- Still preview. `switch (qty) { case 0 -> …; case int n when n < 5 -> … }`.
- See `com.java23.PrimitivePatterns` — the coding shape has not changed.

## Other interview mentions
- **Prepare to Make Final Mean Final** — mutating `final` via reflection will warn (later it will fail).
- Applet API **removed**.
- AOT object caching, G1 sync tweaks — JVM, not coding.
- PEM encodings still preview. Vector API still incubator.
