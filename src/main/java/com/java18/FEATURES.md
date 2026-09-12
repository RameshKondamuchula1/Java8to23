# Java 18 — Interview Notes

## UTF-8 by Default
- `Charset.defaultCharset()` is UTF-8 unless overridden.
- Stops Windows vs Linux file-encoding bugs. Mention `System.getProperty("file.encoding")`.

## Simple Web Server
- `jwebserver` CLI, or `SimpleFileServer.createFileServer(...)` in code.
- Static files only — fine for sharing a build report, not a real API.

## Other
- Code snippets in Javadoc (`@snippet`).
- Pattern matching for switch still preview (final in 21).
- Finalization deprecated — prefer `Cleaner` / try-with-resources.
