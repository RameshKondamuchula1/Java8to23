# Java 8 to 26 — Interview Prep

Maven project with **concise, business-driven coding examples** for features introduced from Java 8 through Java 26.

Each version lives in its own package (`com.java8` … `com.java26`).  
Theory and interview notes are in `FEATURES.md` inside that package. Java files contain **code only**.

Interviewers almost always stay on **LTS**: **8, 11, 17, 21, 25**. Start there. Non-LTS packages are for “what shipped in between.”

Each LTS package covers **Core + Advanced Java that interviews ask** (lang, util, concurrent, io/nio, time, net.http, sql/JDBC, security basics). It does **not** clone every JDK `@since` member (Java 8 alone adds ~700, including invoke/zip/cert SPI).

## Requirements

- JDK 26
- Maven 3.9+

Preview APIs (Structured Concurrency, Lazy Constants) need `--enable-preview`. The POM already enables it.

Point IntelliJ at a JDK 26 SDK (Project Settings → SDK). This repo was started on 23; 24–26 examples need 26 to compile.

## Build

```bash
mvn -q compile
```

## Run one example

```bash
mvn -q exec:java -Dexec.mainClass="com.java8.StreamApi"
```

Or run the `main` method of any class from your IDE.  
`com.java25.InstanceMainMethods` uses an instance `void main()` — run it with `java`, not `exec:java`.

## Package map

| Package | What to revise |
|---|---|
| `com.java8` **LTS** | Lambda, **full Stream surface**, Collectors, Optional, Collection/Map defaults, `String.join` |
| `com.java9` | Factory methods, private interface methods, Stream/Optional upgrades |
| `com.java10` | `var`, unmodifiable copies |
| `com.java11` **LTS** | HTTP Client, String/Files helpers, `Predicate.not`, `Path.of`, null I/O, `Pattern.asMatchPredicate` |
| `com.java12` | `Collectors.teeing`, String `indent`/`transform` |
| `com.java13` | Text Blocks (preview here, standard in 15) |
| `com.java14` | Switch expressions, helpful NPEs |
| `com.java15` | Text Blocks (standard), hidden-class notes |
| `com.java16` | Records, `instanceof` pattern matching, `Stream.toList()` |
| `com.java17` **LTS** | Sealed classes, `RandomGenerator`, `HexFormat`, `InstantSource`, `Process.inputReader` |
| `com.java18` | UTF-8 default, Simple Web Server |
| `com.java19` | Virtual Threads (preview; standard in 21) |
| `com.java20` | Record Patterns / scoped values (preview notes) |
| `com.java21` **LTS** | Virtual Threads, Sequenced Collections, record & switch patterns, `Math.clamp`, `splitWithDelimiters`, emoji |
| `com.java22` | Unnamed variables, FFM API |
| `com.java23` | Markdown JavaDoc, Gatherers / module import / flexible constructors (preview) |
| `com.java24` | Stream Gatherers (standard), Class-File API |
| `com.java25` **LTS** | Scoped Values, module import, instance main, flexible constructors, KDF, `Reader.readAll*`, `Math.powExact` |
| `com.java26` | HTTP/3, Structured Concurrency (preview), Lazy Constants (preview) |
