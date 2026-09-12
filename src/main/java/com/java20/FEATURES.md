# Java 20 — Interview Notes

Almost no new *standard* language features. 20 is a preview-polish release.

## What interviewers expect
- Virtual Threads — second preview (standard in **21**).
- Record Patterns — second preview (standard in **21**).
- Pattern Matching for switch — fourth preview (standard in **21**).
- Scoped Values — incubator; later preview. Thread-local alternative that is immutable and bounded in lifetime.
- Structured Concurrency — still incubator.
- FFM API — second preview (standard in **22**).

## Scoped Values (idea)
- `ScopedValue` = a value visible to a call tree for the duration of a `run` / `call` binding.
- Safer than `ThreadLocal` for virtual threads (no leftover state, cheaper).
- Still preview in 23 — mention the concept, do not memorize every method name.

See `com.java21` and `com.java22` for the APIs that actually shipped.
