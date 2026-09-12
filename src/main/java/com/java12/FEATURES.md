# Java 12 — Interview Notes

## Collectors.teeing
- Runs **two collectors** on the same stream, then merges the results with a `BiFunction`.
- Typical use: average + count, min + max, sum + list in one pass.

## String Constable (rarely asked)
- `describeConstable()` / `resolveConstantDesc(...)` — constant-API hooks, not business code.

## String.indent / transform
- `indent(n)` — add/remove leading spaces (useful for receipts, logs).
- `transform(Function)` — apply a function to the string and return the result.

## Compact Number Formatting
- `NumberFormat.getCompactNumberInstance(locale, style)` → `12K`, `1M`.
- Good for dashboards, not for exact money.

## Files.mismatch
- Returns the first byte index where two files differ, or `-1L` if identical.
- Handy for comparing exported reports / invoice PDFs.

## Switch Expressions (preview)
- Preview here; **standard in Java 14**. See `com.java14`.
