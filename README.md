# Core Java 8 → 21 Mastery Roadmap (Enhanced)

> Original roadmap by ChatGPT, reviewed and extended by Claude.
> Phases marked **(NEW)** fill gaps identified in review (missing Testing phase,
> build tools, inner classes, enums, String internals, design patterns,
> logging, serialization, ThreadLocal/Fork-Join). Everything else is the
> original content, kept intact.

```
TOOLING & BUILD
   ↓
FOUNDATIONS (+ inner classes, String internals)
   ↓
OBJECT MODEL + COLLECTIONS + GENERICS + ENUMS
   ↓
JAVA 8 FUNCTIONAL PROGRAMMING
   ↓
STREAM MASTERY
   ↓
OPTIONAL + DATE/TIME + SERIALIZATION + I/O/NIO + LOGGING
   ↓
CONCURRENCY (+ ThreadLocal / Fork-Join)
   ↓
JAVA 9–11
   ↓
JAVA 12–17
   ↓
JAVA 18–21
   ↓
JVM + PERFORMANCE
   ↓
REFLECTION + MODULES + DESIGN PATTERNS + API DESIGN
   ↓
TESTING MASTERY
   ↓
REAL-WORLD REFACTORING / CAPSTONE
   ↓
CORE JAVA MASTERY
```

---

## Phase 0 (NEW) — Tooling & Build Fundamentals
**Duration:** Pre-Week / Week 0

You cannot practice any later phase professionally without this.

1. **JDK & environment**
   - Installing and switching JDK versions (SDKMAN / jenv / manual)
   - `JAVA_HOME`, `PATH`
   - Difference between JDK, JRE, JVM

2. **Build tools**
   - Maven: `pom.xml`, dependencies, scopes, lifecycle (`compile`, `test`,
     `package`, `install`), plugins, multi-module projects
   - Gradle: `build.gradle`, dependency configurations, tasks, wrapper
   - Dependency management: transitive dependencies, version conflicts,
     BOMs

3. **IDE proficiency**
   - Debugger: breakpoints, watches, conditional breakpoints, evaluate
     expression
   - Refactoring tools (rename, extract method, inline)

4. **Version control basics for Java projects**
   - `.gitignore` for Java/Maven/Gradle
   - Branching workflow (feature branch + PR)

---

## Phase 1 — Java Language & Object Model
**Duration:** Week 1

Before Java 8 features, make your Java foundations extremely strong.

### 1. Java syntax
Learn deeply:
Variables, Primitive types, Reference types, Operators, Expressions,
Statements, Control flow, Loops, Arrays, Methods, Parameters, Return
values, varargs

### 2. Primitive vs reference types
Understand: `int`, `long`, `double`, `boolean`, `char`, `byte`, `short`,
`float` versus `Integer`, `Long`, `Double`, `Boolean`, `Character`.
Understand: boxing, unboxing, autoboxing, null.

### 3. Classes and objects
Master: Fields, Constructors, Methods, Instance members, Static members,
Initialization blocks, Object creation, Object references, `this`,
`super`.

### 4. OOP
Deeply understand: Encapsulation, Inheritance, Polymorphism, Abstraction,
Composition, Aggregation, Association.
Especially: **Composition over inheritance.**

### 5. Method dispatch
Understand: compile-time method resolution, runtime method dispatch,
overloading, overriding, dynamic dispatch.

### 6. Object methods
Master: `equals()`, `hashCode()`, `toString()`, `clone()` with special
attention to: equals/hashCode contract, identity vs equality, mutability
and hash-based collections, **deep vs shallow copy**.

### 7. (NEW) Nested, Inner, Local & Anonymous Classes
A very common interview topic that is easy to skip if you only study
top-level classes.
- Static nested classes
- Inner (non-static) classes and their implicit reference to the
  enclosing instance
- Local classes (declared inside a method)
- Anonymous classes
- When an anonymous class is still needed over a lambda (e.g.
  implementing an interface with multiple abstract methods, needing
  `this` to refer to the anonymous instance)
- Variable capture rules (effectively final) — ties back into lambdas in
  Phase 4

### 8. (NEW) String Internals
Another classic interview area that the original roadmap never covers
explicitly.
- String immutability and *why* it exists (security, caching, hashcode
  caching, thread safety)
- The String constant pool, `intern()`
- `new String("x")` vs string literal `"x"`
- `StringBuilder` vs `StringBuffer` (mutability, thread safety, when to
  use which)
- Wrapper class caching (`Integer.valueOf` caches -128..127) and why
  `==` on boxed types is a common bug source
- `String.format`, text blocks (connects forward to Phase 21)

---

## Phase 2 — Interfaces, Abstract Classes & Generics
**Duration:** Week 2

### Interfaces
Learn: Interface, Multiple interface implementation, Default methods,
Static interface methods, Functional interfaces.

### Abstract classes
Understand when `abstract class` is preferable to `interface`.

### Generics
This deserves serious attention. Learn: Generic classes, Generic
methods, Generic interfaces, Type parameters, Bounded types, Wildcards,
`? extends`, `? super`, PECS, Raw types, Type erasure.

You should be able to explain `List<? extends Number>` and
`List<? super Integer>` without memorization.

### Practice
Implement your own: `Repository<T, ID>`, `Pair<K, V>`, `Result<T>`,
`Stack<T>`, `Cache<K, V>`. Then study type erasure.

---

## Phase 2.5 (NEW) — Enums as a Type
**Duration:** a few days, inside Week 2

The original roadmap only mentions `EnumMap` under Collections. `enum`
itself deserves standalone treatment:
- Enum as a full class (fields, constructors, methods)
- Abstract methods per-constant (e.g. `Operation` enum with per-constant
  `apply()` overrides)
- Implementing interfaces with enums
- `values()`, `ordinal()`, `name()`, `valueOf()`
- `EnumSet` and `EnumMap` internals (bit-vector backing)
- The **enum singleton pattern** (`Effective Java` recommended approach
  to Singleton)
- Why `switch` on enums works especially well (ties into Phase 21 switch
  expressions and Phase 22 pattern matching for switch)

---

## Phase 3 — Collections Mastery
**Duration:** Week 3

This is mandatory before becoming a Streams expert.

**List:** ArrayList, LinkedList, CopyOnWriteArrayList — random access,
insertion, deletion, memory layout, complexity.

**Set:** HashSet, LinkedHashSet, TreeSet — hashing, ordering, sorting,
tree structure.

**Map:** HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap,
WeakHashMap, IdentityHashMap, EnumMap.
Go deep into HashMap: `hash()`, bucket, collision, load factor, resize,
treeification, capacity.

**Queue / Deque:** Queue, Deque, PriorityQueue, ArrayDeque,
BlockingQueue.

**Iterator:** Iterator, ListIterator, forEach, remove.

**Comparable / Comparator:** `Comparable<T>`, `Comparator<T>`,
`comparing()`, `thenComparing()`, `reversed()`, `nullsFirst()`,
`nullsLast()`.

---

## Phase 4 — Java 8 Functional Programming
**Duration:** Week 4

### Lambdas
Master `x -> x * 2`. Understand: target typing, closures, effectively
final variables, capturing.

### Functional interfaces
Deeply learn: `Predicate<T>`, `Function<T,R>`, `Consumer<T>`,
`Supplier<T>`, `UnaryOperator<T>`, `BinaryOperator<T>`, `BiFunction`,
`BiPredicate`, `BiConsumer`.

Understand their relationships:
`Predicate → T → boolean`, `Function → T → R`, `Consumer → T → void`,
`Supplier → () → T`.

### Method references
Master: `Class::staticMethod`, `object::instanceMethod`,
`Class::instanceMethod`, `Class::new`. Understand when method references
improve readability versus when lambdas are clearer.

---

## Phase 5 — Stream API Fundamentals
**Duration:** Weeks 5–6

### Understand the Stream model
```
Source
  ↓
Intermediate operations
  ↓
Intermediate operations
  ↓
Terminal operation
```
Learn: stream, pipeline, lazy evaluation, single-use streams.

### Creating streams
Master: `collection.stream()`, `Arrays.stream()`, `Stream.of()`,
`Stream.empty()`, `Stream.generate()`, `Stream.iterate()`,
`Stream.ofNullable()`.

### Intermediate operations
Master: `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`,
`peek()`, `limit()`, `skip()`. Understand exactly what each returns.

---

## Phase 6 — Stream Terminal Operations
**Duration:** Week 7

Master: `forEach`, `forEachOrdered`, `collect`, `reduce`, `count`,
`min`, `max`, `findFirst`, `findAny`, `anyMatch`, `allMatch`,
`noneMatch`.

Understand short-circuiting:
```java
employees.stream()
    .filter(Employee::isActive)
    .findFirst();
```
Don't simply know the syntax. Understand why the pipeline may stop
processing as soon as it finds a match.

---

## Phase 7 — Collectors Mastery
**Duration:** Weeks 8–9

This is probably the most important Stream phase.

Master: `toList()`, `toSet()`, `toMap()`.
Then: `groupingBy()`, `groupingByConcurrent()`, `partitioningBy()`.
Then: `mapping()`, `filtering()`, `flatMapping()`.
Then: `joining()`, `counting()`, `summingInt()`, `summingLong()`,
`averagingInt()`, `averagingDouble()`, `summarizingInt()`,
`summarizingLong()`, `summarizingDouble()`.
Then: `minBy()`, `maxBy()`, `reducing()`, `collectingAndThen()`,
`teeing()`.

### Your progression
Start: `groupingBy(Employee::getDepartment)`
Then:
```java
groupingBy(
    Employee::getDepartment,
    counting()
)
```
Then:
```java
groupingBy(
    Employee::getDepartment,
    averagingDouble(Employee::getSalary)
)
```
Then nested:
```java
groupingBy(
    Employee::getDepartment,
    groupingBy(Employee::getRole)
)
```
You should become comfortable building these without constantly looking
at documentation.

---

## Phase 8 — The Core Stream Concepts
**Duration:** Week 10

Now stop learning operators and learn the theory behind Streams.

Master: Lazy evaluation, Eager vs lazy operations, Stateless operations,
Stateful operations, Short-circuiting, Encounter order, Side effects,
Non-interference, Associativity, Reduction, Mutable reduction, Collector
contract.

Understand `map()`/`filter()` versus `sorted()`/`distinct()` in terms of
state and processing.

Understand why this is problematic:
```java
List<String> result = new ArrayList<>();

names.stream()
    .filter(...)
    .forEach(result::add);
```
and why `.collect(Collectors.toList())` is generally preferable.

---

## Phase 9 — Primitive Streams & Boxing
**Duration:** Week 11

Master: `IntStream`, `LongStream`, `DoubleStream`.
Learn: `mapToInt()`, `mapToLong()`, `mapToDouble()`, `boxed()`, `sum()`,
`average()`, `summaryStatistics()`.

Understand: boxing, unboxing, allocation, primitive specialization.

```java
employees.stream()
    .mapToInt(Employee::getAge)
    .average();
```
versus
```java
employees.stream()
    .map(Employee::getAge)
    .collect(...);
```
Understand when the primitive stream is beneficial.

---

## Phase 10 — map() vs flatMap() Deep Dive
**Duration:** Week 12

Spend significant time here.

Learn: one → one, one → many, many → one.

Understand `map()`/`flatMap()` with `List<List<T>>`, `List<Optional<T>>`,
nested domain structures.

Then connect this concept to `Optional.flatMap()` and
`CompletableFuture.thenCompose()`. This creates a much deeper
understanding of functional composition.

---

## Phase 11 — Optional
**Duration:** Week 13

Master: `of()`, `ofNullable()`, `empty()`, `isPresent()`, `isEmpty()`,
`ifPresent()`, `ifPresentOrElse()`, `map()`, `flatMap()`, `filter()`,
`or()`, `orElse()`, `orElseGet()`, `orElseThrow()`.

Deeply understand: `orElse` vs `orElseGet`, `map` vs `flatMap`, Optional
as return type, Optional anti-patterns, Optional fields, Optional
parameters.

Practice converting null-heavy code into cleaner implementations.

---

## Phase 12 — Modern Date/Time API
**Duration:** Week 14

Master: `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`,
`Instant`, `Duration`, `Period`, `ZoneId`, `ZoneOffset`,
`DateTimeFormatter`.

Understand: machine time vs human time, time zones, UTC, DST,
immutability. This is especially important for backend systems.

---

## Phase 13 — Exceptions & Modern Error Handling
**Duration:** Week 15

Master: checked exceptions, unchecked exceptions, `Error`, `Exception`,
`RuntimeException`, custom exceptions, try/catch/finally,
try-with-resources, multi-catch, exception chaining, suppressed
exceptions.

Then learn how to design good APIs around errors. Understand why
`catch (Exception e)` can be problematic.

---

## Phase 13.5 (NEW) — Serialization & Object Copying
**Duration:** a few days

Absent from the original roadmap, yet relevant every time you touch
Jackson/Hibernate (both referenced later in Phase 26).

- `Serializable` marker interface, `serialVersionUID`
- `transient` fields
- Custom `writeObject`/`readObject` (just enough to recognize the
  pattern, not to rely on it)
- Why native Java serialization is largely avoided in modern systems
  (security, versioning fragility)
- Deep copy vs shallow copy, revisited from `clone()` in Phase 1 —
  implement a deep-copying copy constructor
- Brief contrast with JSON-based "serialization" via Jackson (full
  Jackson usage is out of scope for *core* Java, but understanding the
  distinction is not)

---

## Phase 14 — I/O and NIO
**Duration:** Week 16

Master: `File`, `Path`, `Files`, `DirectoryStream`, `InputStream`,
`OutputStream`, `Reader`, `Writer`, `BufferedReader`, `BufferedWriter`.
Then: `Files.lines()`, `Files.readString()`, `Files.writeString()`.

Understand: blocking I/O, buffering, resource management,
try-with-resources.

Build a: log analyzer, CSV processor, file statistics tool — using
Streams.

---

## Phase 14.5 (NEW) — Logging
**Duration:** a few days

Not glamorous, but every production Java application depends on it, and
it's absent from the original roadmap entirely.
- SLF4J as a facade, Logback/Log4j2 as implementations
- Log levels (TRACE/DEBUG/INFO/WARN/ERROR) and when to use each
- Parameterized logging (`log.info("user {} logged in", userId)`) vs
  string concatenation — performance reasoning (lazy evaluation of
  arguments)
- Structured/JSON logging basics (useful context for centralized log
  aggregation in real backends)
- MDC (Mapped Diagnostic Context) for request tracing

---

## Phase 15 — Java Concurrency Fundamentals
**Duration:** Weeks 17–18

Now shift from functional programming to concurrency.

Learn: `Thread`, `Runnable`, `Callable`, `Future`, `Executor`,
`ExecutorService`, `ScheduledExecutorService`.

Understand: process vs thread, thread lifecycle, context switching,
CPU-bound vs I/O-bound.

Then: race condition, atomicity, visibility, ordering.

---

## Phase 16 — Java Memory Model
**Duration:** Week 19

This is where your Java understanding becomes much deeper.

Learn: Heap, Stack, Threads, Memory visibility, happens-before,
`volatile`, `synchronized`, safe publication, immutability.

Then: `AtomicInteger`, `AtomicLong`, `AtomicReference`, CAS.

Understand why `counter++;` isn't atomic.

---

## Phase 17 — Locks and Synchronization
**Duration:** Week 20

Master: `synchronized`, `ReentrantLock`, `ReadWriteLock`,
`ReentrantReadWriteLock`, `StampedLock`, `Condition`, `Semaphore`,
`CountDownLatch`, `CyclicBarrier`, `Phaser`.

Understand: deadlock, livelock, starvation, lock contention, fairness.

Build concurrent examples and deliberately create race conditions. Then
fix them.

---

## Phase 18 — Concurrent Collections
**Duration:** Week 21

Master: `ConcurrentHashMap`, `CopyOnWriteArrayList`, `BlockingQueue`,
`ConcurrentLinkedQueue`.

Understand how they differ from ordinary collections. Especially
`ConcurrentHashMap` — go deep into `compute()`, `computeIfAbsent()`,
`computeIfPresent()`, `merge()`, `putIfAbsent()`. This becomes very
useful in real backend development.

---

## Phase 18.5 (NEW) — ThreadLocal & Fork/Join Framework
**Duration:** a few days

Two concurrency building blocks the original roadmap skips despite
being otherwise thorough on concurrency.

- `ThreadLocal<T>` and `InheritableThreadLocal` — per-thread state,
  common use cases (request context, `SimpleDateFormat` historically),
  and the **memory leak risk** in pooled-thread environments if you
  forget `remove()`
- `ForkJoinPool`, `RecursiveTask`, `RecursiveAction` — divide-and-conquer
  parallelism
- How `parallelStream()` actually uses the common `ForkJoinPool` under
  the hood — ties directly back into Phase 5–9 Stream knowledge and
  Phase 23 virtual threads (why blocking in `parallelStream()` is
  dangerous — it starves the shared pool)

---

## Phase 19 — CompletableFuture
**Duration:** Week 22

Master: `CompletableFuture`, `CompletionStage`.

Learn: `supplyAsync()`, `runAsync()`, `thenApply()`, `thenCompose()`,
`thenAccept()`, `thenRun()`, `thenCombine()`, `allOf()`, `anyOf()`,
`exceptionally()`, `handle()`, `whenComplete()`.

Understand: map-like transformation, flatMap-like composition, async
pipeline, thread pools, exception propagation.

Connect this back to your `flatMap()` learning.

---

## Phase 20 — Java 9 → 11
**Duration:** Week 23

**Java 9:** Module System, JShell, private interface methods,
`takeWhile()`, `dropWhile()`, `iterate()`, `Optional.or()`.

**Java 10:** `var`.

**Java 11:** `String.isBlank()`, `String.lines()`, `String.strip()`,
`String.repeat()`, `Files.readString()`, `Files.writeString()`,
`Predicate.not()`. Also learn the Java 11 HTTP Client.

---

## Phase 21 — Java 12 → 17
**Duration:** Week 24

Focus on modern syntax and type modeling.

Master: switch expressions, text blocks, pattern matching for
`instanceof`, records, sealed classes, sealed interfaces, pattern
matching.

Then practice converting old Java code:
```java
if (obj instanceof Employee) {
    Employee e = (Employee) obj;
}
```
into modern Java. Do this constantly.

---

## Phase 22 — Java 18 → 21
**Duration:** Weeks 25–26

I know this stretches the original 24-week target, but I would not rush
this phase.

Master Java 21 features, including: Virtual Threads, Record Patterns,
Pattern Matching for switch, Sequenced Collections. And understand the
Java 21 status of: Structured Concurrency, Scoped Values, where
applicable.

---

## Phase 23 — Virtual Threads
**Duration:** Week 27

Since you're interested in backend and Quarkus, I'd give this its own
phase.

Understand: platform thread, virtual thread, carrier thread, scheduler,
blocking operations, I/O, thread-per-request.

Practice: `Executors.newVirtualThreadPerTaskExecutor()` compared against
`Executors.newFixedThreadPool(...)`. Then benchmark I/O-heavy workloads.

Don't just memorize that virtual threads are "faster." Understand why
they can improve scalability for workloads that spend significant time
blocked on I/O.

---

## Phase 24 — JVM Internals
**Duration:** Weeks 28–29

Now move below the Java language.

Learn: JVM architecture, Class loading, Bytecode, JIT, Interpreter,
HotSpot, Heap, Stack, Metaspace, Code cache, GC.

Understand: `-Xms`, `-Xmx`, `-Xss` and major GC concepts.

Then: G1, ZGC. Understand at a high level how collectors behave.

---

## Phase 25 — Java Performance
**Duration:** Week 30

Learn: Big-O, allocation, boxing, object creation, memory pressure, GC
pressure, cache locality, I/O cost, locking, contention.

Then tools: JMH, JFR, jstack, jmap, jcmd, VisualVM, async-profiler.

Benchmark things rather than guessing. For example: for-loop vs Stream,
ArrayList vs LinkedList, HashMap vs TreeMap, synchronized vs lock,
platform threads vs virtual threads.

This is where you learn that performance claims should be measured, not
assumed.

---

## Phase 26 — Reflection & Annotations
**Duration:** Week 31

Learn: Reflection API, `Class`, `Method`, `Field`, `Constructor`,
Annotations, `Retention`, `Target`, Runtime annotations.

Understand how frameworks such as Quarkus, Hibernate, JUnit, CDI,
Jackson use metadata. This will help enormously with your Quarkus work.

---

## Phase 27 — Java Modules & Packaging
**Duration:** Week 32

Learn: JAR, MANIFEST, classpath, module path, JPMS, `module-info.java`,
`exports`, `requires`, `opens`.

Understand the difference between classpath and module path, and why
modern frameworks sometimes interact with these concepts differently.

---

## Phase 27.5 (NEW) — Design Patterns Deep Dive
**Duration:** Week 32.5

The original roadmap mentions "builder patterns, factory methods" as a
bullet inside Phase 28, but a 10-year-level developer needs to actually
*recognize and apply* the standard catalog, not just name two of them.

**Creational:** Singleton (and why enum singleton is preferred), Factory
Method, Abstract Factory, Builder, Prototype.

**Structural:** Adapter, Decorator, Proxy (ties into reflection/dynamic
proxies from Phase 26), Facade, Composite.

**Behavioral:** Strategy, Observer, Template Method, Command,
Chain of Responsibility, Iterator (you've already used Java's own, now
see how it's implemented), State.

For each pattern: implement it from scratch once, then find a real
example of it already in the JDK or a framework you use (e.g.
`Comparator` = Strategy, `InputStream` wrapping = Decorator,
`Collections.unmodifiableList` = Proxy-ish wrapper).

---

## Phase 28 — Advanced API Design
**Duration:** Week 33

Now practice writing good Java APIs.

Learn: immutability, defensive copying, builder patterns, factory
methods, value objects, records, sealed types, nullability, Optional,
generic API design, fluent APIs.

Study: Effective Java principles, SOLID, composition, encapsulation,
dependency inversion. But apply them rather than memorizing definitions.

---

## Phase 29 (RESTORED / NEW) — Testing Mastery
**Duration:** Weeks 34–35

This phase was missing from the original roadmap (the numbering jumped
from 28 straight to 30) and is arguably the single biggest gap for
someone targeting senior-level, production-grade Java. You cannot claim
10-years-equivalent Java knowledge without fluency here.

### JUnit 5
- `@Test`, `@BeforeEach`/`@AfterEach`, `@BeforeAll`/`@AfterAll`
- `@ParameterizedTest` with `@ValueSource`, `@CsvSource`, `@MethodSource`
- `@Nested` test classes for grouping
- `@Tag`, `@Disabled`, assumptions
- Assertions: `assertEquals`, `assertThrows`, `assertAll` (soft
  assertions)

### Mockito
- `mock()`, `when().thenReturn()`, `verify()`
- Argument matchers (`any()`, `eq()`)
- `@Mock`, `@InjectMocks`, `@ExtendWith(MockitoExtension.class)`
- Spies vs mocks
- Capturing arguments with `ArgumentCaptor`

### AssertJ
- Fluent assertions (`assertThat(x).isEqualTo(...)`)
- Why it's generally preferred over raw JUnit assertions for
  readability

### Test design principles
- Unit vs integration vs end-to-end tests
- Test pyramid
- Arrange-Act-Assert structure
- Test doubles: dummy, stub, fake, spy, mock — know the difference
- Writing deterministic tests around `java.time` (inject `Clock` instead
  of calling `Instant.now()` directly) — ties back to Phase 12
- Testing concurrent code (tricky — awaitility-style polling, avoiding
  flaky sleeps)

### Integration testing
- Testcontainers basics (spinning up a real DB/queue in a container for
  integration tests)
- `@SpringBootTest`/Quarkus `@QuarkusTest` equivalents (just enough
  awareness, since your stated direction is Quarkus)

### TDD practice
- Red-Green-Refactor cycle, practiced deliberately on a few small
  katas before relying on it in the capstone

---

## Phase 30 — Capstone
**Duration:** Weeks 36–40

Build a serious project: **Java Data Processing & Event Processing
Engine**.

### Architecture
```
Input files
   ↓
Parser
   ↓
Validation
   ↓
Transformation
   ↓
Streams
   ↓
Aggregation
   ↓
Async processing
   ↓
Virtual threads
   ↓
Persistence
   ↓
Reporting
```

### Implement
CSV processing, JSON processing, employee/order events, deduplication,
grouping, aggregation, sorting, filtering, parallel processing
experiments, `CompletableFuture`, `ExecutorService`, virtual threads,
concurrent collections, records, sealed interfaces, pattern matching,
`java.time`, NIO, exception handling.

And deliberately benchmark multiple implementations.

### (NEW) Additional capstone requirements, given the added phases
- **Build with Maven or Gradle** as a proper multi-module project, not
  ad-hoc `javac` compilation.
- **Full test suite**: unit tests (JUnit 5 + Mockito) for every
  non-trivial class, plus at least one Testcontainers-based integration
  test if persistence is involved.
- **Logging** throughout via SLF4J, with sensible log levels, instead of
  `System.out.println`.
- **Apply at least 3 design patterns deliberately** (e.g. Strategy for
  pluggable parsers, Builder for constructing complex report objects,
  Decorator for wrapping input streams) and be able to explain the
  choice.
- Use **enums and sealed interfaces** for the event/domain model instead
  of string/int flags.

---

## Summary of what changed vs. the original document

| Gap identified | Fix added |
|---|---|
| Missing Phase 29 (numbering gap) | Restored as **Testing Mastery** |
| No testing content anywhere | Full JUnit 5 / Mockito / AssertJ / Testcontainers / TDD phase |
| No build tools | New Phase 0 |
| No nested/inner/anonymous/local classes | Added to Phase 1 |
| No String internals (pool, interning, builder vs buffer, caching) | Added to Phase 1 |
| Enums only mentioned via `EnumMap` | New Phase 2.5 |
| No serialization / deep vs shallow copy | New Phase 13.5 |
| No logging | New Phase 14.5 |
| No `ThreadLocal` / Fork-Join | New Phase 18.5 |
| Design patterns only a 2-word bullet | New Phase 27.5, full catalog |
| Capstone didn't require tests/build tool/patterns | Added explicit capstone requirements |

This enhanced version keeps 100% of the original's strong functional,
Streams, and concurrency depth, while closing the gaps that would
otherwise leave visible blind spots relative to a genuinely senior
(10-year-equivalent) Java engineer.
