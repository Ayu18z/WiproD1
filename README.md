 # 🤚 Hi, I am **Ayush Kumar**

## 📘 About this Repository  
This repository is created to upload and maintain my **daily practice and learning progress** during the **Wipro-NGA Training Program**, which started on **24th October 2025**.

---

## 🧠 Training Focus Areas  
The Wipro-NGA training includes hands-on learning and assignments in:  
- Core Java (OOPs, Collections, Exception Handling, Multithreading)  
- SQL and Database Concepts  
- Data Structures and Algorithms  
- Web Fundamentals (HTML, CSS, JavaScript)  
- Professional Communication and Aptitude  

---

## 📅 Day by Day Structure  
Each folder or package in this repository corresponds to a specific **day or topic** covered during training.  
and here is the breakdown of each days learning
# 🧠 Wipro-NGA Java Training — Daily Learning Summary  
**Author:** Ayush Kumar  
**Start Date:** *24th October 2025*  
**Purpose:** This repository contains my daily notes, practice codes, and summaries from Wipro-NGA Java training.
---

## 📅 Day 1 – Java Basics & Git Introduction

### 🔹 Topics Covered:
- **Java Overview:**
  - High-level, platform-independent, object-oriented language.
  - WORA — *Write Once, Run Anywhere*.
  - Uses **JVM**, **JRE**, and **JDK**.
- **Core Concepts:**
  - Bytecode (`.class` file) → Executed by JVM.
  - Primitive & Non-Primitive Datatypes.
  - Conditional Statements (if-else, switch).
  - Loops (for, while, do-while).
  - Operators (Arithmetic, Relational, Logical, etc.)
- **Git & Version Control:**
  - Git commands: `git init`, `git add`, `git commit -m`, `git status`
  - Concepts: Repository, Staging Area, Commits.
  - Importance of Version Control (Tracking & Collaboration).

### 💡 Practice:
- JShell basics.
- Programs: Sum of numbers, Palindrome checker.

---

## 📅 Day 2 – Control Statements & Loops

### 🔹 Topics Covered:
- **Conditional Statements:**
  - If-Else Ladder.
  - Switch Case.
- **Loops:**
  - For Loop, While Loop, Do-While.
- **Operators Recap:**
  - Logical (`&&`, `||`), Relational (`>`, `<`, `!=`), Ternary.
- **Hands-on:**
  - Patterns using loops.
  - Logical programs (even/odd, prime numbers).

---

## 📅 Day 3 – Object-Oriented Programming (OOPs) Introduction

### 🔹 Topics Covered:
- What is OOPs? → *Object-Oriented Programming System*
- Difference between **Procedural Programming** and **OOPs**.
- **Classes and Objects** creation.
- **Constructors** and their types.
- Pillars of OOP:
  - Encapsulation
  - Inheritance
  - Polymorphism
  - Abstraction

---

## 📅 Day 4 – Inheritance, Abstraction & Interfaces

### 🔹 Topics Covered:
- **Inheritance:**
  - Reusability of code using `extends`.
  - Types: Single, Multi-Level, Hierarchical, Multiple (via Interface), Hybrid.
  - `super` keyword usage.
- **Interfaces:**
  - Blueprint of a class using `implements`.
  - Helps in achieving **abstraction** & **multiple inheritance**.
- **Encapsulation:**
  - Use of access modifiers (`private`, `public`, `protected`, default).
  - Getters & Setters for controlled access.
- **Abstraction:**
  - Hiding complex implementation details.
  - Achieved using **abstract classes** or **interfaces**.

### 💡 Practice:
1. `SmartDevice` class implementing `Camera` & `Phone` interfaces.
2. `Person` and `Student` class using `super` and method overriding.
3. `BankAccount` class using Encapsulation.

---

## 📅 Day 5 – Access Modifiers & Exception Handling

### 🔹 Topics Covered:
- **Access Modifiers Table:**

| Modifier | Same Class | Same Package | Subclass (Diff. Package) | Everywhere |
|-----------|-------------|--------------|--------------------------|-------------|
| public | ✅ | ✅ | ✅ | ✅ |
| private | ✅ | ❌ | ❌ | ❌ |
| protected | ✅ | ✅ | ✅ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |

- **Exception Handling:**
  - What is an Exception? → Unexpected runtime error.
  - **Types:** Checked, Unchecked, Errors.
  - **Keywords:** try, catch, throw, throws, finally.
  - Finally block used for cleanup (e.g., closing files, DB connections).

### 💡 Practice:
1. Handle ArithmeticException (division by zero).
2. Prevent accessing invalid array index.

---

## 📅 Day 6 – Polymorphism, Typecasting, Wrapper Classes & Generics

### 🔹 Topics Covered:
- **Polymorphism:**
  - Many forms of the same method (Overloading & Overriding).
- **Typecasting:**
  - Converting one data type to another.
  - **Primitive:**
    - Widening (Implicit)
    - Narrowing (Explicit)
  - **Object:**
    - Upcasting (Subclass → Superclass)
    - Downcasting (Superclass → Subclass)
- **Wrapper Classes:**
  - Object representation of primitive data types.
  - Used in Collections.
  - **Boxing:** Primitive → Object  
    **Unboxing:** Object → Primitive
- **Generics:**
  - Type-safe code using `<Type>`.
  - Avoids wrong data type insertion in collections.
  - Example:  
    ```java
    List<Integer> list = new ArrayList<>();
    list.add(10); // Only Integer allowed
    ```

### 💡 Practice:
- Implement Upcasting & Downcasting with Vehicle, Car, Bike classes.
- Create a generic `Box<T>` class to store and retrieve items.

---

## 🧩 Overall Learning Themes
- Write reusable, readable, and efficient code.
- Apply OOP principles to real-world problems.
- Understand memory safety, exception control, and data type flexibility.
- Use Git for version control and collaboration.

---

## 🚀 Upcoming Goals
- Practice more on **Collections Framework**.
- Learn **Streams and Lambda Expressions**.
- Deep dive into **File Handling** and **Multithreading**.
- Build small Java projects integrating all concepts.

---

**“Code → Learn → Break → Fix → Master” 💪**


# 👋 Hi, I’m Ayush Kumar

## 🧠 Wipro-NGA Java Training Repository  
This repository contains my **daily Java practice and notes** during the **Wipro-NGA Training**, which started on **24th October 2025**.  
Each day includes Java concepts, notes, exercises, and mini-programs that help strengthen my understanding of Core Java and related technologies.

---

## 📅 Day 7 — Collections Framework

### 🌿 Introduction
Collections in Java are used to **store, organize, and manipulate** groups of objects dynamically.  
They provide **data structures** that can grow and shrink in size, making data handling efficient and flexible.

**Key Points:**
- Group of objects represented as a single entity  
- Part of the **`java.util`** package  
- Supports **dynamic sizing**, **type safety (Generics)**, and **built-in algorithms** like sort, shuffle, reverse  

---

### ⚙️ Before Collections (Old Java)
- Fixed-size arrays  
- Different APIs for similar tasks  
- No standardization  
- No algorithm support  
- Type safety issues  

### ✅ After Collections
- Unified architecture  
- Dynamic size  
- Generics support  
- Built-in algorithms (sort, shuffle, reverse)  
- Simplified code  

---

## 🧩 Collections Framework Hierarchy

### 1️⃣ **List**
- **Ordered collection**, allows duplicates  
- Classes:
  - `ArrayList`
  - `LinkedList`
  - `Vector` *(Legacy)*
  - `Stack` *(Legacy)*

**Common Methods:**
`add()`, `remove()`, `get()`, `set()`, `size()`, `contains()`, `clear()`, `indexOf()`

#### 🔹 Practice Problems
1. Implement all List methods and observe outputs.  
2. Remove duplicate elements from a List (without using Set).  
   - **Input:** `[10, 30, 20, 20, 10, 30, 20, 40]`  
   - **Output:** `[10, 20, 30, 40]`
3. Reverse order and each word in a list of strings.  
   - **Input:** `["Java", "is", "fun"]`  
   - **Output:** `["nuf", "si", "avaJ"]`
4. Find the **second largest number** in a list.  
5. Merge two lists, remove duplicates, and sort them.  
   - **Input:** `[3, 5, 7, 5]` + `[2, 7, 8, 3]`  
   - **Output:** `[2, 3, 5, 7, 8]`

---
### 2️⃣ **Set**
- **No duplicates allowed**
- Unordered or ordered depending on implementation

| Type | Features |
|------|-----------|
| **HashSet** | No order, fastest, allows one null |
| **LinkedHashSet** | Maintains insertion order, allows one null |
| **TreeSet** | Sorted order, no null allowed |

**Common Methods:**  
`add()`, `remove()`, `size()`, `contains()`, `clear()`

#### 🔹 Practice Problems
1. Implement all Set methods using different implementations.  
2. Find **common elements** between two lists.  
   - **Input:** `[1, 2, 3, 4]`, `[3, 4, 5, 6]` → **Output:** `[3, 4]`
3. Count unique words in a string.  
   - **Input:** `"Java is fun and Java is powerful"`
4. Check if two lists have **no common elements.**
5. Find the **first non-repeating character** in a string.  
   - **Input:** `"swiss"` → **Output:** `"w"`

---

### 3️⃣ **Queue**
- **FIFO (First-In-First-Out)** data structure  
- Allows duplicates  
- Supports priority-based ordering  
- Nulls depend on implementation

**Common Methods:**  
`add()`, `remove()`, `clear()`, `size()`

**Types:**
- Simple Queue  
- Priority Queue  
- Deque *(Double-ended queue)


