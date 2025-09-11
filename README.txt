Hello! Thank you for downloading! -Luke

# Expense Tracker (Java, CLI)

A lightweight command-line application to track personal expenses with categories, dates, and descriptions.
Built to practice object-oriented programming, enums, collections, and file I/O in Java.

---

## Features
- Add, list, and remove expenses.
- Categorize expenses using an enum (FOOD, GROCERIES, TRANSPORT, ENTERTAINMENT, UTILITIES, OTHER).
- Save and load expenses to and from a .tsv file.
- Console output with neatly formatted, aligned columns.
- Menu-driven interface for easy navigation.

---

## Technologies
- Java 17 (Adoptium)
- Core Java libraries (java.util, java.time, java.io, etc.)
- No external dependencies

---

## Running the App

Option 1: From terminal
    java -jar ExpenseTracker.jar

Option 2: Double-click (Windows)
- Use the included RunExpenseTracker.bat file. This opens a console window and runs the app.

## NOTE ##
This comes with sample expenses already stored. Feel free to remove it - it is just a proof of concept. 

---

## File Structure
src/                   - Java source files
bin/                   - Compiled .class files
ExpenseTracker.jar     - Runnable JAR build
RunExpenseTracker.bat  - Windows launcher script
expenses.tsv           - (created at runtime) expense data file

---

## Example Usage
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

---

## Why I Built This
I wanted a personal project to practice:
- Clean object-oriented design (Expense, ExpenseManager, FileManager, App)
- Using enums for data consistency
- Saving and loading data with file I/O
- Building and running a runnable JAR for distribution
