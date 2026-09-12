# Java 13 — Interview Notes

Thin release for interviews. Remember it as the **Text Blocks preview** release.

## Text Blocks (preview, standard in 15)
- Multi-line string delimited by `"""`.
- Preserves line breaks. Closing `"""` position controls incidental indentation.
- Escape: `\s` (space), `\` at line end (join lines).
- Best for JSON payloads, SQL, HTML emails. See the example in this package; finalized notes in `com.java15`.

## Switch `yield` (preview)
- Preview piece of switch expressions. Standard in Java 14.
- `yield` returns a value from a block arm. See `com.java14.SwitchExpressions`.

## Other
- Socket API reimplementation, dynamic CDS archives — JVM/ops, not coding questions.
