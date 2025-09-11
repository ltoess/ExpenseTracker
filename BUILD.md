## Build & Run (from Source)

These instructions let anyone clone the repo and run the app locally.

> **Prereqs**
> - JDK 17+ installed (`java -version` should show 17 or newer).

---

## Quick Start

```bash
# 1) Clone
git clone https://github.com/ltoess/ExpenseTracker.git
cd ExpenseTracker

# 2) Build (Unix/macOS/Linux)
./build.sh

# 3) Run
java -jar ExpenseTracker.jar
```

On Windows (PowerShell or Command Prompt):

```bat
REM 1) Clone
git clone https://github.com/ltoess/ExpenseTracker.git
cd ExpenseTracker

REM 2) Build
build.bat

REM 3) Run
java -jar ExpenseTracker.jar
```

> The app will (re)create `expenses.tsv` when you **save** or **exit via the menu**. If the file is missing at startup, loading simply yields an empty list.

---

## What the scripts do

- Compiles all sources in `src/` to `out/`
- Packages classes into `ExpenseTracker.jar`
- Sets the JAR entry point to the `App` class (`Main-Class: App`)

---

## Manual Build (no scripts)

```bash
# Compile to out/
mkdir -p out
javac -d out src/*.java

# Create manifest (entry point)
echo "Main-Class: App" > MANIFEST.MF

# Package jar
jar cfm ExpenseTracker.jar MANIFEST.MF -C out .

# Run
java -jar ExpenseTracker.jar
```

On Windows (PowerShell):

```powershell
mkdir out -ea 0
javac -d out src\*.java
'Main-Class: App' | Out-File -Encoding ascii MANIFEST.MF
jar cfm ExpenseTracker.jar MANIFEST.MF -C out .
java -jar ExpenseTracker.jar
```

---

## Troubleshooting

- **`'javac' is not recognized...`**  
  JDK is not on your PATH. Install JDK 17 and ensure `JAVA_HOME` and PATH are set.

- **VS Code users**  
  You can also run via the Java extension pack:
  1. Open the folder in VS Code
  2. Let it detect Java sources
  3. Click the run icon next to `public static void main` in `App.java`

---

## Running the Prebuilt JAR

You can run:

```bash
java -jar ExpenseTracker.jar
```

On Windows you can also double‑click `RunExpenseTracker.bat`.
