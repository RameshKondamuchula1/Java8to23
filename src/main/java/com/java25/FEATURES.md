# Java 25 — Interview Notes

September 2025. **LTS** after 21. If they ask “what’s new after 21?”, start here.

## Scoped Values (standard)
- Immutable value visible to a call tree for the duration of `where(...).run/call`.
- `ScopedValue.newInstance()` + `ScopedValue.where(KEY, value).run(() -> ...)`.
- Better fit for virtual threads than `ThreadLocal`: bounded lifetime, no leftover state, cheaper inherit.
- Value cannot be mutated in-place. Re-bind with a nested `where`.
- Q: vs ThreadLocal? ThreadLocal is mutable and lives until `remove()`. Scoped value ends when the `run`/`call` exits.

## Module Import Declarations (standard)
- `import module java.base;` brings in every exported package of that module.
- Name clash (`Date` in `java.base` and `java.sql`): add an explicit `import java.util.Date` (or `import java.util.*`).
- Works on the classpath — you do **not** need `module-info.java`.

## Compact Source Files & Instance Main Methods (standard)
- Compact file: no class/package; compiler invents a hidden class. `java.base` is imported automatically.
- `void main()` is enough — no `public`, `static`, or `args` required.
- `java.lang.IO` — `IO.println`, `IO.print`, `IO.readln` (no `System.out`).
- Aimed at scripts and teaching. Production services still use normal classes.

## Flexible Constructor Bodies (standard)
- Statements allowed **before** `super(...)` / `this(...)` if they do not touch the unfinished instance.
- Typical: validate arguments, normalize strings, then call the parent.

## Key Derivation Function API (standard)
- `javax.crypto.KDF` — derive child keys from IKM + salt + info (HKDF-SHA256, etc.).
- `deriveKey("AES", spec)` or `deriveData(spec)`.
- Interview: one master secret → many purpose-specific keys (token signing, field encryption).

## Reader.readAllAsString / readAllLines
- Slurp a `Reader` in one call (configs, small CSV). Complements `Files.readString` (11).

## Math exact arithmetic
- `powExact`, `unsignedPowExact`, `unsignedMultiplyExact` — throw `ArithmeticException` on overflow.

## Other
- Compact object headers, generational Shenandoah, AOT ergonomics — JVM, not coding.
- Primitive patterns, Structured Concurrency, PEM still preview.
- Stable Values were preview here; renamed to **Lazy Constants** in 26.
