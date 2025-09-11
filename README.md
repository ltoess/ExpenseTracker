# Expense Tracker (Java, CLI)

A lightweight **command-line Java application** for tracking personal expenses with categories, dates, and descriptions.  
This project was built to strengthen **object-oriented programming skills** while practicing with enums, collections, and file I/O.  

---

## Features
- Add new expenses with amount, category, date, and description.  
- List expenses in **clean, tabular console output**. 
- Remove expenses by index.  
- Categorize spending with enums (`FOOD`, `GROCERIES`, `TRANSPORT`, `ENTERTAINMENT`, `UTILITIES`, `OTHER`).  
- Save and load expense data from a **TSV file**.  
- Generate totals by category or by month.  
-  Menu-driven interface for intuitive navigation.  

---

## Technologies
- Java 17 (Adoptium)
  
---

## Getting Started

### Option 1: Run from terminal
```bash
java -jar ExpenseTracker.jar
```

### Option 2: Run on Windows
Double-click `RunExpenseTracker.bat`  
This will open a console window and launch the app.

⚠️ *Note: The project includes a sample `expenses.tsv` file as proof of concept. You can safely delete it to start fresh.*

---

## Project Structure
```
src/                   → Java source files
bin/                   → Compiled .class files
ExpenseTracker.jar     → Runnable JAR build
RunExpenseTracker.bat  → Windows launcher script
expenses.tsv           → Created at runtime for expense data
```

---

## Example Session
```
==== Expense Tracker ====
1) Add expense
2) List expenses
3) Remove expense
4) Total by category
5) Monthly total
6) Save to file
7) Load from file
0) Exit

Choose: 1
Amount (e.g., 12.50): 19.99
Category [FOOD, GROCERIES, TRANSPORT, ENTERTAINMENT, UTILITIES, OTHER]: ENTERTAINMENT
Date (YYYY-MM-DD) [leave blank for today]:
Description (optional): Movie ticket

Added: 2025-09-10 | ENTERTAINMENT | $19.99 | Movie ticket
```

---

## Why This Project?
I created this project to:
- Practice **clean object-oriented design** with classes (`Expense`, `ExpenseManager`, `FileManager`, `App`).  
- Reinforce the use of **enums** for consistent data handling.  
- Implement **file persistence** using Java I/O.  
- Package and distribute a **runnable JAR application**.  
