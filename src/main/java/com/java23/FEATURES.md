# Java 23 — Interview Notes

## Markdown Documentation Comments
- Javadoc can use `///` Markdown instead of `/** … */` HTML.
- Lists, bold, code spans render in the generated docs. Good to mention; not a runtime feature.

## Stream Gatherers (second preview, **standard in 24**)
- Intermediate custom operations on streams.
- Built-ins worth naming: `Gatherers.windowFixed(n)`, `windowSliding(n)`, `fold`, `scan`, `mapConcurrent`.
- Preview here. Production story in `com.java24`.

## Primitive Types in Patterns (preview)
- `instanceof` / `switch` can match primitives: `case int qty when qty == 0`.
- Avoids boxing just to pattern-match a count or flag.

## Module Import Declarations (preview, **standard in 25**)
- `import module java.base;` imports every exported package of that module.
- Cuts import lists in scripts / small programs. See `com.java25`.

## Flexible Constructor Bodies (preview, **standard in 25**)
- Statements allowed before `super(...)` / `this(...)` if they do not use the unfinished instance.
- Typical use: validate arguments, prepare values, then call the parent. See `com.java25`.

## Still preview here (later versions)
- Class-File API → standard in **24**
- Scoped Values, instance main, KDF → standard in **25**
- Structured Concurrency, Lazy Constants → still preview in **26**

## Removed
- String Templates (preview in 21–22) did **not** ship. Do not cite them as a 23 feature.
