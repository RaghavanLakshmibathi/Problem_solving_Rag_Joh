# Justice Hub — Java Programs Guide (Programs #3–#7)

A simple guide to understand each program. Every program is themed around the **Justice Hub** domain (court cases, judges, plaintiffs, appeals).

- Main application file: `src/JusticeHub.java`
- Each program below is a **separate, runnable file** with its own `main` method.

## How to Compile & Run

From the project root:

```powershell
javac -d out src\*.java
java -cp out Program3_Inheritance
java -cp out Program4_CustomArrayList
java -cp out Program5_OverloadingOverriding
java -cp out Program6_Collections
java -cp out Program7_StringPool
```

---

## Program #3 — Inheritance
File: `src/Program3_Inheritance.java`

Shows **Simple** and **Multilevel** inheritance plus **code reusability**.

Hierarchy:

```
LegalCase            (base: caseId, plaintiffName, status, showCase())
   └─ CourtTrial     (adds: judgeName, hearingDate)      → Simple Inheritance
        └─ AppealCase (adds: appealReason, higherCourt)  → Multilevel Inheritance
```

Key ideas:
- `LegalCase` holds the fields every case needs — written **once**, inherited by all.
- `CourtTrial` reuses the base constructor with `super(...)` and the `showCase()` method.
- `AppealCase` reuses `CourtTrial`, which reuses `LegalCase` → the multilevel chain.

Viva angle: A court case *is a* legal case; an appeal *is a* court case. This real "is-a" relationship is why inheritance fits the domain and avoids duplicate code.

> Note: the class is named `CourtTrial` (not `CourtCase`) to avoid clashing with the `CourtCase` class already in `JusticeHub.java`.

---

## Program #4 — Custom ArrayList (Multilevel Inheritance)
File: `src/Program4_CustomArrayList.java`

Builds a mini ArrayList that stores case IDs.

Hierarchy:

```
CustomCollection   (interface: the rules — add, get, remove, size, isEmpty, contains, display)
   └─ CustomList    (abstract class: common code — size(), isEmpty(), contains())
        └─ CustomArrayList (concrete class: add(), get(), remove(), display() + auto-grow)
```

Key ideas:
- The **interface** defines *what* a collection must do.
- The **abstract class** provides shared logic once (so children don't rewrite it).
- The **concrete class** fills in the remaining details and grows the array when full.

Basic operations demonstrated: `add`, `get`, `remove`, `size`, `isEmpty`, `contains`, `display`, and automatic resizing.

---

## Program #5 — Method Overloading & Overriding
File: `src/Program5_OverloadingOverriding.java`

- **Overloading** (same name, different parameters):
  - `registerCase(plaintiff)`
  - `registerCase(plaintiff, judge)`
  - `registerCase(plaintiff, judge, caseType)`
- **Overriding** (child redefines a parent method):
  - `CaseRegister.showPriority()` prints `Normal`
  - `UrgentCaseRegister.showPriority()` prints `URGENT` (runtime polymorphism)

Viva angle: overloading = flexible ways to register a case; overriding = urgent cases behave differently from normal ones.

---

## Program #6 — Built-in Collections
File: `src/Program6_Collections.java`

Uses Java's ready-made collections with court data:

| Collection | Used for | Behavior |
|-----------|----------|----------|
| `ArrayList` | Registered case IDs | Ordered, allows duplicates, indexed access |
| `HashMap`  | Case → Judge mapping | Key-value lookup |
| `HashSet`  | Unique judge names | Ignores duplicates |

---

## Program #7 — String Pool
File: `src/Program7_StringPool.java`

Explains how Java stores Strings using judge names:

- Two string **literals** with the same text share one pooled object → `==` is `true`.
- `new String("...")` creates a **separate** heap object → `==` is `false`.
- `.intern()` returns the pooled version → `==` becomes `true` again.

Lesson: always compare case data / judge names with `.equals()`, never `==`.

---

## Quick Summary

| Program | File | Concept |
|--------|------|---------|
| #3 | `Program3_Inheritance.java` | Simple + Multilevel inheritance, reusability |
| #4 | `Program4_CustomArrayList.java` | Interface → Abstract → Concrete (custom list) |
| #5 | `Program5_OverloadingOverriding.java` | Overloading & Overriding |
| #6 | `Program6_Collections.java` | ArrayList, HashMap, HashSet |
| #7 | `Program7_StringPool.java` | String pool & `.equals()` vs `==` |
