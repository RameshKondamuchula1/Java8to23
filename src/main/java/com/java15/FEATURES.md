# Java 15 — Interview Notes

## Text Blocks (standard)
- Same `"""` syntax previewed in 13/14, now production-ready.
- Interview points: incidental indentation, `\s`, line-continuation `\`.
- Prefer text blocks over concatenated `+` strings for JSON/SQL.

## Sealed Classes (preview)
- Preview here; **standard in Java 17**. See `com.java17`.

## Hidden Classes
- Classes not discoverable by name, meant for frameworks (lambdas, proxies).
- Not something you write in business code.

## String methods (with Text Blocks)
- `formatted(args…)` — instance `String.format`. `"Hello %s".formatted(name)`.
- `stripIndent()` — drop incidental indentation from a multi-line string.
- `translateEscapes()` — turn `\n`, `\t` in the *contents* into real characters.
- `CharSequence.isEmpty()` added on the interface (String already had it).

## Other
- Nashorn JS engine removed. Edwards-curve (`EdDSA`) added for crypto.
