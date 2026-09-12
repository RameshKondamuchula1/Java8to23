# Java 14 — Interview Notes

## Switch Expressions (standard)
- Switch can be an **expression** (returns a value).
- Arrow arms: `case "PAID" -> "Ship now";` — no fall-through.
- Block arms use `yield value;`.
- Must be **exhaustive** for enums / sealed types (later versions).
- Q: `break` vs `yield`? `break` exits a statement switch; `yield` produces the expression result.

## Helpful NullPointerExceptions
- JVM tells you **which** variable was null: `customer.address.zip`.
- No code change. Mention it; the example triggers one.

## Records (preview)
- Preview here; **standard in Java 16**. See `com.java16`.

## Pattern Matching for `instanceof` (preview)
- Preview here; **standard in Java 16**. See `com.java16`.
