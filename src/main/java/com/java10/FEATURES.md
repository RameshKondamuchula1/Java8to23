# Java 10 — Interview Notes

## Local-Variable Type Inference (`var`)
- Compiler infers the type from the **right-hand side**. Still statically typed.
- Allowed for local variables, indexes in enhanced-for, try-with-resources.
- **Not** for fields, method params, return types.
- Use when the type is obvious (`var orders = new ArrayList<Order>()`). Avoid `var data = service.get()` if the type is unclear.
- Q: Is `var` dynamic like JS? No. Type is fixed at compile time.

## Unmodifiable Copies
- `List.copyOf`, `Set.copyOf`, `Map.copyOf` — defensive copy; already-unmodifiable inputs may be reused.
- `Collectors.toUnmodifiableList/Set/Map` — collect a stream into an immutable result.
- Rejects `null`. Mutation throws `UnsupportedOperationException`.

## Optional.orElseThrow()
- No-arg `orElseThrow()` throws `NoSuchElementException` if empty.
- Preferred over `get()` in interviews — intent is explicit.
