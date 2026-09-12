# Java 24 — Interview Notes

March 2025. Not an LTS. Remember it as the **Stream Gatherers + Class-File API** release.

## Stream Gatherers (standard)
- Custom **intermediate** stream ops. Preview in 22–23, final here — no `--enable-preview`.
- Built-ins: `windowFixed(n)`, `windowSliding(n)`, `fold`, `scan`, `mapConcurrent`.
- `scan` emits running results; `fold` emits one final value (like a collectable reduce).
- Q: vs `Collectors`? Collectors are **terminal**. Gatherers stay in the pipeline.

## Class-File API (standard)
- `java.lang.classfile` — parse / generate / transform `.class` bytes. Replaces ad-hoc ASM for JDK tools.
- Entry: `ClassFile.of().parse(bytes)` → `ClassModel` (immutable, lazy).
- Interview: know *why* (JDK can evolve class-file format without breaking ASM versions). You rarely write this in a CRUD service.

## Virtual Threads without Pinning (JEP 491)
- `synchronized` no longer pins a virtual thread to its carrier.
- Pinning remains for native frames / some JNI. Still avoid long CPU work on virtual threads.

## Other interview mentions
- Security Manager is **permanently disabled** (API goes away later).
- AOT class loading & linking — startup, not a coding question.
- KDF, scoped values, module import, flexible constructors, primitive patterns still **preview** (see 25).
- Quantum-resistant ML-KEM / ML-DSA added to the JDK crypto set.
