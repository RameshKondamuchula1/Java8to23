# Java 11 — Interview Notes

Second LTS after 8. Many production codebases jumped 8 → 11.

## HTTP Client (standard)
- `java.net.http.HttpClient` — async/sync HTTP/1.1 and HTTP/2. Replaces `HttpURLConnection`.
- Immutable `HttpRequest`, `HttpResponse<T>` with body handlers (`ofString`, `ofFile`).
- `send` (blocking) vs `sendAsync` (CompletableFuture).

## String Methods
- `isBlank()` — empty or whitespace (unlike `isEmpty()`).
- `lines()` — stream of lines.
- `strip()` / `stripLeading()` / `stripTrailing()` — Unicode-aware trim.
- `repeat(n)` — repeat the string.

## Collection.toArray(IntFunction)
- `list.toArray(String[]::new)` — typed array without the `new String[0]` dance.

## Path.of
- `Path.of("a", "b")` replaces `Paths.get(...)`.

## Files.readString / writeString
- Read or write a whole file as one `String`. Small files only (configs, templates).

## Optional.isEmpty()
- Opposite of `isPresent()`. Reads better in `if (id.isEmpty())`.

## Predicate.not
- `Predicate.not(String::isBlank)` — negate a method reference cleanly.

## `var` in Lambda Parameters
- `(var name, var city) -> ...` — mainly so you can put annotations on lambda params.

## Pattern.asMatchPredicate
- `pattern.asMatchPredicate()` — whole-string match as a `Predicate<String>` (vs `asPredicate()` which is find/contains).

## Null I/O + InputStream.readNBytes
- `InputStream.nullInputStream()`, `OutputStream.nullOutputStream()`, `Reader.nullReader()`, `Writer.nullWriter()` — empty sources / discard sinks (tests).
- `readNBytes(len)` — read at most `len` bytes.

## I/O charset + compare
- `FileReader` / `FileWriter` now take `Charset`.
- `ByteArrayOutputStream.writeBytes(byte[])`.
- `CharSequence.compare`.
- `TimeUnit.convert(Duration)`.

## Other interview mentions
- Single-file source programs: `java Hello.java`.
- Java EE / CORBA modules removed from the JDK.
- Nest-based access control (compiler/JVM detail; rarely coded by hand).
