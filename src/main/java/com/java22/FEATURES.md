# Java 22 — Interview Notes

## Unnamed Variables and Patterns (standard)
- `_` means “I must declare this but I do not use it”.
- Works in catch, lambdas, loops, record/type patterns: `case Card(_, var last4)`.
- A name cannot be `_` if you then read it.

## Foreign Function & Memory API (standard)
- `Arena`, `MemorySegment`, `Linker`, `FunctionDescriptor` — call C and work with off-heap memory without JNI.
- Interview: know *why* (safe off-heap, no JNI glue). Deep `Linker` code is rare in business apps.

## Stream Gatherers (preview)
- Custom intermediate stream operations. Built-ins: `windowFixed`, `windowSliding`, `fold`, `scan`, `mapConcurrent`.
- Still preview in 23. See `com.java23.StreamGatherers`.

## Statements before `super()` (preview)
- Validate args, then call `super(...)`. Second preview in 23 as **Flexible Constructor Bodies**.
- See `com.java23.FlexibleConstructors`.

## Other
- Multi-file source-code programs: `java *.java` without compiling first.
- String Templates still preview — **dropped in 23**, skip.
